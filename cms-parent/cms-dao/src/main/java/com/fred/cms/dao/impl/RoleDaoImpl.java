/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 16, 2015 8:28:04 PM
 */
package com.fred.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.fred.cms.dao.RoleDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.Role;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

    public RoleDaoImpl() {
        setClazz(Role.class);
    }
}
