/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:58:40 AM
 */
package com.fred.cms.service;

import com.fred.cms.request.ReviewListRequest;
import com.fred.cms.service.base.BaseService;
import com.fred.cms.vo.Pagination;
import com.fred.cms.vo.ReviewListVO;

public interface ReviewService extends BaseService {

    Pagination<ReviewListVO> listByContentId(ReviewListRequest reviewListRequest);
}
