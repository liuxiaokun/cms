/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 16, 2015 8:32:21 PM
 */
package com.fred.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fred.cms.dao.UserRoleDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.UserRole;

@Repository
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {

    public UserRoleDaoImpl() {
        setClazz(UserRole.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findByUserId(Integer userId) {

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT r.name FROM role r INNER JOIN user_role ur ");
        sql.append(" ON r.role_id = ur.role_id ");
        sql.append(" WHERE ur.user_id = :userId AND r.is_active = 1 ");

        Query query = getEM(true).createNativeQuery(sql.toString());
        query.setParameter("userId", userId);
        List<String> roles = query.getResultList();

        return roles;
    }

}
