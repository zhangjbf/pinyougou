package com.pinyougou.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.pinyougou.dao.TbItemCatMapper;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.transaction.TransactionSupport;
import com.pinyougou.vo.ItemCatVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
@Repository
public class ItemCatModel extends TransactionSupport {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    public List<TbItemCat> findByParentId(Integer parentId) {
        if (null == parentId) {
            throw new BusinessException("请求参数错误");
        }
        return tbItemCatMapper.findByParentId(parentId);
    }

    public Boolean add(ItemCatVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数错误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            TbItemCat tbItemCat = new TbItemCat();
            tbItemCat.setName(vo.getName());
            tbItemCat.setTypeId(vo.getTypeId());
            tbItemCat.setParentId(vo.getParentId());
            tbItemCatMapper.add(tbItemCat);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("执行失败");
        }
        return Boolean.TRUE;
    }

    public TbItemCat findOne(Integer id) {
        if (null == id || 0 == id) {
            throw new BusinessException("请求参数异常");
        }
        return tbItemCatMapper.findOne(id);
    }

    public Boolean update(ItemCatVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数错误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            TbItemCat tbItemCat = new TbItemCat();
            tbItemCat.setName(vo.getName());
            tbItemCat.setTypeId(vo.getTypeId());
            tbItemCat.setId(vo.getId());
            tbItemCatMapper.update(tbItemCat);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("执行失败");
        }
        return Boolean.TRUE;
    }

    public Boolean delete(List<Integer> ids) {
        if (null == ids || ids.size() == 0) {
            throw new BusinessException("请求参数错误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            List<Integer> listIds = new ArrayList<>(ids);
            this.findAllNeedDeleteIds(ids, listIds);
            tbItemCatMapper.delete(listIds);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("执行失败");
        }
        return Boolean.TRUE;
    }

    private void findAllNeedDeleteIds(List<Integer> ids, List<Integer> listIds) {
        List<Integer> tbItemCatList = tbItemCatMapper.findByParentIds(ids);
        if (null == tbItemCatList || tbItemCatList.size() == 0) {
            return;
        } else {
            listIds.addAll(tbItemCatList);
            findAllNeedDeleteIds(tbItemCatList, listIds);
        }
    }
}
