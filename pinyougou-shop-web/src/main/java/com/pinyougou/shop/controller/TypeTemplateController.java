package com.pinyougou.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.itf.TypeTemplateService;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.vo.SpecVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/7
 */
@RestController
@RequestMapping("typeTemplate")
public class TypeTemplateController {

    @Autowired
    private TypeTemplateService typeTemplateService;

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

    @RequestMapping("/findBySpecList")
    public List<SpecVO> findSpecList(Integer id) {
        if (null == id || id == 0) {
            return new ArrayList<>();
        }
        ServiceResult<List<SpecVO>> serviceResult = typeTemplateService.findBySpecList(id);
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }

}
