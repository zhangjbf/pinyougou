package com.pinyougou.search.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
        Map<String, Object> mapData = new HashMap<>();

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
        mapData.putAll(serviceResult.getResult());

        ServiceResult<Map<String, List<String>>> categoryServiceResult = itemSearchService.searchCategoryList(searchMap);
        if (!categoryServiceResult.getSuccess()) {
            return new HashMap<>();
        }
        if (null == categoryServiceResult.getResult() || categoryServiceResult.getResult().size() == 0) {
            return new HashMap<>();
        }
        mapData.putAll(categoryServiceResult.getResult());

        ServiceResult<Map<String, Object>> brandAndSpecListServiceResult = itemSearchService
            .searchBrandAndSpecList(categoryServiceResult.getResult().get("categoryList").get(0));
        if (!brandAndSpecListServiceResult.getSuccess()) {
            return new HashMap<>();
        }
        if (null == brandAndSpecListServiceResult.getResult() || brandAndSpecListServiceResult.getResult().size() == 0) {
            return new HashMap<>();
        }
        mapData.putAll(brandAndSpecListServiceResult.getResult());

        return mapData;
    }
}
