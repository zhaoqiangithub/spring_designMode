package zq.pool.tools;

/**
 * @Description TODO
 * @@Author 27106
 * @Date 2019/8/6 15:11
 * @Version 1.0
 **/
public class DBConfigXML {
    public static final String jdbcDriver = "com.mysql.jdbc.Driver";
    public static final String jdbcURL = "";
    public static final String jdbcUsername = "";
    public static final String jdbcpassword = "";

    public static final int initCount = 10;
    //连接池不足时每次增长值
    public static final int step = 2;
    //连接池最大二的数据
    public static final int maxCount = 50;
    public static final int maxWaitTime = 3000;
}
