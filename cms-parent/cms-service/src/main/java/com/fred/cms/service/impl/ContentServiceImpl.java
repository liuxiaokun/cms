/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:59:12 AM
 */
package com.fred.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fred.cms.criteria.ContentListCriteria;
import com.fred.cms.dao.ContentDao;
import com.fred.cms.model.Content;
import com.fred.cms.request.ContentListRequest;
import com.fred.cms.service.ContentService;
import com.fred.cms.service.base.BaseServiceImpl;
import com.fred.cms.vo.ContentListVO;
import com.fred.cms.vo.Pagination;

@Service
public class ContentServiceImpl extends BaseServiceImpl implements ContentService {

    @Resource
    private ContentDao contentDao;

    @Override
    public Pagination<ContentListVO> listAllContents(ContentListRequest contentListRequest) {

        ContentListCriteria contentListCriteria = generateCriteria(contentListRequest);
        List<Content> contents = contentDao.listAllContents(contentListCriteria);

        return new Pagination<ContentListVO>(formatContentsToVOs(contents),
                contentDao.countAllContents(contentListCriteria));
    }

    private List<ContentListVO> formatContentsToVOs(List<Content> contents) {
        List<ContentListVO> vos = new ArrayList<ContentListVO>();

        for (Content content : contents) {
            vos.add(formatContentToVO(content));
        }
        return vos;
    }

    private ContentListVO formatContentToVO(Content content) {
        ContentListVO vo = new ContentListVO();

        vo.setContentId(content.getContentId());
        vo.setTitle(content.getTitle());
        vo.setDescription(content.getDescription());
        vo.setSortOrder(content.getSortOrder());
        vo.setCreate(content.getCreated());

        return vo;
    }

    private ContentListCriteria generateCriteria(ContentListRequest contentListRequest) {
        ContentListCriteria contentListCriteria = new ContentListCriteria();

        Integer offset = contentListRequest.getOffset();
        Integer limit = contentListRequest.getLimit();
        contentListCriteria.setOffset(offset == null ? 0 : offset);
        contentListCriteria.setLimit(limit == null ? 0 : limit);
        contentListCriteria.setUserId(getUserId());

        return contentListCriteria;
    }
}
