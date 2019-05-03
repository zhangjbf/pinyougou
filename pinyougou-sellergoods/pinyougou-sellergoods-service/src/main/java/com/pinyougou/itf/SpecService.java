package com.pinyougou.itf;

import java.util.List;

import com.pinyougou.model.PageResult;
import com.pinyougou.model.SelectOptionVO;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.vo.SpecificationVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
public interface SpecService {

    /**
     * 规格查询
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<PageResult<TbSpecification>> search(SpecificationVO specificationVO);

    /**
     * 规格添加
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<Boolean> add(SpecificationVO specificationVO);

    /**
     * 删除规格
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<Boolean> delete(List<Integer> ids);

    /**
     * 通过id查询规格
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<SpecificationVO> findOne(Integer id);

    /**
     * 修改保存
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<Boolean> update(SpecificationVO specificationVO);

    /**
     * 获取规格json
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/3
     */
    ServiceResult<List<SelectOptionVO>> selectOptionList();
}
