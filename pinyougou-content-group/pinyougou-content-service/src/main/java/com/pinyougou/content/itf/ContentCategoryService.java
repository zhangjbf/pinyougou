package com.pinyougou.content.itf;

import java.util.List;

import com.pinyougou.content.pojo.TbContentCategory;
import com.pinyougou.content.vo.ContentCategoryVO;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
public interface ContentCategoryService {

    /**
     * 查询所有广告类型
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<PageResult<TbContentCategory>> search(ContentCategoryVO vo);

    /**
     * 新增广告分类
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<Boolean> add(ContentCategoryVO vo);

    /**
     * 删除广告分类
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<Boolean> delete(List<Integer> listData);

    /**
     * 根据id查询广告分类
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<TbContentCategory> findOne(Integer id);

    /**
     * 修改广告分类
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<Boolean> update(ContentCategoryVO vo);

    /**
     * 查询全部广告分类
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/13
     */
    ServiceResult<List<TbContentCategory>> findAll();
}
