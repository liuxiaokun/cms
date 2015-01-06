/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 9:01:12 AM
 */
package com.fred.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fred.cms.request.UserRequest;
import com.fred.cms.web.base.BaseController;

@Controller
@RequestMapping("user")
// http://localhost:8080/cms/user/test?password=123&code=456
public class UserController extends BaseController {

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public String testFrameWork(@Valid UserRequest userRequest, BindingResult validResult,
            @PathVariable String username, @RequestParam String password,
            HttpServletRequest request, HttpServletResponse response) {

        if (validResult.hasErrors()) {
            System.out.println("code error!");
        }

        return username + ":" + password + ":" + userRequest.getCode();
    }
}
