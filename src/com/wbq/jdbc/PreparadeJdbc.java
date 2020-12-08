package com.wbq.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName PreparadeJdbc
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/8 9:31
 * @Version 1.0
 */
public class PreparadeJdbc {
    public static void main(String[] args) {
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select * from employee where code = ?");
            ps.setObject(1, 1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(code + "\t" + name + "\t" + address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
