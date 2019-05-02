package com.pinyougou.itf;

import java.util.List;

import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.vo.BrandVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
public interface BrandService {
    /**
     * 品牌分页查询
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<PageResult<TbBrand>> search(BrandVO brandVO);

    /**
     * 品牌新增
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<Boolean> save(BrandVO brandVO);

    /**
     * 根据ids删除（物理删除）
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<Boolean> delete(List<Integer> ids);

    /**
     * 根据id查询品牌
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<TbBrand> findById(Integer id);

    /**
     * 修改保存
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/2
     */
    ServiceResult<Boolean> update(BrandVO brandVO);
}
