package com.pinyougou.page.itf;

import com.pinyougou.model.ServiceResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/28
 */
public interface ItemPageService {

    /**
     * 生成商品详情页
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/28
     */
    ServiceResult<Boolean> genItemHtml(Integer goodsId);
}
