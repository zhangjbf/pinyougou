package com.pinyougou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.vo.SellerVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
public interface TbSellerMapper {

    Integer add(SellerVO vo);

    List<TbSeller> search(SellerVO vo);

    TbSeller findOne(String sellerId);

    Integer updateStatus(@Param("sellerId") String sellerId, @Param("status") String status);
}
