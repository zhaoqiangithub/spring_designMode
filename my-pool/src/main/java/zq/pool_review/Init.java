package zq.pool_review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/7 15:55
 * @Version 1.0
 **/
public class Init {
    public static void main(String[] args)  {

        MyPoolManager myPoolManager = new MyPoolManager();
        Runnable aaa = new Runnable() {
            @Override
            public void run() {
                impl(myPoolManager);
            }
        };
        for(int i =0 ;i < 100 ;i++) {
            Thread thread = new Thread(aaa);
            thread.start();
        }

    }

    //并发测试 100线程并发获取连接池的连接
    //最大连接数 60 增长2 连接62次
    //最大连接数 60 增加3 连接61次
    //疑问？
    private static  void impl( MyPoolManager myPoolManager){

        //保证多线程环境下，MyPoolManager 单例
        MyConnectionPool myConnectionPool = myPoolManager.getMyConnectionPool();

        Connection connection = myConnectionPool.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from courses");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id +" "+ name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}