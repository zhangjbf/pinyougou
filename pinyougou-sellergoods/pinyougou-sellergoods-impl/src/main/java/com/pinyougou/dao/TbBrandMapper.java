package com.pinyougou.dao;

import java.util.List;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.vo.BrandVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
public interface TbBrandMapper {

    List<TbBrand> search(BrandVO brandVO);

    Integer save(BrandVO brandVO);

    void delete(List<Integer> ids);

    TbBrand findById(Integer id);

    Integer update(BrandVO brandVO);
}
