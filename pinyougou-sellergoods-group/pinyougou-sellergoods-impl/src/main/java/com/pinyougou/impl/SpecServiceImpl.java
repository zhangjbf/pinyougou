package com.pinyougou.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.itf.SpecService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.SelectOptionVO;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.SpecModel;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.vo.SpecificationVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
@Service("specService")
public class SpecServiceImpl implements SpecService {

    @Autowired
    private SpecModel specModel;

    @Override
    public ServiceResult<PageResult<TbSpecification>> search(SpecificationVO specificationVO) {
        ServiceResult<PageResult<TbSpecification>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(specModel.search(specificationVO));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> add(SpecificationVO specificationVO) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(specModel.add(specificationVO));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> delete(List<Integer> ids) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(specModel.delete(ids));
        return serviceResult;
    }

    @Override
    public ServiceResult<SpecificationVO> findOne(Integer id) {
        ServiceResult<SpecificationVO> serviceResult = new ServiceResult<>();
        serviceResult.setResult(specModel.findOne(id));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> update(SpecificationVO specificationVO) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(specModel.update(specificationVO));
        return serviceResult;
    }

    @Override
    public ServiceResult<List<SelectOptionVO>> selectOptionList() {
        ServiceResult<List<SelectOptionVO>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(specModel.selectOptionList());
        return serviceResult;
    }
}
