package com.pinyougou.itf;

import java.util.List;

import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.vo.GoodsVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/7
 */
public interface GoodsService {

    /**
     * 查询商品列表
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/7
     */
    ServiceResult<PageResult<TbGoods>> search(GoodsVO vo);

    /**
     * 新增商品
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/8
     */
    ServiceResult<Boolean> add(GoodsVO vo);

    /**
     * 根据id查询商品
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/8
     */
    ServiceResult<GoodsVO> findOne(Integer id);

    /**
     * 批量删除商品
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/8
     */
    ServiceResult<Boolean> delete(List<Integer> listData);

    /**
     * 修改商品数据
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<Boolean> update(GoodsVO vo);

    /**
     * 批量送审
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<Boolean> updateStatus(List<Integer> listData,String status);
}
