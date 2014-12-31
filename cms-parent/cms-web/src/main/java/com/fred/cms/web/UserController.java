package com.fred.cms.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.fred.cms.service.UserService;

@Controller
public class UserController {

    @Resource
    private UserService userService;
}
