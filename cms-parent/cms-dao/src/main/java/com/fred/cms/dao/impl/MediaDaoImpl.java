/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:56:41 AM
 */
package com.fred.cms.dao.impl;

import com.fred.cms.dao.MediaDao;
import com.fred.cms.dao.base.BaseDaoImpl;
import com.fred.cms.model.Media;

public class MediaDaoImpl extends BaseDaoImpl<Media> implements MediaDao {

    public MediaDaoImpl() {
        setClazz(Media.class);
    }
}
