/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:59:12 AM
 */
package com.fred.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fred.cms.criteria.ContentListCriteria;
import com.fred.cms.dao.ContentDao;
import com.fred.cms.dao.UserDao;
import com.fred.cms.dto.ContentDTO;
import com.fred.cms.model.Content;
import com.fred.cms.model.User;
import com.fred.cms.request.ContentListRequest;
import com.fred.cms.request.ContentRequest;
import com.fred.cms.service.ContentService;
import com.fred.cms.service.base.BaseServiceImpl;
import com.fred.cms.vo.ContentListVO;
import com.fred.cms.vo.ContentVO;
import com.fred.cms.vo.Pagination;
import com.google.common.collect.Lists;

@Service
public class ContentServiceImpl extends BaseServiceImpl implements ContentService {

    @Resource
    private ContentDao contentDao;

    @Resource
    private UserDao userDao;

    @Override
    public Pagination<ContentListVO> listAllContents(ContentListRequest contentListRequest) {

        ContentListCriteria contentListCriteria = generateCriteria(contentListRequest);
        List<Content> contents = contentDao.listAllContents(contentListCriteria);
        int userId = getUserId();
        return new Pagination<ContentListVO>(formatContentsToVOs(contents),
                contentDao.countAllContents(contentListCriteria));
    }

    @Override
    public ContentVO getDetailById(Integer contentId) {

        ContentDTO contentDTO = contentDao.getDetailById(contentId);

        ContentVO contentVO = new ContentVO();
        BeanUtils.copyProperties(contentDTO, contentVO);
        return contentVO;
    }

    @Override
    @Transactional
    public void publishContent(ContentRequest contentRequest) {

        Content content = new Content();
        content.setCategoryId(contentRequest.getCategoryId());
        content.setContent(contentRequest.getContent());
        content.setDescription(contentRequest.getDescription());
        content.setTitle(contentRequest.getTitle());
        content.setCreated(new Date());
        content.setUserId(getUserId());

        contentDao.save(content);
    }

    private List<ContentListVO> formatContentsToVOs(List<Content> contents) {
        List<ContentListVO> vos = Lists.newArrayList();

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

        User user = userDao.getById(content.getUserId());
        vo.setNickname(user.getNickname());
        vo.setAvatar(user.getAvatar());

        return vo;
    }

    private ContentListCriteria generateCriteria(ContentListRequest contentListRequest) {
        ContentListCriteria contentListCriteria = new ContentListCriteria();

        Integer offset = contentListRequest.getOffset();
        Integer limit = contentListRequest.getLimit();
        contentListCriteria.setOffset(offset == null ? 0 : offset);
        contentListCriteria.setLimit(limit == null ? 0 : limit);
        contentListCriteria.setUserId(getUserId());
        contentListCriteria.setCategoryId(contentListRequest.getCategoryId());

        return contentListCriteria;
    }
}
