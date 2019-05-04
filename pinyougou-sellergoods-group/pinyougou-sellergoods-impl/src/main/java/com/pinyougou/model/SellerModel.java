package com.pinyougou.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.pinyougou.dao.TbSellerMapper;
import com.pinyougou.transaction.TransactionSupport;
import com.pinyougou.vo.SellerVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
@Repository
public class SellerModel extends TransactionSupport {

    @Autowired
    private TbSellerMapper tbSellerMapper;

    public Boolean add(SellerVO vo) {
        if (null == vo) {
            throw new BusinessException("参数为空");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            tbSellerMapper.add(vo);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("保存错误");
        }
        return Boolean.TRUE;
    }
}
