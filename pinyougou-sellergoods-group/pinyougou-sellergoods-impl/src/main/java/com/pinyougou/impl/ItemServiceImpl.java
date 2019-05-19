package com.pinyougou.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.itf.ItemService;
import com.pinyougou.model.ItemModel;
import com.pinyougou.model.ServiceResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/19
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemModel itemModel;

    @Override
    public ServiceResult<Boolean> importItem2Solr() {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(itemModel.importItem2Solr());
        return serviceResult;
    }
}
