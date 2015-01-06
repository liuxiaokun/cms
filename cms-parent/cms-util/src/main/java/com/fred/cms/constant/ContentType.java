/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:59:47 AM
 */
package com.fred.cms.constant;

public enum ContentType {

    APPLICATION_JSON("application/json;charset=UTF-8"),
    APPLICATION_XML("application/xml;charset=UTF-8");

    private String value;

    ContentType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
