package com.pinyougou.impl;

import java.util.List;

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

    @Override
    public ServiceResult<Boolean> add(GoodsVO vo) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(goodsModel.add(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<GoodsVO> findOne(Integer id) {
        ServiceResult<GoodsVO> serviceResult = new ServiceResult<>();
        serviceResult.setResult(goodsModel.findOne(id));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> delete(List<Integer> listData) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(goodsModel.delete(listData));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> update(GoodsVO vo) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(goodsModel.update(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> updateStatus(List<Integer> listData,String status) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(goodsModel.updateStatus(listData,status));
        return serviceResult;
    }
}
