package com.pinyougou.itf;

import java.util.List;

import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.vo.ItemCatVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
public interface ItemCatService {
    /**
     * 根据parentId查询分类列表
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/4
     */
    ServiceResult<List<TbItemCat>> findByParentId(Integer parentId);

    /**
     * 新增商品分类
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/5
     */
    ServiceResult<Boolean> add(ItemCatVO vo);

    /**
     * 根据id查询商品分类
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/5
     */
    ServiceResult<TbItemCat> findOne(Integer id);

    /**
     * 修改商品分类
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/5
     */
    ServiceResult<Boolean> update(ItemCatVO vo);

    /**
     * 删除商品分类
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/5
     */
    ServiceResult<Boolean> delete(List<Integer> ids);
}
