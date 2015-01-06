/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:55:59 AM
 */
package com.fred.cms.dao;

import java.util.List;

import com.fred.cms.criteria.ContentListCriteria;
import com.fred.cms.dao.base.BaseDao;
import com.fred.cms.model.Content;

public interface ContentDao extends BaseDao<Content> {

    List<Content> listAllContents(ContentListCriteria contentListCriteria);

    Integer countAllContents(ContentListCriteria contentListCriteria);
}
