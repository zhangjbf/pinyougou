package com.pinyougou.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.itf.ItemCatService;
import com.pinyougou.model.ItemCatModel;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbItemCat;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatModel itemCatModel;

    @Override
    public ServiceResult<List<TbItemCat>> findByParentId(Integer parentId) {
        ServiceResult<List<TbItemCat>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(itemCatModel.findByParentId(parentId));
        return serviceResult;

    }
}
