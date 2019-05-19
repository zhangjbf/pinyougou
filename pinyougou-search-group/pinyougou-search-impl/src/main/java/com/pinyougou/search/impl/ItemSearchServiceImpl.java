package com.pinyougou.search.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.model.ServiceResult;
import com.pinyougou.search.itf.ItemSearchService;
import com.pinyougou.search.model.ItemSearchModel;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/19
 */
@Service("itemSearchService")
public class ItemSearchServiceImpl implements ItemSearchService {

    @Autowired
    private ItemSearchModel itemSearchModel;

    @Override
    public ServiceResult<Map<String, Object>> search(Map searchMap) {
        ServiceResult<Map<String, Object>> result = new ServiceResult<>();
        result.setResult(itemSearchModel.search(searchMap));
        return result;
    }
}
