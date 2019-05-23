package com.pinyougou.model.rule;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Component;

import com.pinyougou.model.itf.IRule;
import com.pinyougou.model.param.ImportItemParam;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/23
 */
@Component
public class DeleteItemRule implements IRule {

    private static Logger log = LogManager.getLogger(DeleteItemRule.class);

    @Autowired
    private SolrTemplate  solrTemplate;

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
        Query query = new SimpleQuery();
        Criteria criteria = new Criteria("item_goodsid").in(param.getGoodsIds());
        query.addCriteria(criteria);
        solrTemplate.delete(query);
        solrTemplate.commit();
        log.info("删除商品信息");
    }
}
