package com.pinyougou.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/1
 */
public class ItemServiceTest {

    @Before
    public void startup() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
    }

    @Test
    public void testlistItem() {
    }
}
