package com.pinyougou.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.dao.TbSellerMapper;
import com.pinyougou.pojo.TbSeller;
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

        vo.setStatus("0");
        vo.setCreateTime(new Date());

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

    public PageResult<TbSeller> search(SellerVO vo) {
        if (null == vo) {
            throw new BusinessException("参数为空");
        }
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<TbSeller> tbSellerList = tbSellerMapper.search(vo);
        PageInfo<TbSeller> info = new PageInfo<>(tbSellerList);
        return new PageResult<>(info.getTotal(), info.getList());
    }

    public TbSeller findOne(String sellerId) {
        if (StringUtils.isEmpty(sellerId)) {
            throw new BusinessException("参数错误");
        }
        return tbSellerMapper.findOne(sellerId);
    }

    public Boolean updataStatus(String sellerId, String status) {
        if (StringUtils.isEmpty(sellerId) || StringUtils.isEmpty(status)) {
            throw new BusinessException("请求参数错误");
        }
        TransactionStatus transactionStatus = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            tbSellerMapper.updateStatus(sellerId, status);
            this.commitTransaction(transactionStatus);
        } catch (Exception e) {
            this.rollbackTransaction(transactionStatus);
            throw new BusinessException("执行失败");
        }
        return Boolean.TRUE;
    }
}
