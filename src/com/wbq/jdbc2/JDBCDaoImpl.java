package com.wbq.jdbc2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JDBCDaoImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/8 14:29
 * @Version 1.0
 */
public class JDBCDaoImpl {

    public static int update(Employee em) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtil.getConnection();
            ps = con.prepareStatement("update  employee set name=?,address=?,borthdate=? where code =?");
            ps.setString(1, em.getName());
            ps.setString(2, em.getAddress());
            ps.setDate(3, DateUtils.utilDateToSqlDate(em.getBorthdate()));
            ps.setInt(4, em.getCode());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static int insert(Employee em) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtil.getConnection();
            ps = con.prepareStatement(" insert into employee (name,address,borthdate)values(?,?,?)");
            ps.setString(1, em.getName());
            ps.setString(2, em.getAddress());
            ps.setDate(3, em.getBorthdate());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static int delete(int code) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtil.getConnection();
            ps = con.prepareStatement("delete from employee where code = ?");
            ps.setInt(1, code);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static Employee query(int code) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee em = new Employee();
        try {
            con = JDBCUtil.getConnection();
            ps = con.prepareStatement("select * from employee where code = ?");
            ps.setInt(1, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                int code1 = rs.getInt("code");
                String name = rs.getString("name");
                String address = rs.getString("address");
                Date borthdate = rs.getDate("borthdate");
                em.setCode(code1);
                em.setName(name);
                em.setAddress(address);
                em.setBorthdate(borthdate);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return em;
    }

    public static List<Employee> query() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<>();
        try {
            con = JDBCUtil.getConnection();
            ps = con.prepareStatement("select * from employee");
            rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("code");
                String name = rs.getString("name");
                String address = rs.getString("address");
                Date borthdate = rs.getDate("borthdate");
                Employee em = new Employee(code, name, address, borthdate);
                list.add(em);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
