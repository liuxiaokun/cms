/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 9:01:05 AM
 */
package com.fred.cms.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fred.cms.request.ContentListRequest;
import com.fred.cms.request.ContentRequest;
import com.fred.cms.service.ContentService;
import com.fred.cms.util.ResponseUtil;
import com.fred.cms.vo.ContentListVO;
import com.fred.cms.vo.Pagination;
import com.fred.cms.web.base.BaseController;

@Controller
public class ContentController extends BaseController {

    @Resource
    private ContentService contentService;

    @RequestMapping(value = "contents", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> listAllContent(@Valid ContentListRequest contentListRequest, BindingResult result) {

        if (result.hasErrors()) {
            ResponseUtil.jsonSucceed(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Pagination<ContentListVO> contents = contentService.listAllContents(contentListRequest);

        return ResponseUtil.jsonSucceed(contents, HttpStatus.OK);
    };

    @RequestMapping(value = "content/{contentId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getContentDetail(@PathVariable Integer contentId) {

        return ResponseUtil.jsonSucceed(contentService.getDetailById(contentId), HttpStatus.OK);
    }

    @RequestMapping(value = "content", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> publishContent(@Valid ContentRequest contentRequest, BindingResult result) {

        if (result.hasErrors()) {
            ResponseUtil.jsonSucceed(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        contentService.publishContent(contentRequest);
        return ResponseUtil.jsonSucceed(null, HttpStatus.OK);
    }
}
