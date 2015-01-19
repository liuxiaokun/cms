/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 19, 2015 6:37:36 PM
 */
package com.fred.cms.util;

import java.util.Properties;

public final class ExceptionMessageUtil {

    private static Properties properties;

    static {
        properties = PropertiesUtil.getProperties("/error_message.properties");
    }

    private ExceptionMessageUtil() {
    }

    public static String getExceptionMessage(final int code) {
        return PropertiesUtil.get(properties, code + "");
    }
}