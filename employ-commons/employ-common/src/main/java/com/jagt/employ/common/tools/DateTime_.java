package com.jagt.employ.common.tools;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * 基于 JDK 8 time包的时间工具类
 * 
 * @version  1.2
 * @author   gotanks
 * @since     2019-09-12
 * 
 */
public final class DateTime_ {

    /**
     * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
     */
    private static final TimeFormat DEFAULT_FORMAT = TimeFormat.DATETIME_LINE;

    private DateTime_() {
        // no construct function
    }

    /*============================转LocalDateTime============================*/
    /**
     * String 转LocalDateTime
     *
     * @param timeStr
     * @return
     */
    public static LocalDateTime parseTime(String timeStr) {
        TimeFormat format = null;
        if(timeStr.length()>10){
            if(timeStr.contains(TimeFormat.LINE.pattern)){
                format = DEFAULT_FORMAT;
            }else if(timeStr.contains(TimeFormat.SLASH.pattern)){
                format = TimeFormat.DATETIME_SLASH;
            }else if(timeStr.contains(TimeFormat.DOUBLE_SLASH.pattern)){
                format = TimeFormat.DATETIME_DOUBLE_SLASH;
            }else {
                format = TimeFormat.DATETIME_NONE;
            }
        }else if(timeStr.length()==10){
            if(timeStr.contains(TimeFormat.LINE.pattern)){
                format = TimeFormat.DATE_LINE;
            }else if(timeStr.contains(TimeFormat.SLASH.pattern)){
                format = TimeFormat.DATE_SLASH;
            }else if(timeStr.contains(TimeFormat.DOUBLE_SLASH.pattern)){
                format = TimeFormat.DATE_DOUBLE_SLASH;
            }
        }else if(timeStr.length()==8){
            format = TimeFormat.DATE_NONE;
        }
        return parseTime(timeStr, format);
    }

    /**
     * String 转LocalDateTime
     *
     * @param timeStr
     * @param pattern  时间格式
     * @return
     */
    public static LocalDateTime parseTime(String timeStr, String pattern) {
        if(TimeFormat.isLocalDate(pattern) ){
            return LocalDate.parse(timeStr, getFormatter(pattern)).atStartOfDay();
        }else{
            return LocalDateTime.parse(timeStr, getFormatter(pattern));
        }
    }

    /**
     * String 转LocalDateTime
     *
     * @param timeStr
     * @param format  时间格式
     * @return
     */
    public static LocalDateTime parseTime(String timeStr, TimeFormat format) {
        return parseTime(timeStr, format.pattern);
    }

    /** 
     * Date 转 LocalDateTime 
     * 
     * @param date 
     * @return LocalDateTime 
     */  
    public static LocalDateTime parseTime(Date date) {
//        long nanoOfSecond = (date.getTime() % 1000) * 1000000;
//        return LocalDateTime.ofEpochSecond(date.getTime() / 1000, (int) nanoOfSecond, ZoneOffset.of("+8"));
        return instantToLocalDateTime(date.toInstant());
    }

    /** 
     * Timestamp 转 LocalDateTime 
     * 
     * @param timestamp Timestamp
     * @return LocalDateTime 
     */  
    public static LocalDateTime parseTime(Timestamp timestamp) {
//    	return LocalDateTime.ofEpochSecond(date.getTime() / 1000, date.getNanos(), ZoneOffset.of("+8"));
        return instantToLocalDateTime(timestamp.toInstant());
    }

    /** 
     * long 转 LocalDateTime 
     * 
     * @param timestamp 毫秒
     * @return LocalDateTime 
     */  
    public static LocalDateTime parseTime(long timestamp) {
//    	Instant instant = Instant.ofEpochMilli(timestamp);
//        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return instantToLocalDateTime(Instant.ofEpochMilli(timestamp));
    }

    //内部方法
    private static LocalDateTime instantToLocalDateTime(Instant instant){
        return instant.atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /*============================转long============================*/
    /**
     * LocalDateTime转 long
     *
     * @param time
     * @return long 毫秒
     */
    public static long parseLong(LocalDateTime time) {
    	return time.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * String转 long
     *
     * @param timeStr
     * @return long 毫秒
     */
    public static long parseLong(String timeStr) {
        return parseLong(parseTime(timeStr));
    }

    /**
     * String 转 long
     *
     * @param timeStr
     * @param format  时间格式
     * @return
     */
    public static long parseLong(String timeStr, TimeFormat format) {
        return parseLong(parseTime(timeStr, format));
    }

    /**
     * String 转 long
     *
     * @param timeStr
     * @param pattern  时间格式
     * @return
     */
    public static long parseLong(String timeStr, String pattern) {
        return parseLong(parseTime(timeStr, pattern));
    }

    /**
     * Date转 long
     *
     * @param date
     * @return long 毫秒
     */
    public static long parseLong(Date date) {
        return parseLong(parseTime(date));
    }

    /**
     * Timestamp转 long
     *
     * @param timestamp
     * @return long 毫秒
     */
    public static long parseLong(Timestamp timestamp) {
        return parseLong(parseTime(timestamp));
    }

    /*============================转String============================*/
    /**
     * LocalDateTime转 String
     *
     * @param time
     * @return String
     */
    public static String parseString(LocalDateTime time) {
        return parseString(time, DEFAULT_FORMAT);
    }

    /**
     * LocalDateTime转 String
     *
     * @param time
     * @param pattern 时间格式
     * @return String
     */
    public static String parseString(LocalDateTime time, String pattern) {
        return getFormatter(pattern).format(time);
    }

    /**
     * LocalDateTime转 String
     *
     * @param time
     * @param format 时间格式
     * @return String
     */
    public static String parseString(LocalDateTime time, TimeFormat format) {
        return parseString(time, format.pattern);
    }

    /**
     * long转 String
     *
     * @param timestamp
     * @return String
     */
    public static String parseString(long timestamp) {
    	return parseString(parseTime(timestamp));
    }

    /**
     * long转 String
     *
     * @param timestamp
     * @param format  时间格式
     * @return String
     */
    public static String parseString(long timestamp, TimeFormat format) {
    	return parseString(parseTime(timestamp), format);
    }

    /**
     * long转 String
     *
     * @param timestamp
     * @param pattern  时间格式
     * @return String
     */
    public static String parseString(long timestamp, String pattern) {
        return parseString(parseTime(timestamp), pattern);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDatetime() {
        return getCurrentDatetime(DEFAULT_FORMAT);
    }

    /**
     * 获取当前时间
     *
     * @param pattern 时间格式
     * @return
     */
    public static String getCurrentDatetime(String pattern) {
        return getFormatter(pattern).format(LocalDateTime.now());
    }

    /**
     * 获取当前时间
     *
     * @param format 时间格式
     * @return
     */
    public static String getCurrentDatetime(TimeFormat format) {
        return getCurrentDatetime(format.pattern);
    }


    /**
        获取日期时间转换器，内部方法
     */
    private static DateTimeFormatter getFormatter(String format){
        return DateTimeFormatter.ofPattern(format);
    }

    /**
     * 时间格式
     */
    public enum TimeFormat {
        /**
         * 分隔符
         */
        LINE("-"),
        SLASH("/"),
        DOUBLE_SLASH("\\"),
        COLON(":"),

        /**
         * 格式：单独
         */
        YEAR("yyyy"),
        MONTH("MM"),
        DAY("dd"),
        HOUR("HH"),
        MINUTE("mm"),
        SECOND("ss"),
        MILSEC("SSS"),

        /**
         * 格式：年-月
         */
        DATE_MONTH_LINE("yyyy-MM"),
        DATE_MONTH_SLASH("yyyy/MM"),
        DATE_MONTH_DOUBLE_SLASH("yyyy\\MM"),
        DATE_MONTH_NONE("yyyyMM"),

        /**
         * 短时间格式
         */
        DATE_LINE("yyyy-MM-dd"),
        DATE_SLASH("yyyy/MM/dd"),
        DATE_DOUBLE_SLASH("yyyy\\MM\\dd"),
        DATE_NONE("yyyyMMdd"),

        /**
         * 长时间格式
         */
        DATETIME_LINE("yyyy-MM-dd HH:mm:ss"),
        DATETIME_SLASH("yyyy/MM/dd HH:mm:ss"),
        DATETIME_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),
        DATETIME_NONE("yyyyMMdd HH:mm:ss"),

        /**
         * 长时间格式 带毫秒
         */
        DATETIME_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),
        DATETIME_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),
        DATETIME_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),
        DATETIME_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS");

        private transient String pattern;
//        private transient DateTimeFormatter formatter;

        TimeFormat(String pattern) {
            this.pattern = pattern;
//            formatter = DateTimeFormatter.ofPattern(pattern);
        }

        public boolean equals(String str){
            return this.pattern.equals(str);
        }

        public static boolean isLocalDate(String pattern){
            return TimeFormat.DATE_LINE.equals(pattern)
                    || TimeFormat.DATE_SLASH.equals(pattern)
                    || TimeFormat.DATE_DOUBLE_SLASH.equals(pattern)
                    || TimeFormat.DATE_NONE.equals(pattern);
        }
    }


}