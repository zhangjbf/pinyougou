package com.pinyougou.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.dao.TbBrandMapper;
import com.pinyougou.dao.TbGoodsDescMapper;
import com.pinyougou.dao.TbGoodsMapper;
import com.pinyougou.dao.TbItemCatMapper;
import com.pinyougou.dao.TbItemMapper;
import com.pinyougou.dao.TbSellerMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.pojo.TbSeller;
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

    @Autowired
    private TbItemMapper      tbItemMapper;

    @Autowired
    private TbBrandMapper     tbBrandMapper;

    @Autowired
    private TbItemCatMapper   tbItemCatMapper;

    @Autowired
    private TbSellerMapper    tbSellerMapper;

    @Autowired
    private TbItemMapper      TbItemMapper;

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

            List<TbItem> itemList = vo.getItemList();

            String title = goods.getGoodsName();

            for (TbItem item : itemList) {
                Map<String, Object> specMap = JSON.parseObject(item.getSpec());
                for (String key : specMap.keySet()) {
                    title += " " + specMap.get(key);
                }
                item.setTitle(title);
                item.setGoodsId(goods.getId());//商品SPU编号
                item.setSellerId(goods.getSellerId());//商家编号
                item.setCategoryId(goods.getCategory3Id());//商品分类编号（3级）
                item.setCreateTime(new Date());//创建日期
                item.setUpdateTime(new Date());//修改日期
                //品牌名称
                TbBrand brand = tbBrandMapper.findById(goods.getBrandId());
                item.setBrand(brand.getName());
                //分类名称
                TbItemCat itemCat = tbItemCatMapper.findOne(goods.getCategory3Id());
                item.setCategory(itemCat.getName());
                //商家名称
                TbSeller seller = tbSellerMapper.findOne(goods.getSellerId());
                if (null != seller) {
                    item.setSeller(seller.getNickName());
                }
                //图片地址（取spu的第一个图片）
                List<Map> imageList = JSON.parseArray(vo.getGoodsDesc().getItemImages(), Map.class);
                if (imageList.size() > 0) {
                    item.setImage((String) imageList.get(0).get("url"));
                }
                tbItemMapper.add(item);
            }
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

        List<TbItem> tbItemList = TbItemMapper.findByGoodsId(id);
        goodsVO.setItemList(tbItemList);

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
