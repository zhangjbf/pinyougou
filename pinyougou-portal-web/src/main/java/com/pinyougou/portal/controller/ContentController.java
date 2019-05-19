package com.pinyougou.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.content.itf.ContentService;
import com.pinyougou.content.pojo.TbContent;
import com.pinyougou.model.ServiceResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/13
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/findByCategoryId")
    public List<TbContent> findByCategoryId(Integer categoryId) {
        if (null == categoryId || categoryId == 0) {
            return new ArrayList<>();
        }
        ServiceResult<List<TbContent>> serviceResult = contentService.findByCategoryId(categoryId);
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        if (null == serviceResult.getResult()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }

}
