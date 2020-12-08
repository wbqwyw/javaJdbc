package com.wbq.jdbc;

import java.sql.*;

/**
 * @ClassName DBUtils
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/8 9:20
 * @Version 1.0
 */
public class DBUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?characterEncoding=utf-8&useSSL=false", "wangbq", "123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
    public static void colseAll(ResultSet rs, Statement statement, Connection con){
        try {
            rs.close();
            statement.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
