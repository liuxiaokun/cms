package com.fred.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fred.cms.dao.ContentDao;
import com.fred.cms.service.ContentService;
import com.fred.cms.service.base.BaseServiceImpl;

@Service
public class ContentServiceImpl extends BaseServiceImpl implements ContentService {

    @Resource
    private ContentDao contentDao;
}
