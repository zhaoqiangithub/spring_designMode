package zq.pool_review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/7 14:22
 * @Version 1.0
 **/
public class MyPoolManager implements IMyPoolManager {
    //连接池容器
    private Vector<MyConnectionPool> pools = new Vector<>();
    private static  String jdbcDriver ;
    private static  String jdbcURL ;
    private static  String jdbcUsername ;
    private static  String jdbcpassword ;

    private static  int initCount ;
    //连接池不足时每次增长值
    private static  int step ;
    //连接池最大二的数据
    private static  int maxCount ;

    /*
    私有构造方法
     */
    private MyPoolManager(){
        //初始化配置文件
        init();
        //初始化连接池的同时，初始化数据库驱动
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //连接池初始化的时候，创建出最小连接数的连接到 容器中
        createMyConnectionPool(initCount);
    }

    private void init() {
        jdbcDriver = DBConfigXML.jdbcDriver;
        jdbcURL = DBConfigXML.jdbcURL;
        jdbcUsername = DBConfigXML.jdbcUsername;
        jdbcpassword = DBConfigXML.jdbcpassword;
        initCount = DBConfigXML.initCount;
        step = DBConfigXML.step;
        maxCount = DBConfigXML.maxCount;
    }

    /**
     * 核心逻辑：如果连接池中有空闲连接，则返回给客户；如果没有，判断是否到最大连接数，如果没到新建step个连接。如果到了，抛异常给客户
     * @return
     */
    @Override
    public  MyConnectionPool getMyConnectionPool() {
        //对连接池的非空校验
        if(pools.size() < 0){
            throw new RuntimeException("连接池为空");
        }

        //从连接池中获取可用连接，如果没有返回空
        MyConnectionPool myConnectionPool = null;
        try {
            myConnectionPool = getRealConnection();

            //如果有直接返回给客户，如果没有 判断是否到最大连接数，到了抛异常，没到在连接池中新增连接，并返回给客户
            while (myConnectionPool == null){
                //新增连接到连接池（里面有判断是否到最大连接的逻辑）
                createMyConnectionPool(step);
                myConnectionPool = getRealConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myConnectionPool;
    }

    /**
     * 获取连接池的可用连接
     * @return 如果连接空闲，就返回连接；如果全都被占用，就返回空
     */
    private  synchronized MyConnectionPool getRealConnection() throws SQLException {
        //遍历连接池容器
        for (MyConnectionPool myConnectionPool: pools) {
            if(!myConnectionPool.isBusy()){//如果空闲
                //Connection创建出来，如果长时间不用，会失效。判断是否失效。如果失效重新赋值Connection；如果没有则返回，并更改状态
                if(myConnectionPool.getConnection().isValid(3000)){
                    myConnectionPool.setBusy(true);
                    return myConnectionPool;
                }else {
                    Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcpassword);
                    myConnectionPool.setConnection(connection);
                    myConnectionPool.setBusy(true);
                    return myConnectionPool;
                }
            }
        }
        return null;
    }

    /**
     * 创建连接池中的连接实例
     * @param step
     */
    @Override
    public void createMyConnectionPool(int step) {
        //此处逻辑有两个地方调用，首次启动时调用，和连接池扩容时调用
        //为了避免，客户在配置时，配置的初始连接出大于最大连接数，所以把对 连接数的校验逻辑放到此处
        if(pools.size() > maxCount && pools.size() + step > maxCount){
            throw new RuntimeException("连接池已经到最大连接数，不能扩容");
        }

        //创建连接，并添加到容器中，状态为空闲
        for (int i = 0;i < step; i++){
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcpassword);
                MyConnectionPool myConnectionPool = new MyConnectionPool();
                myConnectionPool.setConnection(connection);
                myConnectionPool.setBusy(false);
                pools.add(myConnectionPool);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //获取单例方法入口
    public static MyPoolManager getInstance(){
        return LazyHolder.INSTANCE;
    }
    private static final  class LazyHolder{
        private static final MyPoolManager INSTANCE = new MyPoolManager();
    }


}
