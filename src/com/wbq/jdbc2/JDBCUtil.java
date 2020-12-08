package com.wbq.jdbc2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName JDBCUtil
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/8 10:17
 * @Version 1.0
 */
public class JDBCUtil {
    private static final Properties prop = new Properties();

    static {
        InputStream resourceAsStream = JDBCUtil.class.getResourceAsStream("/jdbc.properties");
        try {
            prop.load(resourceAsStream);
            Class.forName(prop.getProperty("driver"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public static void closeAll(ResultSet rs, Statement st,Connection con){
        try {
            if (rs!=null){
                rs.close();
            }
            if (st!=null){
                st.close();
            }
            if (con!=null){
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
