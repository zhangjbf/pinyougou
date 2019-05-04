package com.pinyougou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.itf.ItemCatService;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbItemCat;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Integer parentId) {
        if (null == parentId) {
            return new ArrayList<>();
        }
        ServiceResult<List<TbItemCat>> serviceResult = itemCatService.findByParentId(parentId);
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }
}
