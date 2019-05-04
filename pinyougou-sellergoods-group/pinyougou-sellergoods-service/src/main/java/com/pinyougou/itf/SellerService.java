package com.pinyougou.itf;

import com.pinyougou.model.ServiceResult;
import com.pinyougou.vo.SellerVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
public interface SellerService {
    /**
     * 新用户注册
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/4
     */
    ServiceResult<Boolean> add(SellerVO vo);
}
