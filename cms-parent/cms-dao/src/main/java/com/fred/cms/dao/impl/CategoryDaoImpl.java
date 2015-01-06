/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:56:28 AM
 */
package com.fred.cms.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fred.cms.dao.CategoryDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.Category;

@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

    public CategoryDaoImpl() {
        setClazz(Category.class);
    }

    @Override
    public List<Category> listByParentId(Integer parentId) {

        TypedQuery<Category> query = getEM(true).createNamedQuery("Category.findByParentId", Category.class);
        query.setParameter("parentId", parentId);

        return query.getResultList();
    }

}
