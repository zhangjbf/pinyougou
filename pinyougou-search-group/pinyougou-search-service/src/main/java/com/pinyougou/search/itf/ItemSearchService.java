package com.pinyougou.search.itf;

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
}
