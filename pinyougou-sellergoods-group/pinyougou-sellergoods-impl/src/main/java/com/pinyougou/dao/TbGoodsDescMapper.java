package com.pinyougou.dao;

import java.util.List;

import com.pinyougou.pojo.TbGoodsDesc;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/8
 */
public interface TbGoodsDescMapper {

    Integer add(TbGoodsDesc goodsDesc);

    TbGoodsDesc findDescById(Integer goodsId);

    Integer delete(List<Integer> listData);

    Integer update(TbGoodsDesc goodsDesc);
}
