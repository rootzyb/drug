package com.zyb.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 把日期格式转换成年月日(yyyy-MM-dd)的字符串
     */
    public static String dateConvert(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /*public static void main(String[] args) {
        System.out.println(DateUtil.dateConvert(new Date()));
    }*/
}
