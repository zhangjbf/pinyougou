package com.pinyougou.dao;

import java.util.List;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
public interface TbSpecificationOptionMapper {

    Integer add(TbSpecificationOption tbSpecificationOption);

    Integer delete(List<Integer> specIds);

    List<TbSpecificationOption> findBySepcId(Integer id);

    Integer update(TbSpecificationOption tbSpecificationOption);
}
