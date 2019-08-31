package zq.pool_review;

import zq.pool.core.MyDefaultPool;

import java.util.Vector;

/*
 连接池 管理动作抽象
 主要是 获取连接 和创建连接
 */
public interface IMyPoolManager {



    MyConnectionPool getMyConnectionPool();

    void createMyConnectionPool(int step);
}
