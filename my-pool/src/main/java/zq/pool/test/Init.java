package zq.pool.test;

import zq.pool.core.MyDefaultPool;
import zq.pool.core.MyPooledConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/7 11:31
 * @Version 1.0
 **/
public class Init {
    public static void main(String[] args) {
        //初始化数据库连接池
        MyDefaultPool defaultPool = new MyDefaultPool();

        MyPooledConnection myPooledConnection = defaultPool.getMyPooledConnection();

        String sql = "select * from courses s where s.id=1";
        ResultSet query = myPooledConnection.query(sql);
        try {
//            System.out.println(query.getArray(1));
            while (query.next()){
                int id = query.getInt("id");
                String name = query.getString("name");
                String description = query.getString("discription");
                System.out.println(id + " "+ name+" "+description);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            Class.forName("com.mysql.jdbc.Driver");




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
