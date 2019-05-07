package com.pinyougou.itf;

import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.vo.GoodsVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/7
 */
public interface GoodsService {

    /**
     * 查询商品列表
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/7
     */
    ServiceResult<PageResult<TbGoods>> search(GoodsVO vo);
}
