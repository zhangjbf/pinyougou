package com.pinyougou.page.model;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.pinyougou.page.dao.TbGoodsDescMapper;
import com.pinyougou.page.dao.TbGoodsMapper;
import com.pinyougou.page.dao.TbItemCatMapper;
import com.pinyougou.page.dao.TbItemMapper;
import com.pinyougou.page.pojo.TbGoods;
import com.pinyougou.page.pojo.TbGoodsDesc;
import com.pinyougou.page.pojo.TbItem;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/28
 */
@Repository
public class ItemPageModel {

    @Value("${pagedir}")
    private String            pagedir;

    @Autowired
    private TbGoodsMapper     tbGoodsMapper;

    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;

    @Autowired
    private TbItemCatMapper   tbItemCatMapper;

    @Autowired
    private TbItemMapper      tbItemMapper;

    @Autowired
    private FreeMarkerConfig  freeMarkerConfig;

    public Boolean genItemHtml(Integer goodsId) {
        try {
            Configuration configuration = freeMarkerConfig.getConfiguration();
            Template template = configuration.getTemplate("item.ftl");
            Map dataModel = new HashMap<>();
            //1.加载商品表数据
            TbGoods goods = tbGoodsMapper.findOne(goodsId);
            dataModel.put("goods", goods);
            //2.加载商品扩展表数据
            TbGoodsDesc goodsDesc = tbGoodsDescMapper.findDescById(goodsId);
            dataModel.put("goodsDesc", goodsDesc);

            //3.读取商品分类
            String itemCat1 = tbItemCatMapper.findByParentId(goods.getCategory1Id()).get(0).getName();
            String itemCat2 = tbItemCatMapper.findByParentId(goods.getCategory2Id()).get(0).getName();
            String itemCat3 = tbItemCatMapper.findByParentId(goods.getCategory3Id()).get(0).getName();
            dataModel.put("itemCat1", itemCat1);
            dataModel.put("itemCat2", itemCat2);
            dataModel.put("itemCat3", itemCat3);

            List<TbItem> itemList = tbItemMapper.findByGoodsId(goodsId);
            dataModel.put("itemList", itemList);

            Writer out = new FileWriter(pagedir + goodsId + ".html");
            template.process(dataModel, out);
            out.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
