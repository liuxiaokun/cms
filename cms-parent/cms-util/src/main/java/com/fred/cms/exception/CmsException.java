/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 19, 2015 6:14:49 PM
 */
package com.fred.cms.exception;

import com.fred.cms.constant.ResponseCode;

public class CmsException extends Exception {

    private static final long serialVersionUID = -3457286945694889191L;

    private ResponseCode code;

    private String errorMessage;

    public ResponseCode getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
