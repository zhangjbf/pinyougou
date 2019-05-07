package com.pinyougou.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.itf.GoodsService;
import com.pinyougou.model.GoodsModel;
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
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsModel goodsModel;

    @Override
    public ServiceResult<PageResult<TbGoods>> search(GoodsVO vo) {
        ServiceResult<PageResult<TbGoods>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(goodsModel.search(vo));
        return serviceResult;
    }
}
