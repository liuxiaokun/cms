/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:58:59 AM
 */
package com.fred.cms.service.base;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fred.cms.seurity.service.MyUserDetails;
import com.fred.cms.util.IpUtil;

public class BaseServiceImpl implements BaseService {

    @Resource
    protected HttpServletRequest request;

    protected int getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails user = (MyUserDetails) authentication.getPrincipal();

        return user.getUserId();
    }

    protected final long getIp() {
        String ip = IpUtil.getIpAddr(request);

        return IpUtil.ip2Long(ip);
    }
}
