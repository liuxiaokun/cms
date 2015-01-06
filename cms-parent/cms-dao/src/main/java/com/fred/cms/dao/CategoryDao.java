/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:55:56 AM
 */
package com.fred.cms.dao;

import java.util.List;

import com.fred.cms.dao.base.BaseDao;
import com.fred.cms.model.Category;

public interface CategoryDao extends BaseDao<Category> {

    public List<Category> listByParentId(Integer parentId);
}
