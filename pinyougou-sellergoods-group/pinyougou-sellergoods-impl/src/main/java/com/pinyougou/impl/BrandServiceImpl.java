package com.pinyougou.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.itf.BrandService;
import com.pinyougou.model.BrandModel;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.SelectOptionVO;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.vo.BrandVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandModel brandModel;

    @Override
    public ServiceResult<PageResult<TbBrand>> search(BrandVO brandVO) {
        ServiceResult<PageResult<TbBrand>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(brandModel.search(brandVO));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> save(BrandVO brandVO) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(brandModel.save(brandVO));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> delete(List<Integer> ids) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(brandModel.delete(ids));
        return serviceResult;
    }

    @Override
    public ServiceResult<TbBrand> findById(Integer id) {
        ServiceResult<TbBrand> serviceResult = new ServiceResult<>();
        serviceResult.setResult(brandModel.findById(id));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> update(BrandVO brandVO) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(brandModel.update(brandVO));
        return serviceResult;
    }

    @Override
    public ServiceResult<List<SelectOptionVO>> selectOptionList() {
        ServiceResult<List<SelectOptionVO>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(brandModel.selectOptionList());
        return serviceResult;
    }
}
