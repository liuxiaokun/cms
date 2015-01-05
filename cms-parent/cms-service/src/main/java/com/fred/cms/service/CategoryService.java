package com.fred.cms.service;

import java.util.List;

import com.fred.cms.service.base.BaseService;
import com.fred.cms.vo.CategoryListVO;

public interface CategoryService extends BaseService {

    List<CategoryListVO> listByParentId(Integer parentId);

}
