/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 15, 2015 7:45:23 PM
 */
package com.fred.cms.seurity.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fred.cms.dao.UserDao;
import com.fred.cms.dao.UserRoleDao;
import com.fred.cms.model.User;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.getByEmail(username);

        if (null == user) {
            throw new UsernameNotFoundException("NO SUCH USER!");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        List<String> roles = userRoleDao.findByUserId(user.getUserId());

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        MyUserDetails myUserDetail = new MyUserDetails(username, user.getPassword(), true, true, true, true,
                authorities);
        myUserDetail.setSalt(user.getSalt());
        myUserDetail.setUserId(user.getUserId());

        return myUserDetail;
    }

}
