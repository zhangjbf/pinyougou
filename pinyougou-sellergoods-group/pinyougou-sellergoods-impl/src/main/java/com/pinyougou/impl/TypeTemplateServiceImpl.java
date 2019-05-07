package com.pinyougou.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.itf.TypeTemplateService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.TypeTemplateModel;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.vo.SpecVO;
import com.pinyougou.vo.TypeTemplateVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/3
 */
@Service("typeTemplateService")
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TypeTemplateModel typeTemplateModel;

    @Override
    public ServiceResult<PageResult<TbTypeTemplate>> search(TypeTemplateVO vo) {
        ServiceResult<PageResult<TbTypeTemplate>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(typeTemplateModel.search(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> add(TypeTemplateVO vo) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(typeTemplateModel.add(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> delete(List<Integer> listData) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(typeTemplateModel.delete(listData));
        return serviceResult;
    }

    @Override
    public ServiceResult<TbTypeTemplate> findOne(Integer id) {
        ServiceResult<TbTypeTemplate> serviceResult = new ServiceResult<>();
        serviceResult.setResult(typeTemplateModel.findOne(id));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> update(TypeTemplateVO vo) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(typeTemplateModel.update(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<List<SpecVO>> findBySpecList(Integer id) {
        ServiceResult<List<SpecVO>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(typeTemplateModel.findBySpecList(id));
        return serviceResult;
    }
}
