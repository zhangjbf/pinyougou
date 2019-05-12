package com.pinyougou.content.dao;

import java.util.List;

import com.pinyougou.content.pojo.TbContent;
import com.pinyougou.content.vo.ContentVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
public interface TbContentMapper {

    List<TbContent> search(ContentVO vo);

    Integer add(ContentVO vo);

    Integer delete(List<Integer> listData);

    Integer update(ContentVO vo);

    TbContent findOne(Integer id);
}
