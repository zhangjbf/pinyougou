package com.pinyougou.page.impl;

import com.pinyougou.page.model.ItemPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.model.ServiceResult;
import com.pinyougou.page.itf.ItemPageService;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/28
 */
@Service("itemPageService")
public class ItemPageServiceImpl implements ItemPageService {

    @Autowired
    private ItemPageModel itemPageModel;

    @Override
    public ServiceResult<Boolean> genItemHtml(Integer goodsId) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(itemPageModel.genItemHtml(goodsId));
        return serviceResult;
    }
}
