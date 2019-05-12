package com.pinyougou.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.content.itf.ContentCategoryService;
import com.pinyougou.content.model.ContentCategoryModel;
import com.pinyougou.content.pojo.TbContentCategory;
import com.pinyougou.content.vo.ContentCategoryVO;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
@Service("contentCategoryService")
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryModel contentCategoryModel;

    @Override
    public ServiceResult<PageResult<TbContentCategory>> search(ContentCategoryVO vo) {
        ServiceResult<PageResult<TbContentCategory>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentCategoryModel.search(vo));
        return serviceResult;

    }

    @Override
    public ServiceResult<Boolean> add(ContentCategoryVO vo) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentCategoryModel.add(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> delete(List<Integer> listData) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentCategoryModel.delete(listData));
        return serviceResult;
    }

    @Override
    public ServiceResult<TbContentCategory> findOne(Integer id) {
        ServiceResult<TbContentCategory> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentCategoryModel.findOne(id));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> update(ContentCategoryVO vo) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentCategoryModel.update(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<List<TbContentCategory>> findAll() {
        ServiceResult<List<TbContentCategory>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentCategoryModel.findAll());
        return serviceResult;
    }
}
