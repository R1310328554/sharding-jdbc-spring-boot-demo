package org.rockyang.shardingjdbc.common.utils;

import java.util.Random;

/**
 * 字符串工具
 * @author l.k
 */
public class StringUtil {

    /**
     * 生成随机字符串
     * @param length 字符串长度
     * @return 返回随机字符串
     */
    public static final String generateRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKMNLOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
