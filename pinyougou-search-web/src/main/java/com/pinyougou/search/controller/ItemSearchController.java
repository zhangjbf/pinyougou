package com.pinyougou.search.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.model.ServiceResult;
import com.pinyougou.search.itf.ItemSearchService;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/19
 */
@RestController
@RequestMapping("/itemsearch")
public class ItemSearchController {

    @Autowired
    private ItemSearchService itemSearchService;

    @RequestMapping("/search")
    public Map<String, Object> search(@RequestBody Map searchMap) {
        if (null == searchMap) {
            return new HashMap<>();
        }
        ServiceResult<Map<String, Object>> serviceResult = itemSearchService.search(searchMap);
        if (!serviceResult.getSuccess()) {
            return new HashMap<>();
        }
        if (null == serviceResult.getResult() || serviceResult.getResult().size() == 0) {
            return new HashMap<>();
        }
        return serviceResult.getResult();
    }
}
