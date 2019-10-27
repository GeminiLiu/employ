package com.jagt.employ.common.tools;

import java.util.Base64;
import java.util.Random;
import java.util.UUID;

/**
 * 
 * 随机字符串工具类
 * 
 * @version  1.0
 * @author   gotanks
 * @since    2019-04-02
 * 
 */
public class UUID_ {
	/**
     * 带-的UUID
     *
     * @return 36位的字符串
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }
 
    /**
     * 去掉-的UUID
     *
     * @return 32位的字符串
     */
    public static String randomUUID32() {
        return randomUUID().replace("-", "");
    }
    
    /**
     * 生成base64的UUID
     * @return
     */
    public static String randomUUIDBase64() {
        UUID uuid = UUID.randomUUID();
        byte[] byUuid = new byte[16];
        long least = uuid.getLeastSignificantBits();
        long most = uuid.getMostSignificantBits();
        long2bytes(most, byUuid, 0);
        long2bytes(least, byUuid, 8);

        return Base64.getEncoder().encodeToString(byUuid);
    }
    
    private static void long2bytes(long value, byte[] bytes, int offset) {
        for (int i = 7; i > -1; i--) {
            bytes[offset++] = (byte) ((value >> 8 * i) & 0xFF);
        }
    }
    
    /**
     * 根据当前毫秒获取随机数字
     * 
     * @return
     */
    public static String genCurrentTimeId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
}
