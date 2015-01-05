package com.fred.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.fred.cms.dao.CategoryDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.Category;

@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

    public CategoryDaoImpl() {
        setClazz(Category.class);
    }

}
