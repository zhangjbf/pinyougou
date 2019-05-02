package com.pinyougou.dao;

import java.util.List;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.vo.SpecificationVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
public interface TbSpecificationMapper {

    List<TbSpecification> search(SpecificationVO specificationVO);

    Integer add(TbSpecification tbSpecification);

    Integer delete(List<Integer> ids);

    TbSpecification findOne(Integer id);

    Integer update(TbSpecification tbSpecification);
}
