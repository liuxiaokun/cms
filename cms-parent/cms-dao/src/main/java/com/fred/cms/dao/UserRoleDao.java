/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 16, 2015 8:30:41 PM
 */
package com.fred.cms.dao;

import java.util.List;

import com.fred.cms.dao.base.BaseDao;
import com.fred.cms.model.UserRole;

public interface UserRoleDao extends BaseDao<UserRole> {

    String NAME = "name";

    List<String> findByUserId(Integer userId);
}
