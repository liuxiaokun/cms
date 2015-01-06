/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:59:05 AM
 */
package com.fred.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fred.cms.dao.CategoryDao;
import com.fred.cms.model.Category;
import com.fred.cms.service.CategoryService;
import com.fred.cms.service.base.BaseServiceImpl;
import com.fred.cms.vo.CategoryListVO;

@Service
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<CategoryListVO> listByParentId(Integer parentId) {

        List<Category> categories = categoryDao.listByParentId(parentId);

        List<CategoryListVO> vos = new ArrayList<CategoryListVO>();

        for (Category category : categories) {
            vos.add(formatToCategoryVO(category));
        }
        return vos;
    }

    private CategoryListVO formatToCategoryVO(Category category) {

        CategoryListVO vo = new CategoryListVO();
        vo.setCategoryId(category.getCategoryId());
        vo.setName(category.getName());
        vo.setDescription(category.getDescription());
        vo.setIcon(category.getIcon());

        return vo;
    }

}
