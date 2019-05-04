package com.pinyougou.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.itf.SellerService;
import com.pinyougou.model.SellerModel;
import com.pinyougou.model.ServiceResult;
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
}
