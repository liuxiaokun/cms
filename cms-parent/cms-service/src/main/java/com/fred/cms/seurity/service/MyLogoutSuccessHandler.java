/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 16, 2015 5:14:31 PM
 */
package com.fred.cms.seurity.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.fred.cms.constant.ContentType;
import com.fred.cms.constant.ResponseStatus;
import com.fred.cms.util.ResponseUtil;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setContentType(ContentType.APPLICATION_JSON.getValue());

        PrintWriter out = null;
        try {
            out = response.getWriter();

            Map<String, Object> result = new HashMap<String, Object>();
            result.put(ResponseUtil.RESPONSE_BODY, null);
            result.put(ResponseUtil.RESPONSE_STATUS, ResponseStatus.SUCCEED);

            JSONObject json = JSONObject.fromObject(result);
            out.append(json.toString());
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

}
