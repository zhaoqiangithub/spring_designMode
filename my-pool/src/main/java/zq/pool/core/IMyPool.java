package zq.pool.core;

/**
 * 对连接池进行基本管理的api接口
 * 可以得到数据库操作的管道/可以创建数据库管道
 **/
public interface IMyPool {
    /*
    获取连接池对的连接管道（也可称为连接）（在jdbc上做了一层封装）
     */
    MyPooledConnection getMyPooledConnection();

    /*
    创建连接池的连接管道（也可称为连接）
     */
     void createMyPooledConnection(int count);
}
