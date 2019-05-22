package com.pinyougou.search.itf;

import java.util.List;
import java.util.Map;

import com.pinyougou.model.ServiceResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/19
 */
public interface ItemSearchService {
    /**
     * 搜索
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/19
     */
    ServiceResult<Map<String, Object>> search(Map searchMap);

    /**
     * 根据关键字搜索分类列表
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/22
     */
    ServiceResult<Map<String, List<String>>> searchCategoryList(Map searchMap);

    /**
     * 查询品牌和规格
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/22
     */
    ServiceResult<Map<String, Object>> searchBrandAndSpecList(String category);
}
