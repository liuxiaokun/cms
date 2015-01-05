package com.fred.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fred.cms.criteria.ReviewCriteria;
import com.fred.cms.dao.ReviewDao;
import com.fred.cms.model.Review;
import com.fred.cms.request.ReviewListRequest;
import com.fred.cms.service.ReviewService;
import com.fred.cms.service.base.BaseServiceImpl;
import com.fred.cms.vo.Pagination;
import com.fred.cms.vo.ReviewListVO;

@Service
public class ReviewServiceImpl extends BaseServiceImpl implements ReviewService {

    @Resource
    private ReviewDao reviewDao;

    @Override
    public Pagination<ReviewListVO> listByContentId(ReviewListRequest reviewListRequest) {

        Integer contentId = reviewListRequest.getContentId();
        Integer offset = reviewListRequest.getOffset();
        Integer limit = reviewListRequest.getLimit();

        ReviewCriteria criteria = new ReviewCriteria();
        criteria.setContentId(contentId);
        criteria.setOffset(offset == null ? 0 : offset);
        criteria.setLimit(limit == null ? 20 : limit);
        List<Review> reviews = reviewDao.listByContentId(criteria);

        List<ReviewListVO> vos = new ArrayList<ReviewListVO>();

        for (Review review : reviews) {

            ReviewListVO vo = new ReviewListVO();
            vo.setCreated(review.getCreated());
            vo.setReviewContent(review.getReviewContent());
            vo.setUserId(review.getUserId());

            vos.add(vo);
        }

        return new Pagination<ReviewListVO>(vos, reviewDao.countByContentId(contentId));
    }

}
