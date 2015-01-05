package com.fred.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.fred.cms.dao.ContentDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.Content;

@Repository
public class ContentDaoImpl extends BaseDaoImpl<Content> implements ContentDao {

    public ContentDaoImpl() {
        setClazz(Content.class);
    }

}
