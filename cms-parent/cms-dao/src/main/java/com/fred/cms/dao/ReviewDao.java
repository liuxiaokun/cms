package com.fred.cms.dao;

import java.util.List;

import com.fred.cms.criteria.ReviewCriteria;
import com.fred.cms.dao.base.BaseDao;
import com.fred.cms.model.Review;

public interface ReviewDao extends BaseDao<Review> {

    List<Review> listByContentId(ReviewCriteria reviewCriteria);

    Integer countByContentId(Integer contentId);
}
