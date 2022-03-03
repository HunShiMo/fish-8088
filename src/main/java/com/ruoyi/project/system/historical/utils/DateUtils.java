package com.ruoyi.project.system.historical.utils;

/**
 * 日期转换工具
 *
 * @author ray
 * @date 2021/11/22 20:27
 */
public class DateUtils {

    public static String dateFormat(String year, String month, String day) {
        month = month.length() == 2 ? month : "0" + month;
        day = day.length() == 2 ? day : "0" + day;
        return year + "-" + month + "-" + day;
    }

}
