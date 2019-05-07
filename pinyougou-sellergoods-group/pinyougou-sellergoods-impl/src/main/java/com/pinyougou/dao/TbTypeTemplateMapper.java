package com.pinyougou.dao;

import java.util.List;

import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.vo.TypeTemplateVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/3
 */
public interface TbTypeTemplateMapper {

    List<TbTypeTemplate> search(TypeTemplateVO vo);

    Integer add(TbTypeTemplate tbTypeTemplate);

    Integer delete(List<Integer> listData);

    TbTypeTemplate findOne(Integer id);

    Integer update(TbTypeTemplate tbTypeTemplate);

    String findBySpecList(Integer id);
}
