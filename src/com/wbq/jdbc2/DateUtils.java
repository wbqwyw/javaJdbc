package com.wbq.jdbc2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/8 14:17
 * @Version 1.0
 */
public class DateUtils {
    private static final SimpleDateFormat SIMPLEDATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date strToDate(String date) {
        try {
            return SIMPLEDATEFORMAT.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToStr(Date date) {
        return SIMPLEDATEFORMAT.format(date);
    }

    public static java.sql.Date utilDateToSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

}
