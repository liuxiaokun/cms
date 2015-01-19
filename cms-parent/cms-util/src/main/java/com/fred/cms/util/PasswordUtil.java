/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 19, 2015 7:18:48 PM
 */
package com.fred.cms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.security.crypto.keygen.KeyGenerators;

public final class PasswordUtil {

    private static int SALT_LENGTH = 6;

    public static String encodePassword(String password, String salt) {

        StringBuffer text = new StringBuffer(password);

        if (salt != null && salt.length() > 0) {
            text.append("{").append(salt).append("}");
        }
        StringBuffer buf = new StringBuffer("");

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.toString().getBytes());
            byte[] b = md.digest();

            for (int offset = 0, i; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return buf.toString();
    }

    public static String genSalt() {
        String key = KeyGenerators.string().generateKey();

        return key.substring(0, SALT_LENGTH);
    }

    public static String genPassword(int length) {

        String chars = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int charsLen = chars.length();
        sb.append(chars.charAt(random.nextInt(charsLen)));
        chars = chars.concat("0");
        length -= 1;
        charsLen += 1;
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(charsLen)));
        }
        return sb.toString();
    }
}