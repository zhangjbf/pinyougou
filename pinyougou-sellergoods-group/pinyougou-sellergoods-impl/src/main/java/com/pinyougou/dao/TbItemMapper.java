package com.pinyougou.dao;

import java.util.List;

import com.pinyougou.pojo.TbItem;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/1
 */
public interface TbItemMapper {

    Integer add(TbItem tbItem);

    List<TbItem> findByGoodsId(Integer id);

    Integer update(TbItem item);

    List<TbItem> findAll();
}
