package com.pinyougou.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pinyougou.pojo.TbSpecificationOption;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pinyougou.itf.SpecService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.vo.SpecificationVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
public class SpecServiceTest {

    private SpecService specService;

    @Before
    public void startup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
        specService = (SpecService) context.getBean("specService");
    }

    @Test
    public void testSearch() {
        SpecificationVO vo = new SpecificationVO();
        vo.setPage(1);
        vo.setRows(20);
        ServiceResult<PageResult<TbSpecification>> serviceResult = specService.search(vo);
        System.out.println(serviceResult);
    }

    @Test
    public void add(){
        TbSpecification tbSpecification = new TbSpecification();
        tbSpecification.setSpecName("javaboy");

        TbSpecificationOption tbSpecificationOption = new TbSpecificationOption();
        tbSpecificationOption.setOptionName("javaboyok");
        tbSpecificationOption.setOrders(1);
        
        List<TbSpecificationOption> listData = new ArrayList<>();
        listData.add(tbSpecificationOption);

        SpecificationVO vo = new SpecificationVO();
        vo.setSpecification(tbSpecification);
        vo.setSpecificationOptionList(listData);
        ServiceResult<Boolean> serviceResult = specService.add(vo);
        System.out.println(serviceResult);
    }

    @Test
    public void testDelete(){
        ServiceResult<Boolean> serviceResult = specService.delete(Arrays.asList(34));
        System.out.println(serviceResult);
    }

    @Test
    public void testFindOne(){
        ServiceResult<SpecificationVO> serviceResult = specService.findOne(26);
        System.out.println(serviceResult);
    }

}
