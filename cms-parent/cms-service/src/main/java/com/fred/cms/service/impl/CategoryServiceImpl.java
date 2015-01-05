package com.fred.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fred.cms.dao.CategoryDao;
import com.fred.cms.service.CategoryService;
import com.fred.cms.service.base.BaseServiceImpl;

@Service
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

}
