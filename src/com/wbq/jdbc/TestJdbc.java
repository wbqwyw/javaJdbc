package com.wbq.jdbc;

import java.sql.*;
import java.util.Arrays;

/**
 * @ClassName TestJdbc
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/7 11:04
 * @Version 1.0
 */
public class TestJdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1?characterEncoding=utf-8&useSSL=false", "wangbq", "123456");
        if (con!=null){
            System.out.println("已连接数据库...");
        }else{
            System.out.println("连接数据库失败！");
        }
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee");
        System.out.println("code"+"\t"+"name"+"\t"+"address");
        while (resultSet.next()){
            String  code = resultSet.getString("code");
            String  name = resultSet.getString("name");
            String  address = resultSet.getString("address");
            System.out.println(code+"\t"+name+"\t"+address);
        }
        resultSet.close();
        statement.close();
        con.close();
    }

}
