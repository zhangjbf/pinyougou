package com.pinyougou.page.dao;

import java.util.List;

import com.pinyougou.page.pojo.TbItem;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/1
 */
public interface TbItemMapper {

    List<TbItem> findByGoodsId(Integer id);

}
