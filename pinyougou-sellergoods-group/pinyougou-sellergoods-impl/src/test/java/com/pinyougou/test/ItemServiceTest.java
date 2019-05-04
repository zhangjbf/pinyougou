package com.pinyougou.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pinyougou.itf.ItemService;
import com.pinyougou.pojo.TbItem;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
        itemService = (ItemService) context.getBean("itemService");
    }

    @Test
    public void testlistItem() {
        List<TbItem> tbItems = itemService.listItem();
        System.out.println(tbItems);
    }
}
