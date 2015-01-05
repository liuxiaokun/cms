package com.fred.cms.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.fred.cms.service.ContentService;
import com.fred.cms.web.base.BaseController;

@Controller
public class ContentController extends BaseController {

    @Resource
    private ContentService ContetnService;
}
