package com.pinyougou.search.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.GroupOptions;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.HighlightQuery;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.GroupEntry;
import org.springframework.data.solr.core.query.result.GroupPage;
import org.springframework.data.solr.core.query.result.GroupResult;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
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
    private SolrTemplate  solrTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public Map<String, Object> search(Map searchMap) {
        Map<String, Object> mapResult = new HashMap<>();

        HighlightQuery query = new SimpleHighlightQuery();
        HighlightOptions highlightOptions = new HighlightOptions().addField("item_title");//设置高亮的域
        highlightOptions.setSimplePrefix("<em style='color:red'>");//高亮前缀
        highlightOptions.setSimplePostfix("</em>");//高亮后缀
        query.setHighlightOptions(highlightOptions);//设置高亮选项

        String keywords = (String) searchMap.get("keywords");
        Criteria criteria = new Criteria("item_keywords");
        if (!StringUtils.isEmpty(keywords)) {
            criteria.is(searchMap.get("keywords"));
            query.addCriteria(criteria);
        } else {
            criteria.is("手机");
            query.addCriteria(criteria);
        }
        Integer pageNo = (Integer) searchMap.get("pageNo");
        Integer pageSize = (Integer) searchMap.get("pageSize");

        query.setOffset((pageNo - 1) * pageSize);
        query.setRows(pageSize);

        HighlightPage<TbItem> pages = solrTemplate.queryForHighlightPage(query, TbItem.class);
        for (HighlightEntry<TbItem> h : pages.getHighlighted()) {//循环高亮入口集合
            TbItem item = h.getEntity();//获取原实体类
            if (h.getHighlights().size() > 0 && h.getHighlights().get(0).getSnipplets().size() > 0) {
                item.setTitle(h.getHighlights().get(0).getSnipplets().get(0));//设置高亮的结果
            }
        }

        mapResult.put("rows", pages.getContent());

        return mapResult;
    }

    public Map<String, List<String>> searchCategoryList(Map searchMap) {
        Map<String, List<String>> mapData = new HashMap<>();
        List<String> listData = new ArrayList<>();

        Query query = new SimpleQuery();
        String keywords = (String) searchMap.get("keywords");
        Criteria criteria = new Criteria("item_keywords");
        if (!StringUtils.isEmpty(keywords)) {
            criteria.is(searchMap.get("keywords"));
            query.addCriteria(criteria);
        } else {
            criteria.is("手机");
            query.addCriteria(criteria);
        }
        query.addCriteria(criteria);

        GroupOptions groupOptions = new GroupOptions().addGroupByField("item_category");
        query.setGroupOptions(groupOptions);

        GroupPage<TbItem> pages = solrTemplate.queryForGroupPage(query, TbItem.class);

        GroupResult<TbItem> groupResult = pages.getGroupResult("item_category");
        Page<GroupEntry<TbItem>> groupEntries = groupResult.getGroupEntries();

        List<GroupEntry<TbItem>> content = groupEntries.getContent();
        for (GroupEntry<TbItem> groupEntry : content) {
            listData.add(groupEntry.getGroupValue());
        }
        mapData.put("categoryList", listData);

        return mapData;
    }

    public Map<String, Object> searchBrandAndSpecList(String category) {
        Map<String, Object> mapData = new HashMap<>();
        Integer typteId = (Integer) redisTemplate.boundHashOps("itemCat").get(category);
        if (null != typteId && typteId != 0) {
            String brandList = (String) redisTemplate.boundHashOps("brandList").get(typteId);
            mapData.put("brandList",brandList);
            String specList = (String) redisTemplate.boundHashOps("specList").get(typteId);
            mapData.put("specList",brandList);
        }
        return mapData;
    }
}
