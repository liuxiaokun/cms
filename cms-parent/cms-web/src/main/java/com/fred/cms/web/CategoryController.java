package com.fred.cms.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.fred.cms.service.CategoryService;
import com.fred.cms.web.base.BaseController;

@Controller
public class CategoryController extends BaseController {

    @Resource
    private CategoryService categoryService;
}
