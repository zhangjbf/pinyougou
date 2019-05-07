package com.pinyougou.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.itf.ItemCatService;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbItemCat;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/7
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/findAll")
    public List<TbItemCat> findAll() {
        ServiceResult<List<TbItemCat>> serviceResult = itemCatService.findAll();
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        if (null == serviceResult.getResult()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Integer parentId) {
        ServiceResult<List<TbItemCat>> serviceResult = itemCatService.findByParentId(parentId);
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        if (null == serviceResult.getResult()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/findOne")
    public TbItemCat findOne(Integer id) {
        if (null == id || 0 == id) {
            return new TbItemCat();
        }
        ServiceResult<TbItemCat> serviceResult = itemCatService.findOne(id);
        if (!serviceResult.getSuccess()) {
            return new TbItemCat();
        }
        return serviceResult.getResult();
    }

}
