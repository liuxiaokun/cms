/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:56:45 AM
 */
package com.fred.cms.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fred.cms.criteria.ReviewCriteria;
import com.fred.cms.dao.ReviewDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.Review;

@Repository
public class ReviewDaoImpl extends BaseDaoImpl<Review> implements ReviewDao {

    public ReviewDaoImpl() {
        setClazz(Review.class);
    }

    @Override
    public List<Review> listByContentId(ReviewCriteria reviewCriteria) {

        TypedQuery<Review> query = getEM(true).createNamedQuery("Review.listByContentId", Review.class);
        query.setParameter("contentId", reviewCriteria.getContentId());
        query.setFirstResult(reviewCriteria.getOffset());
        query.setMaxResults(reviewCriteria.getLimit());

        return query.getResultList();
    }

    @Override
    public Integer countByContentId(Integer contentId) {

        Query query = getEM(true).createNamedQuery("Review.countByContentId");
        query.setParameter("contentId", contentId);
        Long count = (Long) query.getSingleResult();

        return count.intValue();
    }

}
