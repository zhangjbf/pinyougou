package com.pinyougou.search.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.pinyougou.search.pojo.TbItem;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/19
 */
@Repository
public class ItemSearchModel {

    @Autowired
    private SolrTemplate solrTemplate;

    public Map<String, Object> search(Map searchMap) {
        Map<String, Object> mapResult = new HashMap<>();

        String keywords = (String) searchMap.get("keywords");
        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_keywords");
        if (!StringUtils.isEmpty(keywords)) {
            criteria.is(searchMap.get("keywords"));
            query.addCriteria(criteria);
        }
        query.setOffset((Integer) searchMap.get("pageNo"));
        query.setRows((Integer) searchMap.get("pageSize"));

        ScoredPage<TbItem> pages = solrTemplate.queryForPage(query, TbItem.class);
        mapResult.put("rows", pages.getContent());

        return mapResult;
    }
}
