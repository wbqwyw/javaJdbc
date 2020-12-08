package com.wbq.jdbc2;

import java.util.List;

/**
 * @ClassName DBTest2
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/8 16:22
 * @Version 1.0
 */
public class DBTest2 {
    public static void main(String[] args) {
        System.out.println("------insert------");
        int insert = JDBCDaoImpl.insert(new Employee("zhangsan", "北清路", DateUtils.utilDateToSqlDate(DateUtils.strToDate("2020-12-08"))));
        System.out.println(insert);
        System.out.println("------update------");
        int update = JDBCDaoImpl.update(new Employee(9, "zhangsan", "西北旺", DateUtils.utilDateToSqlDate(DateUtils.strToDate("2020-12-08"))));
        System.out.println(update);
        System.out.println("------delete----");
        int delete = JDBCDaoImpl.delete(12);
        System.out.println(delete);

        System.out.println("------query-----");
        Employee em = JDBCDaoImpl.query(1);
        System.out.println(em);
        System.out.println("-------queryAll------");
        List<Employee> list = JDBCDaoImpl.query();
        list.stream().forEach(System.out::println);

    }

}
