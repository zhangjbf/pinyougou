package com.pinyougou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.vo.GoodsVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/7
 */
public interface TbGoodsMapper {

    List<TbGoods> search(GoodsVO vo);

    Integer add(TbGoods goods);

    TbGoods findOne(Integer id);

    Integer delete(List<Integer> listData);

    Integer update(TbGoods goods);

    Integer updateStatus(@Param("list") List<Integer> listData, @Param("status") String goodsStatus);
}
