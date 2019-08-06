package zq.pool.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 封装Connection
 * 提供基本的sql查询功能
 * 数据库连接池时做到连接的复用
 * 客户端断开连接是真的断开么
 **/
public class MyPooledConnection {

    //连接池中的连接对象
    private Connection connection;
    //表示连接是否被占用
    private boolean isbusy = false;
    public MyPooledConnection(Connection connection,boolean isbusy){
        this.connection =connection;
        this.isbusy = isbusy;
    }


    public ResultSet query(String sql){
        Statement statement;
        ResultSet resultSet = null;

        //获取Connection，并且执行sql
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public boolean isIsbusy() {
        return isbusy;
    }

    public void setIsbusy(boolean isbusy) {
        this.isbusy = isbusy;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
