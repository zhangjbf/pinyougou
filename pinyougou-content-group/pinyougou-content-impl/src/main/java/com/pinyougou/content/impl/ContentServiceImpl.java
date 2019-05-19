package com.pinyougou.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyougou.content.itf.ContentService;
import com.pinyougou.content.model.ContentModel;
import com.pinyougou.content.pojo.TbContent;
import com.pinyougou.content.vo.ContentVO;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentModel contentModel;

    @Override
    public ServiceResult<PageResult<TbContent>> search(ContentVO vo) {
        ServiceResult<PageResult<TbContent>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentModel.search(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> add(ContentVO vo) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentModel.add(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> delete(List<Integer> listData) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentModel.delete(listData));
        return serviceResult;
    }

    @Override
    public ServiceResult<Boolean> update(ContentVO vo) {
        ServiceResult<Boolean> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentModel.update(vo));
        return serviceResult;
    }

    @Override
    public ServiceResult<TbContent> findOne(Integer id) {
        ServiceResult<TbContent> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentModel.findOne(id));
        return serviceResult;
    }

    @Override
    public ServiceResult<List<TbContent>> findByCategoryId(Integer categoryId) {
        ServiceResult<List<TbContent>> serviceResult = new ServiceResult<>();
        serviceResult.setResult(contentModel.findByCategoryId(categoryId));
        return serviceResult;
    }
}
