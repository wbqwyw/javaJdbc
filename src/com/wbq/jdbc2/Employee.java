package com.wbq.jdbc2;

import java.sql.Date;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/8 14:25
 * @Version 1.0
 */
public class Employee {
    private int code;
    private String name;
    private String address;
    private Date borthdate;

    public Employee() {
    }

    public Employee(String name, String address, Date borthdate) {
        this.name = name;
        this.address = address;
        this.borthdate = borthdate;
    }

    public Employee(int code,String name, String address, Date borthdate) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.borthdate = borthdate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBorthdate() {
        return borthdate;
    }

    public void setBorthdate(Date borthdate) {
        this.borthdate = borthdate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", borthdate=" + borthdate +
                '}';
    }
}
