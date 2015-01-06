/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:58:29 AM
 */
package com.fred.cms.service;

import java.util.List;

import com.fred.cms.service.base.BaseService;
import com.fred.cms.vo.CategoryListVO;

public interface CategoryService extends BaseService {

    List<CategoryListVO> listByParentId(Integer parentId);

}
