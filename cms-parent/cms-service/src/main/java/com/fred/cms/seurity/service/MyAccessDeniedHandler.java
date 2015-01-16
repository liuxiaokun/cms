/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 16, 2015 6:39:40 PM
 */
package com.fred.cms.seurity.service;

import static com.fred.cms.constant.ContentType.APPLICATION_JSON;
import static com.fred.cms.constant.ResponseCode.FORBIDDEN;
import static com.fred.cms.constant.ResponseStatus.FAILED;
import static com.fred.cms.util.ResponseUtil.RESPONSE_BODY;
import static com.fred.cms.util.ResponseUtil.RESPONSE_ERROR;
import static com.fred.cms.util.ResponseUtil.RESPONSE_ERROR_CODE;
import static com.fred.cms.util.ResponseUtil.RESPONSE_ERROR_MSG;
import static com.fred.cms.util.ResponseUtil.RESPONSE_STATUS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex)
            throws IOException, ServletException {

        response.setContentType(APPLICATION_JSON.getValue());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        PrintWriter out = null;

        try {
            out = response.getWriter();

            Map<String, Object> result = new HashMap<String, Object>();
            Map<String, Object> body = new HashMap<String, Object>();
            Map<String, Object> error = new HashMap<String, Object>();

            error.put(RESPONSE_ERROR_CODE, FORBIDDEN.getValue());
            error.put(RESPONSE_ERROR_MSG, "FORBIDDEN");
            body.put(RESPONSE_ERROR, error);
            result.put(RESPONSE_BODY, body);
            result.put(RESPONSE_STATUS, FAILED.name());

            JSONObject json = JSONObject.fromObject(result);
            out.append(json.toString());
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}