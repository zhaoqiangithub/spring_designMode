package zq.pool_review;

import java.sql.Connection;

/**
 包装过的Connection,连接池的基本单位
 在Connection上加了一层  判断空闲 /占用，用于判断连接的中是否有空闲的连接
 **/
public class MyConnectionPool {
    private Connection connection;
    private boolean busy;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
