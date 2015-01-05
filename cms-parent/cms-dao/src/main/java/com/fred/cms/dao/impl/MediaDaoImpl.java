package com.fred.cms.dao.impl;

import com.fred.cms.dao.MediaDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.Media;

public class MediaDaoImpl extends BaseDaoImpl<Media> implements MediaDao {

    public MediaDaoImpl() {
        setClazz(Media.class);
    }
}
