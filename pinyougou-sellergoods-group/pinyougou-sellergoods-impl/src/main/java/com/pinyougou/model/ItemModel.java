package com.pinyougou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.pinyougou.dao.TbItemMapper;
import com.pinyougou.pojo.TbItem;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/19
 */
@Repository
public class ItemModel {

    private static Logger log = LogManager.getLogger(ItemModel.class);

    @Autowired
    private TbItemMapper  tbItemMapper;

    @Autowired
    private SolrTemplate  solrTemplate;

    public Boolean importItem2Solr() {
        List<TbItem> itemList = tbItemMapper.findAll();

        if (null == itemList || itemList.size() > 0) {
            List<String> listData = new ArrayList<>();
            for (TbItem tbItem : itemList) {
                listData.add(String.valueOf(tbItem.getId()));
                Map specMap = JSON.parseObject(tbItem.getSpec());
                tbItem.setSpecMap(specMap);
            }
            log.info("开始清除导入数据");
            solrTemplate.deleteById(listData);
            solrTemplate.commit();
            log.info("清除导入数据完成");
            log.info("开始导入数据");
            solrTemplate.saveBeans(itemList);
            solrTemplate.commit();
            log.info("导入数据完成");
        }
        return Boolean.TRUE;
    }
}
