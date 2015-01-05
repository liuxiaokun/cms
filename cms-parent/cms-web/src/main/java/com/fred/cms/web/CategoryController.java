package com.fred.cms.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fred.cms.service.CategoryService;
import com.fred.cms.vo.CategoryListVO;
import com.fred.cms.web.base.BaseController;

@Controller
public class CategoryController extends BaseController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "category/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> listByParentId(@PathVariable Integer parentId) {

        List<CategoryListVO> vos = categoryService.listByParentId(parentId);
        System.out.println(vos);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
