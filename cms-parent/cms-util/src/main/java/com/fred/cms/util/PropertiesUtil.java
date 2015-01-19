/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 19, 2015 6:37:29 PM
 */
package com.fred.cms.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {

    private PropertiesUtil() {
    }

    public static String get(final Properties properties, final String key) {
        String value = null;

        if (null != properties) {
            String str = properties.getProperty(key);
            if (null != str) {
                try {
                    value = new String(str.getBytes("ISO8859-1"), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    public static Properties getProperties(String path) {

        InputStream in = PropertiesUtil.class.getResourceAsStream(path);
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("properties can not be loaded successfully!");
        }
        return properties;
    }

    public static Map<String, String> getAll(String path) {

        Map<String, String> parameters = new HashMap<String, String>();
        Properties pro = PropertiesUtil.getProperties(path);
        Enumeration<Object> keys = pro.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            parameters.put(key, pro.getProperty(key));
        }
        return parameters;
    }
}
