/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:59:26 AM
 */
package com.fred.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fred.cms.dao.UserDao;
import com.fred.cms.service.UserService;
import com.fred.cms.service.base.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
}
