/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:56:49 AM
 */
package com.fred.cms.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fred.cms.dao.UserDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        setClazz(User.class);
    }

    @Override
    public User getByEmail(String email) {

        TypedQuery<User> query = getEM(true).createNamedQuery("User.getByEmail", User.class);
        query.setParameter("email", email);
        List<User> resultList = query.getResultList();

        return resultList.size() > 0 ? resultList.get(0) : null;
    }
}
