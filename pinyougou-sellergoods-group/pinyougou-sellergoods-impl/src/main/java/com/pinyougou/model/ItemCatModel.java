package com.pinyougou.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pinyougou.dao.TbItemCatMapper;
import com.pinyougou.pojo.TbItemCat;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
@Repository
public class ItemCatModel {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    public List<TbItemCat> findByParentId(Integer parentId) {
        if (null == parentId) {
            throw new BusinessException("请求参数错误");
        }
        return tbItemCatMapper.findByParentId(parentId);
    }
}
