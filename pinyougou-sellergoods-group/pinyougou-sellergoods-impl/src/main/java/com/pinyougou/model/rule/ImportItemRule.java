package com.pinyougou.model.rule;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinyougou.dao.TbItemMapper;
import com.pinyougou.model.ItemModel;
import com.pinyougou.model.itf.IRule;
import com.pinyougou.model.param.ImportItemParam;
import com.pinyougou.pojo.TbItem;

/**
 * 商品审核通过之后
 *
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/23
 */
@Component
public class ImportItemRule implements IRule {

    private static Logger log = LogManager.getLogger(ImportItemRule.class);

    @Autowired
    private TbItemMapper  tbItemMapper;

    @Autowired
    private ItemModel     itemModel;

    @Override
    public void process(Object obj) {
        if (null == obj) {
            return;
        }
        ImportItemParam param = null;
        if (obj instanceof ImportItemParam) {
            param = (ImportItemParam) obj;
        }
        if (null == param) {
            log.error("参数异常");
            return;
        }
        if ("1".equals(param.getStatus())) {
            List<TbItem> tbItemList = tbItemMapper.findByGoodsIdAndStatus(param.getGoodsIds(), param.getStatus());
            Boolean result = itemModel.importItem2Solr(tbItemList);
            log.info("导入商品搜索成功,商品id[" + param.getGoodsIds() + "]");
        }
    }
}
