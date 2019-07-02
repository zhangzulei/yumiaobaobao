package com.yumiaobaobao.app.common.utils.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Created by WH on 2019/04/09.
 * 时间工具栏
 */
public class DateUtils {


    private static LocalDate localDate ;
    private static LocalTime localTime ;
    private static LocalDateTime localDateTime ;


    /**
     * Date转换为LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     * @param time
     * @return
     */
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }
    /**
     * 获取当前日期 yyyy-mm-dd
     * @return
     */
    public static LocalDate newDate(){
        localDate = LocalDate.now();
        return localDate;
    }

    /**
     * 获取当前时间 hh-mm-ss-ms
     * @return
     */
    public static LocalTime newTime(){
        localTime = LocalTime.now().withNano(0); //.withNano(0))清除毫秒数
        return localTime;
    }

    /**
     * 获取当前日期时间 yyyy-mm-dd hh-mm-ss-ms
     * @return
     */
    public static LocalDateTime newDateTime(){
        localDateTime = localDateTime.now().withNano(0);
        /*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String datetime=newDate().toString()+" "+ newTime().toString();
        LocalDateTime ldt = LocalDateTime.parse(datetime,df);*/
        return localDateTime;
    }

    /**
     * 取本月的第一天
     * @return
     */
    public static LocalDate dateOne(){
        localDate = LocalDate.now();
        LocalDate firstDayOfThisMonth = localDate.with(TemporalAdjusters.firstDayOfMonth()); // 2014-12-01
        return firstDayOfThisMonth;
    }

    /**
     * 取本月的最后一天
     * @return
     */
    public static LocalDate datelast(){
        localDate = LocalDate.now();
        LocalDate firstDayOfThisMonth = localDate.with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-01
        return firstDayOfThisMonth;
    }

}
