package com.koalaIT.common.util;

import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public  class DateUtil extends DateUtils {
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
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    /**
     * 字符串转换到时间格式
     * @param dateStr 需要转换的字符串
     * @param formatStr 需要格式的目标字符串 举例 yyyy-MM-dd
     * @return Date 返回转换后的时间
     * @throws ParseException 转换异常
     */
    public static Date strToDate(String dateStr,String formatStr) {
        DateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 设置00:00:00
     * @param date
     * @return
     */
    public static Date setStartDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        return calendar.getTime();
    }

    /**
     * @param date
     * @return
     */
    public static Date setEndDay(Date date) {
        Date endDate = new Date(DateUtil.setStartDay(date).getTime() + 24 * 3600 * 1000-1000);
        String tempStr = DateUtil.strByDate(endDate,"yyyy-MM-dd HH:mm:ss");
        endDate = DateUtil.strToDate(tempStr,"yyyy-MM-dd HH:mm:ss");
        return endDate;
    }

    /**
     * 设置00:00
     * @param date
     * @return
     */
    public static Date setStartHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        return calendar.getTime();
    }

    /**
     * 设置59:59
     * @param date
     * @return
     */
    public static Date setEndHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static String toStringNormal(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 获取当月的第一天
     * @return
     */
    public static Date getFirstDayOfMonth(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return calendar.getTime();
    }

    /**
     * 获取当月的最后一天
     * @return
     */
    public static Date getLastDayOfMonth(Calendar calendar) {
        calendar.add(Calendar.MONTH,1);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
    }

    /**
     * 获取当前日期
     * @return
     */
    public static Date getCurrentDay() {
        Date curDate = new Date();
        String curDateStr = DateUtil.strByDate(curDate,"yyyy-MM-dd HH:mm:ss");
        curDate = DateUtil.strToDate(curDateStr,"yyyy-MM-dd");
        curDate = new Date(curDate.getTime() + (24 * 3600 * 1000 - 1000));
        curDateStr = DateUtil.strByDate(curDate,"yyyy-MM-dd HH:mm:ss");
        DateUtil.strToDate(curDateStr, "yyyy-MM-dd HH:mm:ss");
        return curDate;
    }



}
