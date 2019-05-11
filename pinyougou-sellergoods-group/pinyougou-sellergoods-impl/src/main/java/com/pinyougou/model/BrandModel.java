package com.pinyougou.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.dao.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.transaction.TransactionSupport;
import com.pinyougou.vo.BrandVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
@Repository
public class BrandModel extends TransactionSupport {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    public PageResult<TbBrand> search(BrandVO brandVO) {
        if (null == brandVO) {
            throw new BusinessException("请求参数错误");
        }
        PageHelper.startPage(brandVO.getPage(), brandVO.getRows());
        List<TbBrand> brandList = tbBrandMapper.search(brandVO);
        PageInfo<TbBrand> info = new PageInfo<>(brandList);
        return new PageResult<>(info.getTotal(), info.getList());
    }

    public Boolean save(BrandVO brandVO) {
        if (null == brandVO) {
            throw new BusinessException("请求参数错误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            Integer row = tbBrandMapper.save(brandVO);
            this.commitTransaction(status);
            return row > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("系统异常,请稍后再试！");
        }
    }

    public Boolean delete(List<Integer> ids) {
        if (null == ids || ids.size() == 0) {
            throw new BusinessException("参数有误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            tbBrandMapper.delete(ids);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("系统异常,请稍后再试！");
        }
        return Boolean.TRUE;
    }

    public TbBrand findById(Integer id) {
        if (null == id || id == 0) {
            throw new BusinessException("参数有误");
        }
        return tbBrandMapper.findById(id);
    }

    public Boolean update(BrandVO brandVO) {
        if (null == brandVO || null == brandVO.getId()) {
            throw new BusinessException("系统异常");
        }
        TransactionStatus staus = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            Integer row = tbBrandMapper.update(brandVO);
            this.commitTransaction(staus);
            return row > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            this.rollbackTransaction(staus);
            throw new BusinessException("系统异常");
        }
    }

    public List<SelectOptionVO> selectOptionList() {
        List<SelectOptionVO> listData = new ArrayList<>();

        BrandVO brandVO = new BrandVO();
        List<TbBrand> tbBrands = tbBrandMapper.search(brandVO);
        if (null != tbBrands && tbBrands.size() > 0) {
            SelectOptionVO vo = null;
            for (TbBrand tbBrand : tbBrands) {
                vo = new SelectOptionVO();
                vo.setId(String.valueOf(tbBrand.getId()));
                vo.setText(tbBrand.getName());
                listData.add(vo);
            }
        }
        return listData;
    }
}
