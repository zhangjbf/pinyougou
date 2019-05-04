package com.pinyougou.itf;

import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.vo.SellerVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
public interface SellerService {
    /**
     * 商家注册
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/4
     */
    ServiceResult<Boolean> add(SellerVO vo);

    /**
     * 商家分页查询
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/4
     */
    ServiceResult<PageResult<TbSeller>> search(SellerVO vo);

    /**
     * 查询商家详情
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/4
     */
    ServiceResult<TbSeller> findOne(String sellerId);

    /**
     * 商家审核
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/4
     */
    ServiceResult<Boolean> updataStatus(String sellerId, String status);
}
