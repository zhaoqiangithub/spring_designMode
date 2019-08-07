package zq.pool.core;

import zq.pool.tools.DBConfigXML;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 这就是连接池
 * 加载连接池配置文件
 * 加载数据库驱动
 * 需要考虑用什么数据类型数据库连接池的存储容器 Vecter List
 *
 **/
public class MyDefaultPool implements IMyPool {
    //这里使用vecter，基于多线程的考虑使用了vecter
    private Vector<MyPooledConnection> pools = new Vector<>();
    private static String jdbcDriver;
    private static String jdbcURL ;
    private static String jdbcUsername ;
    private static String jdbcpassword ;
    private static int initCount ;
    private static int step ;
    private static int maxCount ;
    private static int maxWaitTime;

    //初始化
    public MyDefaultPool(){
        //初始化配置文件
        init();

        //初始化连接池对象时，加载数据库驱动
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //根据配置文件的的从数据库连接池中的初始连接数，初始化数据库连接池中的连接
        createMyPooledConnection(initCount);
    }

    private void init() {
        jdbcDriver = DBConfigXML.jdbcDriver;
        jdbcURL = DBConfigXML.jdbcURL;
        jdbcUsername= DBConfigXML.jdbcUsername;
        jdbcpassword = DBConfigXML.jdbcpassword;
        initCount = DBConfigXML.initCount;
        step = DBConfigXML.step;
        maxCount = DBConfigXML.maxCount;
        maxWaitTime = DBConfigXML.maxWaitTime;
    }

    /*
      根据数据库连接池的设计原则
      当客户需要连接时，首先判断连接池中是否有空闲的连接，如果有直接分配，如果没有，看现在数据库连接池中额的连接是否到
      最大连接数了，如果没有，创建连接返回给用户。如果满了，就按设定的最大连接时间进行等待，如果等待超时，就抛出异常给客户
     */
    @Override
    public MyPooledConnection getMyPooledConnection() {
        if(pools.size() < 1){
            throw new RuntimeException("初始化连接池异常");
        }
        //从数据库连接池获取 空闲的连接
        MyPooledConnection myPooledConnection = null;
        try {
            myPooledConnection = getRealConnectionPool();
            //如果没有可用连接，创建新连接
            //此处使用while， 不用if 为什么
            while (myPooledConnection == null){
                createMyPooledConnection(step);
                MyPooledConnection realConnectionPool = getRealConnectionPool();
                return realConnectionPool;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myPooledConnection;
    }

    /**
     * 避免并发时，被多个线程同时调用，导致判断 分配连接池中有效连接出错。如果池中目前只有一个有效连接，此时同时有两个线程从连接池中获取连接，
     * 第一个线程拿到连接还没有把状态置为忙之前，第一个也可以看到一个有效的连接。导致分配出去两个，导致报错
     * @return
     * @throws SQLException
     */
    private synchronized MyPooledConnection getRealConnectionPool() throws SQLException {
        //分配连接池中可用的连接
        for (MyPooledConnection myPooledConnection: pools) {
            if(!myPooledConnection.isIsbusy()){//如果连接对象 空闲
                //在线程池中的连接如果空闲太久,里面的Connection会超时，需要重新创建Connection，赋值给连接池的连接（连接管道）
                // 3000 jdbc的超时时间，等待和muysql数据库建立连接的超时时间.3000内建立连接，则不超时
                myPooledConnection.setIsbusy(true);//置为忙
                if(myPooledConnection.getConnection().isValid(3000)){
                    return myPooledConnection;
                }else {//如果数据库连接超时，重新创建连接
                    Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcpassword);
                    myPooledConnection.setConnection(connection);
                    return myPooledConnection;
                }
            }
        }
        //如果没有可用的连接，返回空
        return null;
    }


    @Override
    public void createMyPooledConnection(int step) {
        //创建连接时间，应该判断一下，当前连接和 新增后的连接是否大于最大连接数
        if(pools.size()>maxCount || pools.size()+ step > maxCount){
            //应该将客户的请求放到队列进行等待。同时判断客户的等待时间，如果大于最大等待时间，直接抛异常给客户。此时直接抛异常
            throw new RuntimeException("连接池已满");
        }
        for (int i = 0;i < step; i++) {//在数据库连接池中新增step个数据库连接
            try {
                //获取数据库连接对象
                Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcpassword);
                //创建自定义的连接，并将状态置为 空闲
                MyPooledConnection myPooledConnection = new MyPooledConnection(connection, false);
                //将自定义的连接放到连接池中
                pools.add(myPooledConnection);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("创建："+pools.size());

    }
}