package com.pinyougou.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.dao.TbSpecificationMapper;
import com.pinyougou.dao.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.transaction.TransactionSupport;
import com.pinyougou.vo.SpecificationVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
@Repository
public class SpecModel extends TransactionSupport {

    @Autowired
    private TbSpecificationMapper       tbSpecificationMapper;

    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    public PageResult<TbSpecification> search(SpecificationVO specificationVO) {
        if (null == specificationVO) {
            throw new BusinessException("参数有误");
        }
        PageHelper.startPage(specificationVO.getPage(), specificationVO.getRows());
        List<TbSpecification> specificationList = tbSpecificationMapper.search(specificationVO);
        PageInfo<TbSpecification> info = new PageInfo<>(specificationList);
        return new PageResult<>(info.getTotal(), info.getList());
    }

    public Boolean add(SpecificationVO specificationVO) {
        if (null == specificationVO) {
            throw new BusinessException("参数有误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            TbSpecification tbSpecification = specificationVO.getSpecification();
            tbSpecificationMapper.add(tbSpecification);
            Integer id = tbSpecification.getId();
            List<TbSpecificationOption> tbSpecificationOptions = specificationVO.getSpecificationOptionList();
            for (TbSpecificationOption tbSpecificationOption : tbSpecificationOptions) {
                tbSpecificationOption.setSpecId(id);
                tbSpecificationOptionMapper.add(tbSpecificationOption);
            }
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("保存异常");
        }
        return Boolean.TRUE;
    }

    public Boolean delete(List<Integer> ids) {
        if (null == ids || ids.size() == 0) {
            throw new BusinessException("参数为空");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            tbSpecificationMapper.delete(ids);
            tbSpecificationOptionMapper.delete(ids);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("删除数据失败");
        }
        return Boolean.TRUE;
    }

    public SpecificationVO findOne(Integer id) {
        if (null == id || id == 0) {
            throw new BusinessException("id为空");
        }
        TbSpecification tbSpecification = tbSpecificationMapper.findOne(id);
        List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionMapper.findBySepcId(id);
        SpecificationVO vo = new SpecificationVO();
        vo.setSpecification(tbSpecification);
        vo.setSpecificationOptionList(tbSpecificationOptions);
        return vo;
    }

    public Boolean update(SpecificationVO specificationVO) {
        if (null == specificationVO) {
            throw new BusinessException("参数有误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            TbSpecification tbSpecification = specificationVO.getSpecification();
            tbSpecificationMapper.update(tbSpecification);
            Integer id = tbSpecification.getId();
            tbSpecificationOptionMapper.delete(Arrays.asList(id));
            List<TbSpecificationOption> tbSpecificationOptions = specificationVO.getSpecificationOptionList();
            for (TbSpecificationOption tbSpecificationOption : tbSpecificationOptions) {
                tbSpecificationOption.setSpecId(id);
                tbSpecificationOptionMapper.add(tbSpecificationOption);
            }
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("保存异常");
        }
        return Boolean.TRUE;
    }

    public List<SelectOptionVO> selectOptionList() {
        List<SelectOptionVO> listData = new ArrayList<>();

        SpecificationVO specificationVO = new SpecificationVO();
        List<TbSpecification> tbSpecifications = tbSpecificationMapper.search(specificationVO);
        if (null != tbSpecifications && tbSpecifications.size() > 0) {
            SelectOptionVO vo = null;
            for (TbSpecification tbSpecification : tbSpecifications) {
                vo = new SelectOptionVO();
                vo.setId(String.valueOf(tbSpecification.getId()));
                vo.setText(tbSpecification.getSpecName());
                listData.add(vo);
            }
        }
        return listData;
    }
}
