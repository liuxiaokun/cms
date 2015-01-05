package com.fred.cms.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fred.cms.request.ReviewListRequest;
import com.fred.cms.service.ReviewService;
import com.fred.cms.util.ResponseUtil;
import com.fred.cms.vo.Pagination;
import com.fred.cms.vo.ReviewListVO;
import com.fred.cms.web.base.BaseController;

@Controller
public class ReviewController extends BaseController {

    @Resource
    private ReviewService reviewService;

    @RequestMapping(value = "content/review")
    public ResponseEntity<String> getContentReview(@Valid ReviewListRequest reviewListRequest,
            BindingResult bindingResult) throws JSONException {

        Pagination<ReviewListVO> vos = reviewService.listByContentId(reviewListRequest);
        return ResponseUtil.jsonSucceed(vos, HttpStatus.OK);
    }
}