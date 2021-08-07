package com.pers.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {

        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接池中的连接
     * @return 返回值为null，连接失败
     */
    public static Connection getConnection(){
//        Connection connection = null;
//
//        try {
//            connection = dataSource.getConnection();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return connection;
        Connection conn = conns.get();

        if(conn == null){
            try {
                conn = dataSource.getConnection();

                conns.set(conn); // 保存到ThreadLocal对象中

                conn.setAutoCommit(false); // 设置为手动管理事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return conn;
    }

    public static void commitAndClose(){
        Connection conn = conns.get();

        if(conn != null){

            try {
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();

    }

    public static void rollbackAndClose(){
        Connection conn = conns.get();

        if(conn != null){

            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }

//    /**
//     * 关闭连接，返回数据库连接池
//     * @param connection 数据库连接
//     */
//    public static void close(Connection connection){
//        if(connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//    }
}
