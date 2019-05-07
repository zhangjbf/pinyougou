package com.pinyougou.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.dao.TbGoodsMapper;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.vo.GoodsVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/7
 */
@Repository
public class GoodsModel {

    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    public PageResult<TbGoods> search(GoodsVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数为空");
        }
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<TbGoods> tbGoodsList = tbGoodsMapper.search(vo);
        PageInfo<TbGoods> info = new PageInfo<>(tbGoodsList);
        return new PageResult<>(info.getTotal(), info.getList());
    }
}
