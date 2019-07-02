package com.yumiaobaobao.app.common.utils.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author WH  随机数生成
 */
public class RandomNumberUtil {
    /**
     * 随机生成4位数 用于验证码
     * @return
     */
    public static String randomnumber() {
        int ran=(int)(Math.random()*900000)+100000;
        return String.valueOf(ran);
    }

    /**
     * 根据参数  生成参数位 数字+大小写字母 的随机码
     * @return
     */
    public static String randomnumberEnglish(int number) {
        String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars = new char[number];
        for (int i = 0; i < number; i++) {
            Random random = new Random();
            int index = random.nextInt(string.length());
            chars[i] = string.charAt(index);
        }

        String result = String.valueOf(chars);
        return result;
    }

    public static class UUIDUtils {

        public static String getUUID() {
            return UUID.randomUUID().toString().replace("-", "");
        }

        public static void main(String[] args) {
            System.out.println(getUUID());
        }
    }
}