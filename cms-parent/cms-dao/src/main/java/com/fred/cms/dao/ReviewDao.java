/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:56:10 AM
 */
package com.fred.cms.dao;

import java.util.List;

import com.fred.cms.criteria.ReviewCriteria;
import com.fred.cms.dao.base.BaseDao;
import com.fred.cms.model.Review;

public interface ReviewDao extends BaseDao<Review> {

    List<Review> listByContentId(ReviewCriteria reviewCriteria);

    Integer countByContentId(Integer contentId);
}
