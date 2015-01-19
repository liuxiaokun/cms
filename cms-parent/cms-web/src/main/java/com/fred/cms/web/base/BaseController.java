/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 9:01:25 AM
 */
package com.fred.cms.web.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fred.cms.constant.ResponseCode;
import com.fred.cms.exception.CmsException;
import com.fred.cms.exception.DataValidationException;
import com.fred.cms.util.ExceptionMessageUtil;
import com.fred.cms.util.ResponseUtil;

public abstract class BaseController {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public final ResponseEntity<String> handleException(final Throwable ex) {

        Object errorMessage = "Server error.";
        ResponseCode code = ResponseCode.SERVER_ERROR;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof CmsException) {
            CmsException cmsException = (CmsException) ex;
            ResponseCode responseCode = cmsException.getCode();
            code = (null != responseCode) ? responseCode : code;
            errorMessage = ExceptionMessageUtil.getExceptionMessage(code.getValue());

            if (code.getValue() != ResponseCode.SERVER_ERROR.getValue()) {
                if (ex instanceof DataValidationException) {
                    httpStatus = HttpStatus.BAD_REQUEST;
                } else {
                    httpStatus = HttpStatus.OK;
                }
            }
        }

        return ResponseUtil.jsonFailed(errorMessage, code, httpStatus);
    }

}
