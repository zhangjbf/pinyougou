package com.pinyougou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pinyougou.content.itf.ContentService;
import com.pinyougou.content.pojo.TbContent;
import com.pinyougou.content.vo.ContentVO;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.WebAppResult;
import com.pinyougou.service.UploadService;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/search")
    public PageResult<TbContent> search(@RequestBody ContentVO vo, Integer page, Integer rows) {
        vo.setPage(page);
        vo.setRows(rows);
        ServiceResult<PageResult<TbContent>> serviceResult = contentService.search(vo);
        if (!serviceResult.getSuccess()) {
            return new PageResult<>();
        }
        if (null == serviceResult.getResult()) {
            return new PageResult<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/add")
    public WebAppResult add(@RequestBody ContentVO vo) {
        if (null == vo) {
            return WebAppResult.build(false, "请求参数错误");
        }
        ServiceResult<Boolean> serviceResult = contentService.add(vo);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "保存错误");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/delete")
    public WebAppResult delete(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return WebAppResult.build(false, "请求参数错误");
        }
        String[] idArray = ids.split(",");
        if (null == idArray || idArray.length == 0) {
            return WebAppResult.build(false, "请求参数错误");
        }
        List<Integer> listData = new ArrayList<>();
        for (String idStr : idArray) {
            listData.add(Integer.valueOf(idStr));
        }
        ServiceResult<Boolean> serviceResult = contentService.delete(listData);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "删除错误");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/update")
    public WebAppResult update(@RequestBody ContentVO vo) {
        if (null == vo) {
            return WebAppResult.build(false, "请求参数错误");
        }
        ServiceResult<Boolean> serviceResult = contentService.update(vo);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "修改错误");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/findOne")
    public TbContent findOne(Integer id) {
        if (null == id || id == 0) {
            return new TbContent();
        }
        ServiceResult<TbContent> serviceResult = contentService.findOne(id);
        if (!serviceResult.getSuccess()) {
            return new TbContent();
        }
        if (null == serviceResult.getResult()) {
            return new TbContent();
        }
        return serviceResult.getResult();
    }

}
