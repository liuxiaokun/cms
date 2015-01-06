/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:59:58 AM
 */
package com.fred.cms.constant;

public enum ResponseCode {

    UNAUTHORIZED(401),

    FORBIDDEN(403),

    SERVER_ERROR(500),

    INVALID_PARAMETER(10000);

    private int value;

    private ResponseCode(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
