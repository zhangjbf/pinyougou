package com.pinyougou.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.dao.TbGoodsDescMapper;
import com.pinyougou.dao.TbGoodsMapper;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.transaction.TransactionSupport;
import com.pinyougou.vo.GoodsVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/7
 */
@Repository
public class GoodsModel extends TransactionSupport {

    @Autowired
    private TbGoodsMapper     tbGoodsMapper;

    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;

    public PageResult<TbGoods> search(GoodsVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数为空");
        }
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<TbGoods> tbGoodsList = tbGoodsMapper.search(vo);
        PageInfo<TbGoods> info = new PageInfo<>(tbGoodsList);
        return new PageResult<>(info.getTotal(), info.getList());
    }

    public Boolean add(GoodsVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数为空");
        }

        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            TbGoods goods = vo.getGoods();
            TbGoodsDesc goodsDesc = vo.getGoodsDesc();

            tbGoodsMapper.add(goods);
            goodsDesc.setGoodsId(goods.getId());
            tbGoodsDescMapper.add(goodsDesc);

            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("执行失败");
        }
        return Boolean.TRUE;
    }

    public GoodsVO findOne(Integer id) {
        if (null == id || id == 0) {
            throw new BusinessException("请求参数错误");
        }
        GoodsVO goodsVO = new GoodsVO();
        TbGoods tbGoods = tbGoodsMapper.findOne(id);
        TbGoodsDesc tbGoodsDesc = tbGoodsDescMapper.findDescById(id);
        goodsVO.setGoods(tbGoods);
        goodsVO.setGoodsDesc(tbGoodsDesc);

        return goodsVO;
    }

    public Boolean delete(List<Integer> listData) {
        if (null == listData || listData.size() == 0) {
            throw new BusinessException("请求参数错误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            tbGoodsMapper.delete(listData);
            tbGoodsDescMapper.delete(listData);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("执行失败");
        }
        return Boolean.TRUE;
    }
}
