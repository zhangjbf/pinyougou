package com.pinyougou.itf;

import com.pinyougou.model.ServiceResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/19
 */
public interface ItemService {

    /**
     * 导入商品数据
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/19
     */
    ServiceResult<Boolean> importItem2Solr();

}
