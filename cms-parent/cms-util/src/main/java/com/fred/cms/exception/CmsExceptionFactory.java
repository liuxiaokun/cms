/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 19, 2015 6:12:59 PM
 */
package com.fred.cms.exception;

import com.fred.cms.constant.ResponseCode;

public class CmsExceptionFactory {

    private CmsExceptionFactory() {
    }

    public static <T extends CmsException> T getException(final Class<T> exceptionClass, final ResponseCode code) {

        T t = null;
        try {
            t = exceptionClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        t.setCode(code);

        return t;
    }

}
