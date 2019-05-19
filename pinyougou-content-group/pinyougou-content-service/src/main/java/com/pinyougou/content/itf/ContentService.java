package com.pinyougou.content.itf;

import java.util.List;

import com.pinyougou.content.pojo.TbContent;
import com.pinyougou.content.vo.ContentVO;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
public interface ContentService {
    /**
     * 查询广告分页
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<PageResult<TbContent>> search(ContentVO vo);

    /**
     * 保存广告
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<Boolean> add(ContentVO vo);

    /**
     * 删除广告
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<Boolean> delete(List<Integer> listData);

    /**
     * 修改广告
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/12
     */
    ServiceResult<Boolean> update(ContentVO vo);

    /**
     * 根据id查询广告
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/13
     */
    ServiceResult<TbContent> findOne(Integer id);

    /**
     * 根据分类id查询广告
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/13
     */
    ServiceResult<List<TbContent>> findByCategoryId(Integer categoryId);
}
