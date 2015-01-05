package com.fred.cms.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.fred.cms.criteria.ContentListCriteria;
import com.fred.cms.dao.ContentDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.Content;
import com.fred.cms.util.constant.QueryType;

@Repository
public class ContentDaoImpl extends BaseDaoImpl<Content> implements ContentDao {

    public ContentDaoImpl() {
        setClazz(Content.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Content> listAllContents(ContentListCriteria contentListCriteria) {

        String sql = genSQL(contentListCriteria, QueryType.ENTITY);
        Query query = getEM(true).createNativeQuery(sql, Content.class);
        query.setFirstResult(contentListCriteria.getOffset());
        query.setMaxResults(contentListCriteria.getLimit());

        return query.getResultList();
    }

    @Override
    public Integer countAllContents(ContentListCriteria contentListCriteria) {

        String sql = genSQL(contentListCriteria, QueryType.COUNT);
        Query query = getEM(true).createNativeQuery(sql);
        //if content_id is int , count is BigInteger, if content_id is bigint, count is Long.
        BigInteger count = (BigInteger) query.getSingleResult();

        return count.intValue();
    }

    private String genSQL(ContentListCriteria contentListCriteria, QueryType type) {

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

        sql.append(" FROM content c ");
        sql.append(" ORDER BY c.created DESC ");

        return sql.toString();
    }

}
