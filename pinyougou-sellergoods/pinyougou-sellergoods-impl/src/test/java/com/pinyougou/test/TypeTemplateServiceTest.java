package com.pinyougou.test;

import com.pinyougou.model.ServiceResult;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pinyougou.itf.TypeTemplateService;
import com.pinyougou.model.PageResult;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.vo.TypeTemplateVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/3
 */
public class TypeTemplateServiceTest {

    private TypeTemplateService typeTemplateService;

    @Before
    public void startup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
        typeTemplateService = (TypeTemplateService) context.getBean("typeTemplateService");
    }

    @Test
    public void testSearch() {
        TypeTemplateVO vo = new TypeTemplateVO();
        vo.setPage(1);
        vo.setRows(20);
        ServiceResult<PageResult<TbTypeTemplate>> serviceResult = typeTemplateService.search(vo);
        System.out.println(serviceResult);
    }
}
