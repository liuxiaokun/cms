/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:56:34 AM
 */
package com.fred.cms.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.fred.cms.constant.QueryType;
import com.fred.cms.criteria.ContentListCriteria;
import com.fred.cms.dao.ContentDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.dto.ContentDTO;
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

    @Override
    @SuppressWarnings("unchecked")
    public ContentDTO getDetailById(Integer contentId) {

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT u.nickname AS nickname, c.title AS title, c.created AS created, c.content AS content ");
        sql.append(" , ca.name AS categoryName, ca.icon AS categoryIcon ");
        sql.append(" FROM content c ");
        sql.append(" LEFT JOIN user u ON c.user_id = u.user_id ");
        sql.append(" LEFT JOIN category ca ON ca.category_id = c.category_id ");
        sql.append(" WHERE c.content_id = :contentId");

        Query query = getEM(true).createNativeQuery(sql.toString());
        query.setParameter("contentId", contentId);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(ContentDTO.class));
        List<ContentDTO> resultList = query.getResultList();

        return resultList.size() > 0 ? resultList.get(0) : null;
    }

}
