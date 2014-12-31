package com.fred.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fred.cms.dao.UserDao;
import com.fred.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
}
