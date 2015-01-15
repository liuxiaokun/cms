/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:56:13 AM
 */
package com.fred.cms.dao;

import com.fred.cms.dao.base.BaseDao;
import com.fred.cms.model.User;

public interface UserDao extends BaseDao<User> {

    User getByEmail(String email);
}
