package com.pinyougou.content.dao;

import java.util.List;

import com.pinyougou.content.pojo.TbContentCategory;
import com.pinyougou.content.vo.ContentCategoryVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
public interface TbContentCategoryMapper {

    List<TbContentCategory> search(ContentCategoryVO vo);

    Integer add(ContentCategoryVO vo);

    Integer delete(List<Integer> listData);

    TbContentCategory findOne(Integer id);

    Integer update(ContentCategoryVO vo);

    List<TbContentCategory> findAll();
}
