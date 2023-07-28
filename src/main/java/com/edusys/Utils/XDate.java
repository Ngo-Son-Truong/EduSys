
package com.edusys.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class XDate {

    static SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
    // chuyển đổi String sang Data

    /*
        -@param data là String cần chuyển
        -@param pattern là đinh dạng thời gian
        -@return Date kết quả
     */
    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0 ) {
                formater.applyPattern(pattern[0]);
            }
            if (date == null) {
                return XDate.now();
            }
            return formater.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    // chuyển đổi Date sang String
        -@param data là Date cần chuyển
        -@param pattern là đinh dạng thời gian
        -@return String kết quả
     */
    public static String toString(Date date, String... pattern) {
        if (pattern.length >0) {
            formater.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = XDate.now();
        }
        return formater.format(date);
    }

    //Trả về thời gian hiện tại
    public static Date now() {
        return new Date();
    }

    /*
     // Bổ sung ngày vào thời gian
        -@param data  là thời gian hiện có
        -@param days số ngày cần bổ sung vào date
        -@return Date kết quả
     */
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
    public static Date add(int days) {
        Date now = XDate.now();
        now.setTime(now.getTime() + days * 24*60 *60 * 1000);
        return now;
    }
}
