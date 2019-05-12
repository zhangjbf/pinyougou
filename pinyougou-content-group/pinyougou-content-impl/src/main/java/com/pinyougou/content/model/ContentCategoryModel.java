package com.pinyougou.content.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.content.dao.TbContentCategoryMapper;
import com.pinyougou.content.pojo.TbContentCategory;
import com.pinyougou.content.transaction.TransactionSupport;
import com.pinyougou.content.vo.ContentCategoryVO;
import com.pinyougou.model.BusinessException;
import com.pinyougou.model.PageResult;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
@Repository
public class ContentCategoryModel extends TransactionSupport {

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    public PageResult<TbContentCategory> search(ContentCategoryVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数为空");
        }
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<TbContentCategory> contentCategoryList = tbContentCategoryMapper.search(vo);
        PageInfo<TbContentCategory> info = new PageInfo<>(contentCategoryList);

        return new PageResult<>(info.getTotal(), info.getList());
    }

    public Boolean add(ContentCategoryVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数为空");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            tbContentCategoryMapper.add(vo);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("执行失败");
        }
        return Boolean.TRUE;
    }

    public Boolean delete(List<Integer> listData) {
        if (null == listData || listData.size() == 0) {
            throw new BusinessException("请求参数为空");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            tbContentCategoryMapper.delete(listData);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("执行失败");
        }
        return Boolean.TRUE;
    }

    public TbContentCategory findOne(Integer id) {
        if (null == id || id == 0) {
            throw new BusinessException("请求参数错误");
        }
        return tbContentCategoryMapper.findOne(id);
    }

    public Boolean update(ContentCategoryVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数为空");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            tbContentCategoryMapper.update(vo);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("执行失败");
        }
        return Boolean.TRUE;
    }

    public List<TbContentCategory> findAll() {
        return tbContentCategoryMapper.findAll();
    }
}
