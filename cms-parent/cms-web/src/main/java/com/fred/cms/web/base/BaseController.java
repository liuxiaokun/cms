package com.fred.cms.web.base;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fred.cms.constant.ResponseCode;
import com.fred.cms.util.ResponseUtil;

public abstract class BaseController {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public final ResponseEntity<String> handleException(final Throwable ex) throws JSONException {

        Object errorMessage = "server error";

        return ResponseUtil.jsonFailed(errorMessage, ResponseCode.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
