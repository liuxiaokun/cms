/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:59:26 AM
 */
package com.fred.cms.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fred.cms.constant.CommonConstant;
import com.fred.cms.dao.UserDao;
import com.fred.cms.dao.UserRoleDao;
import com.fred.cms.model.User;
import com.fred.cms.model.UserRole;
import com.fred.cms.model.UserRoleId;
import com.fred.cms.request.UserAddRequest;
import com.fred.cms.service.UserService;
import com.fred.cms.service.base.BaseServiceImpl;
import com.fred.cms.util.PasswordUtil;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    @Transactional
    public int registUser(UserAddRequest userRequest) {

        String account = userRequest.getAccount();
        String password = userRequest.getPassword();

        User user = new User();
        user.setEmail(account);
        user.setNickname(account);
        user.setIsEmailVerified(false);
        long ip = getIp();
        user.setClientIp(ip);
        user.setLastIp(ip);
        Date now = new Date();
        user.setCreated(now);
        user.setLastLogin(now);
        user.setIsActive(Boolean.TRUE);
        String salt = PasswordUtil.genSalt();
        user.setSalt(salt);
        user.setPassword(PasswordUtil.encodePassword(password, salt));

        userDao.save(user);

        int userId = user.getUserId();

        // save user role
        UserRole userRole = new UserRole();
        UserRoleId userRoleId = new UserRoleId();
        userRoleId.setRoleId(CommonConstant.DEFAULT_USER_ROLE_ID);
        userRoleId.setUserId(userId);
        userRole.setUserRoleId(userRoleId);
        userRoleDao.save(userRole);

        return userId;
    }
}
