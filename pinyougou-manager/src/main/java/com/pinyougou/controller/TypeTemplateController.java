package com.pinyougou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.itf.TypeTemplateService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.WebAppResult;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.vo.TypeTemplateVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/3
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Autowired
    private TypeTemplateService typeTemplateService;

    @RequestMapping("/search")
    public PageResult<TbTypeTemplate> search(@RequestBody TypeTemplateVO vo, Integer page, Integer rows) {
        if (null != vo) {
            vo.setPage(page);
            vo.setRows(rows);
        }
        ServiceResult<PageResult<TbTypeTemplate>> serviceResult = typeTemplateService.search(vo);
        if (!serviceResult.getSuccess()) {
            return new PageResult<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/add")
    public WebAppResult add(@RequestBody TypeTemplateVO vo) {
        if (null == vo) {
            return WebAppResult.build(false, "请求错误");
        }
        ServiceResult<Boolean> serviceResult = typeTemplateService.add(vo);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, "保存错误");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/delete")
    public WebAppResult delete(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return WebAppResult.build(false, "参数错误");
        }
        String[] idArray = ids.split(",");
        if (null == idArray || idArray.length == 0) {
            return WebAppResult.build(false, "参数错误");
        }
        List<Integer> listData = new ArrayList<>();
        for (String idStr : idArray) {
            listData.add(Integer.valueOf(idStr));
        }
        ServiceResult<Boolean> serviceResult = typeTemplateService.delete(listData);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(Integer id) {
        if (null == id || id == 0) {
            return new TbTypeTemplate();
        }
        ServiceResult<TbTypeTemplate> serviceResult = typeTemplateService.findOne(id);
        if (!serviceResult.getSuccess()) {
            return new TbTypeTemplate();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/update")
    public WebAppResult update(@RequestBody TypeTemplateVO vo) {
        if (null == vo) {
            return WebAppResult.build(false, "参数错误");
        }
        ServiceResult<Boolean> serviceResult = typeTemplateService.update(vo);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        return WebAppResult.ok();

    }
}
