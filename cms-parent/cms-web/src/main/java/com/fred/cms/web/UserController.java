/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 9:01:12 AM
 */
package com.fred.cms.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fred.cms.constant.ResponseCode;
import com.fred.cms.exception.CmsExceptionFactory;
import com.fred.cms.exception.DataValidationException;
import com.fred.cms.request.UserAddRequest;
import com.fred.cms.service.UserService;
import com.fred.cms.util.MailUtil;
import com.fred.cms.util.ResponseUtil;
import com.fred.cms.web.base.BaseController;
import com.google.common.collect.Maps;

@Controller
@RequestMapping("user")
// http://localhost:8080/cms/user/test?password=123&code=456
public class UserController extends BaseController {

    @Resource
    private MailUtil mailUtil;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public String testFrameWork(@Valid UserAddRequest userRequest, BindingResult result, @PathVariable String username,
            @RequestParam String password, HttpServletRequest request, HttpServletResponse response)
            throws DataValidationException {

        if (result.hasErrors()) {
            throw CmsExceptionFactory.getException(DataValidationException.class, ResponseCode.PARAMETER_ERROR);
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("username", "Fred");
        mailUtil.sendTemplatedHtmlEmail("406394685@qq.com", "subject", "/imgs/qqmusic.jpg", "emailTemplate/html.vm",
                params);
        // mailUtil.sendAttachemetnEmail("406394685@qq.com", "wo shi neirong",
        // "wo shi zhuti ", "qqmusic.jpg");
        return username + ":" + password + ":";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> userSignup(@Valid UserAddRequest userRequest, BindingResult result)
            throws DataValidationException {

        if (result.hasErrors()) {
            throw CmsExceptionFactory.getException(DataValidationException.class, ResponseCode.PARAMETER_ERROR);
        }
        int userId = userService.registUser(userRequest);

        return ResponseUtil.jsonSucceed(userId, HttpStatus.OK);
    }
}
