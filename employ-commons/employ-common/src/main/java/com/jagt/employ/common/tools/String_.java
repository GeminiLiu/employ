package com.jagt.employ.common.tools;
/**
 *
 * String工具类，主要是string转为数字
 *
 * @version  1.0
 * @author   gotanks
 * @since     2019-07-17
 *
 */
public class String_ {
    /**
     * @Description: 粘贴自apache common lang包，避免依赖
     */
	public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description: 转为float类型，如果为null或者空字符串或者格式不对则返回0
     * @Param: [str]
     * @return: String
     */
    public static float parseFloat(String str){
        return parseFloat(str,0);
    }

    /**
     * @Description: 转为float类型 ，如果str为null或者空字符串或者格式不对则返回defaultValue
     * @Param: [str, defaultValue]
     * @return: String str为null或者空字符串或者格式不对返回defaultValue
     */
    public static float parseFloat(String str, float defaultValue){
        float value = defaultValue;  //声明结果，把默认值赋给结果
        if (!isBlank(str)){   //判断是否为null
            try{
                value = Float.parseFloat(str);  //不为空则把值赋给value
            }catch (NumberFormatException e){
                value = defaultValue;  //格式不对把默认值赋给value
            }
        }
        return value;
    }

    /**
     * @Description: 转为double类型，如果为null或者空字符串或者格式不对则返回0
     * @Param: [str]
     * @return: String
     */
    public static double parseDouble(String str){
        return parseDouble(str,0);
    }

    /**
     * @Description: 转为double类型 ，如果str为null或者空字符串或者格式不对则返回defaultValue
     * @Param: [str, defaultValue] 
     * @return: String str为null或者空字符串或者格式不对返回defaultValue
     */
    public static double parseDouble(String str, double defaultValue){
        double value = defaultValue;  //声明结果，把默认值赋给结果
        if (!isBlank(str)){   //判断是否为null
            try{
                value = Double.parseDouble(str);  //不为空则把值赋给value
            }catch (NumberFormatException e){
                value = defaultValue;  //格式不对把默认值赋给value
            }
        }
        return value;
    }

    /**
     * 转为long型，如果str为null或者空字符串或者格式不对则返回0
     * @param str
     * @return
     */
    public static long parseLong(String str){
        return parseLong(str,0);
    }

    /**
     * 转为long型（提供默认数值），如果str为null或者空字符串或者格式不对则返回defaultValue
     * @param str
     * @param defaultValue
     * @return str为null或者空字符串或者格式不对返回defaultValue
     */
    public static long parseLong(String str, long defaultValue){
        long value = defaultValue;  //声明结果，把默认值赋给结果
        if (!isBlank(str)){   //判断是否为null
            try{
                value = Long.parseLong(str);  //不为空则把值赋给value
            }catch (NumberFormatException e){
                value = defaultValue;  //格式不对把默认值赋给value
            }
        }
        return value;
    }

    /**
     * 转为int型
     * @param str
     * @return 如果str为null或者空字符串或者格式不对则返回0
     */
    public static int parseInt(String str){
        return parseInt(str,0);
    }

    /**
     * 转为int型(提供默认值)
     * @param str
     * @param defaultValue
     * @return 如果str为null或者空字符串或者格式不对则返回defaultValue
     */
    public static int parseInt(String str, int defaultValue){
        int value = defaultValue;  //声明结果，把默认值赋给结果
        if (!isBlank(str)){   //判断是否为null
            try{
                value = Integer.parseInt(str);  //不为空则把值赋给value
            }catch (NumberFormatException e){
                value = defaultValue;  //格式不对把默认值赋给value
            }
        }
        return value;
    }

    /**
     * 转为boolean型，不是true的返回为false
     * @param str
     * @return
     */
    public static boolean parseBoolean(String str){
        return parseBoolean(str,false);
    }


    /**
     * 转为boolean型（提供默认值）
     * @param str
     * @param defaultValue
     * @return
     */
    public static boolean parseBoolean(String str, boolean defaultValue){
        boolean value = defaultValue;
        if (!isBlank(str)){  //为null则返回默认值
            value = Boolean.parseBoolean(str);  //底层会把字符串和true对比，所以不用判断是否为空字符串
        }
        return value;
    }
}
