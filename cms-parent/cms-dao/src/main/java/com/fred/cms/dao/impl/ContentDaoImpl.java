/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:56:34 AM
 */
package com.fred.cms.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fred.cms.constant.QueryType;
import com.fred.cms.criteria.ContentListCriteria;
import com.fred.cms.dao.ContentDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.Content;

@Repository
public class ContentDaoImpl extends BaseDaoImpl<Content> implements ContentDao {

    public ContentDaoImpl() {
        setClazz(Content.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Content> listAllContents(ContentListCriteria contentListCriteria) {

        Integer categoryId = contentListCriteria.getCategoryId();
        String sql = genSQL(categoryId, QueryType.ENTITY);
        Query query = getEM(true).createNativeQuery(sql, Content.class);

        if (null != categoryId) {
            query.setParameter("categoryId", categoryId);
        }
        query.setParameter("userId", contentListCriteria.getUserId());
        query.setFirstResult(contentListCriteria.getOffset());
        query.setMaxResults(contentListCriteria.getLimit());

        return query.getResultList();
    }

    @Override
    public Integer countAllContents(ContentListCriteria contentListCriteria) {

        Integer categoryId = contentListCriteria.getCategoryId();
        String sql = genSQL(categoryId, QueryType.COUNT);
        Query query = getEM(true).createNativeQuery(sql);

        if (null != categoryId) {
            query.setParameter("categoryId", categoryId);
        }
        query.setParameter("userId", contentListCriteria.getUserId());
        BigInteger count = (BigInteger) query.getSingleResult();

        return count.intValue();
    }

    private String genSQL(Integer categoryId, QueryType type) {

        StringBuilder sql = new StringBuilder();

        switch (type) {
        case ENTITY:
            sql.append(" SELECT c.* ");
            break;
        case COUNT:
            sql.append(" SELECT COUNT(*) ");
            break;
        default:
            break;
        }

        sql.append(" FROM content c WHERE c.is_deleted = false AND c.user_id = :userId");

        if (null != categoryId) {
            sql.append(" AND c.category_id = :categoryId ");
        }
        sql.append(" ORDER BY c.created DESC ");

        return sql.toString();
    }

}
