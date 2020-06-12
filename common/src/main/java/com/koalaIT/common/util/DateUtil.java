package com.koalaIT.common.util;

import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public  class DateUtil extends DateUtils{
    /**
     *
     * @param date 时间
     * @param type  计算的类型
     * @param num   天数，月数，年数
     * @return
     */
    public static Date getDateCalc(Date date,int type,int num){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(type, num);
        return  cal.getTime();
    }

    public static String strByDate(Date date,String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(date);
    }
    /**
     * 字符串转换到时间格式
     * @param dateStr 需要转换的字符串
     * @param formatStr 需要格式的目标字符串 举例 yyyy-MM-dd
     * @return Date 返回转换后的时间
     * @throws ParseException 转换异常
     */
    public static Date StringToDate(String dateStr,String formatStr){
        DateFormat sdf=new SimpleDateFormat(formatStr);
        Date date=null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
