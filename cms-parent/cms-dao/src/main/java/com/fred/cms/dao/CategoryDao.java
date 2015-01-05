package com.fred.cms.dao;

import java.util.List;

import com.fred.cms.dao.base.BaseDao;
import com.fred.cms.model.Category;

public interface CategoryDao extends BaseDao<Category> {

    public List<Category> listByParentId(Integer parentId);
}
