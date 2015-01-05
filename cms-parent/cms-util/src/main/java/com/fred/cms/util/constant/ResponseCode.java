package com.fred.cms.util.constant;

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
