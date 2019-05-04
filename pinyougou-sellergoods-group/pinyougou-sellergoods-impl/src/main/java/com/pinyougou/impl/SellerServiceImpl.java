package com.pinyougou.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.itf.SellerService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.SellerModel;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.vo.SellerVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
@Service("sellerService")
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerModel sellerModel;

    @Override
    public ServiceResult<Boolean> add(SellerVO vo) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(sellerModel.add(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<PageResult<TbSeller>> search(SellerVO vo) {
        ServiceResult<PageResult<TbSeller>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(sellerModel.search(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<TbSeller> findOne(String sellerId) {
        ServiceResult<TbSeller> serviceResult = new ServiceResult<>();
        serviceResult.setResult(sellerModel.findOne(sellerId));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> updataStatus(String sellerId, String status) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(sellerModel.updataStatus(sellerId,status));
        return serviceResult;
    }
}
