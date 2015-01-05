package com.fred.cms.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fred.cms.util.constant.ContentType;
import com.fred.cms.util.constant.ResponseCode;
import com.fred.cms.util.constant.ResponseStatus;

public final class ResponseUtil {

    public static final String RESPONSE_BODY = "body";

    public static final String RESPONSE_STATUS = "status";

    public static final String RESPONSE_ERROR = "error";

    public static final String RESPONSE_ERROR_CODE = "code";

    public static final String RESPONSE_ERROR_MSG = "msg";

    private ResponseUtil() {
        // empty
    }

    public static ResponseEntity<String> jsonSucceed(final Object object,
            final HttpStatus statusCode) throws JSONException {
        
        JSONObject jo = new JSONObject();
//        Object responseBody = DataUtil.formatApiResponse(object);
//        jo.accumulate(RESPONSE_BODY, responseBody);
        return wrapResponse(ResponseStatus.SUCCEED, jo, statusCode);
    }

    public static ResponseEntity<String> jsonFailed(final String errorMessage,
            final HttpStatus statusCode) throws JSONException {
        return jsonFailed(errorMessage, ResponseCode.SERVER_ERROR, statusCode);
    }

    public static ResponseEntity<String> jsonFailed(final Object errorMessage,
            final ResponseCode code, final HttpStatus statusCode) throws JSONException {

        JSONObject errorObj = new JSONObject();
        errorObj.accumulate(RESPONSE_ERROR_CODE, code.getValue());
        errorObj.accumulate(RESPONSE_ERROR_MSG, errorMessage);

        JSONObject error = new JSONObject();
        error.accumulate(RESPONSE_ERROR, errorObj);

        JSONObject jo = new JSONObject();
        jo.accumulate(RESPONSE_BODY, error);
        return wrapResponse(ResponseStatus.FAILED, jo, statusCode);
    }

    private static ResponseEntity<String> wrapResponse(final ResponseStatus status,
            final JSONObject body, final HttpStatus statusCode) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", ContentType.APPLICATION_JSON.getValue());

        if (ResponseStatus.SUCCEED.equals(status)) {
            body.accumulate(RESPONSE_STATUS, ResponseStatus.SUCCEED.toString());
        } else if (ResponseStatus.FAILED.equals(status)) {
            body.accumulate(RESPONSE_STATUS, ResponseStatus.FAILED.toString());
        }

        return new ResponseEntity<String>(body.toString(), headers, statusCode);
    }
}
