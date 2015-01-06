/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:58:32 AM
 */
package com.fred.cms.service;

import com.fred.cms.request.ContentListRequest;
import com.fred.cms.service.base.BaseService;
import com.fred.cms.vo.ContentListVO;
import com.fred.cms.vo.Pagination;

public interface ContentService extends BaseService {

    Pagination<ContentListVO> listAllContents(ContentListRequest contentListRequest);
}
