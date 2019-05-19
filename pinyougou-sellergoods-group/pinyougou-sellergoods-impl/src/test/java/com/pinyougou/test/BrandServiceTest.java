package com.pinyougou.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pinyougou.itf.BrandService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.SelectOptionVO;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.vo.BrandVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
public class BrandServiceTest {

    private BrandService brandService;

    @Before
    public void startup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
        brandService = (BrandService) context.getBean("brandService");
    }

    @Test
    public void testSearch() {
        BrandVO vo = new BrandVO();
        vo.setPage(1);
        vo.setRows(20);
        ServiceResult<PageResult<TbBrand>> serviceResult = brandService.search(vo);
        System.out.println(serviceResult);
    }

    @Test
    public void testDelete() {
        List<Integer> list = new ArrayList<>();
        list.add(22);
        brandService.delete(list);
    }

    @Test
    public void testFindById() {
        ServiceResult<TbBrand> serviceResult = brandService.findById(30);
        System.out.println(serviceResult);
    }

    @Test
    public void testUpdate() {
        BrandVO vo = new BrandVO();
        vo.setId(30);
        vo.setFirstChar("B");
        vo.setName("javaboyok");
        brandService.update(vo);
    }

    @Test
    public void testSelectOptionList() {
        ServiceResult<List<SelectOptionVO>> serviceResult = brandService.selectOptionList();
        System.out.println(serviceResult);
    }
}
