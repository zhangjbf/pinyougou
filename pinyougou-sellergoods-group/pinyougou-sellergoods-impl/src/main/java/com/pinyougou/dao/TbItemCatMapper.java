package com.pinyougou.dao;

import java.util.List;

import com.pinyougou.pojo.TbItemCat;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
public interface TbItemCatMapper {

    List<TbItemCat> findByParentId(Integer parentId);

    Integer add(TbItemCat tbItemCat);

    TbItemCat findOne(Integer id);

    Integer update(TbItemCat tbItemCat);

    Integer delete(List<Integer> ids);

    List<Integer> findByParentIds(List<Integer> ids);
}
