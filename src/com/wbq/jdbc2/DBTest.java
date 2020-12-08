package com.wbq.jdbc2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName DBTest
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/8 10:29
 * @Version 1.0
 */
public class DBTest {
    public static void main(String[] args) {
        Connection con = JDBCUtil.getConnection();
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employee");
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(code + "\t" + name + "\t" + address);
            }
            JDBCUtil.closeAll(rs, st, con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
