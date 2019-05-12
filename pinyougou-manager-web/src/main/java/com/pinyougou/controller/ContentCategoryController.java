package com.pinyougou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.content.itf.ContentCategoryService;
import com.pinyougou.content.pojo.TbContentCategory;
import com.pinyougou.content.vo.ContentCategoryVO;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.WebAppResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
@RestController
@RequestMapping("/contentCategory")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/search")
    public PageResult<TbContentCategory> search(@RequestBody ContentCategoryVO vo, Integer page, Integer rows) {
        vo.setPage(page);
        vo.setRows(rows);
        ServiceResult<PageResult<TbContentCategory>> serviceResult = contentCategoryService.search(vo);
        if (!serviceResult.getSuccess()) {
            return new PageResult<>();
        }
        if (null == serviceResult.getResult()) {
            return new PageResult<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/add")
    public WebAppResult add(@RequestBody ContentCategoryVO vo) {
        if (null == vo) {
            return WebAppResult.build(false, "请求参数错误");
        }
        ServiceResult<Boolean> serviceResult = contentCategoryService.add(vo);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "保存失败");
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
        ServiceResult<Boolean> serviceResult = contentCategoryService.delete(listData);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "删除失败");
        }
        return WebAppResult.ok();

    }

    @RequestMapping("/findOne")
    public TbContentCategory findOne(Integer id) {
        if (null == id || id == 0) {
            return new TbContentCategory();
        }
        ServiceResult<TbContentCategory> serviceResult = contentCategoryService.findOne(id);
        if (!serviceResult.getSuccess()) {
            return new TbContentCategory();
        }
        if (null == serviceResult.getResult()) {
            return new TbContentCategory();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/update")
    public WebAppResult update(@RequestBody ContentCategoryVO vo) {
        if (null == vo) {
            return WebAppResult.build(false, "请求参数错误");
        }
        ServiceResult<Boolean> serviceResult = contentCategoryService.update(vo);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "修改错误");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/findAll")
    public List<TbContentCategory> findAll() {
        ServiceResult<List<TbContentCategory>> serviceResult = contentCategoryService.findAll();
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        if (null == serviceResult.getResult()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }

}
