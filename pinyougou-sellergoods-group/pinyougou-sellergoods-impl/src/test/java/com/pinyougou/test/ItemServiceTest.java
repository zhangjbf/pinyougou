package com.pinyougou.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pinyougou.itf.ItemService;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/1
 */
public class ItemServiceTest {

    private ItemService itemService;

    @Before
    public void startup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
        itemService = (ItemService) context.getBean("itemService");
    }

    @Test
    public void testlistItem() {
        itemService.importItem2Solr();
    }
}
