package com.pinyougou.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.dao.TbSpecificationOptionMapper;
import com.pinyougou.dao.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.transaction.TransactionSupport;
import com.pinyougou.vo.SpecVO;
import com.pinyougou.vo.TypeTemplateVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/3
 */
@Repository
public class TypeTemplateModel extends TransactionSupport {

    @Autowired
    private TbTypeTemplateMapper        tbTypeTemplateMapper;

    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    public PageResult<TbTypeTemplate> search(TypeTemplateVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数错误");
        }
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<TbTypeTemplate> tbTypeTemplateList = tbTypeTemplateMapper.search(vo);
        PageInfo<TbTypeTemplate> info = new PageInfo<>(tbTypeTemplateList);
        return new PageResult<>(info.getTotal(), info.getList());
    }

    public Boolean add(TypeTemplateVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数错误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            TbTypeTemplate tbTypeTemplate = new TbTypeTemplate();
            tbTypeTemplate.setBrandIds(JsonUtils.objectToJson(vo.getBrandIds()));
            tbTypeTemplate.setName(vo.getName());
            tbTypeTemplate.setCustomAttributeItems(JsonUtils.objectToJson(vo.getCustomAttributeItems()));
            tbTypeTemplate.setSpecIds(JsonUtils.objectToJson(vo.getSpecIds()));
            tbTypeTemplateMapper.add(tbTypeTemplate);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("系统异常");
        }
        return Boolean.TRUE;
    }

    public Boolean delete(List<Integer> listData) {
        if (null == listData || listData.size() == 0) {
            throw new BusinessException("请求参数为空");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            tbTypeTemplateMapper.delete(listData);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("删除失败");
        }
        return Boolean.TRUE;
    }

    public TbTypeTemplate findOne(Integer id) {
        if (null == id || id == 0) {
            throw new BusinessException("参数错误");
        }
        return tbTypeTemplateMapper.findOne(id);
    }

    public Boolean update(TypeTemplateVO vo) {
        if (null == vo) {
            throw new BusinessException("请求参数错误");
        }
        TransactionStatus status = this.createTransactionStatus(TransactionDefinition.PROPAGATION_REQUIRED);
        try {
            TbTypeTemplate tbTypeTemplate = new TbTypeTemplate();
            tbTypeTemplate.setId(vo.getId());
            tbTypeTemplate.setBrandIds(JsonUtils.objectToJson(vo.getBrandIds()));
            tbTypeTemplate.setName(vo.getName());
            tbTypeTemplate.setCustomAttributeItems(JsonUtils.objectToJson(vo.getCustomAttributeItems()));
            tbTypeTemplate.setSpecIds(JsonUtils.objectToJson(vo.getSpecIds()));
            tbTypeTemplateMapper.update(tbTypeTemplate);
            this.commitTransaction(status);
        } catch (Exception e) {
            this.rollbackTransaction(status);
            throw new BusinessException("系统异常");
        }
        return Boolean.TRUE;
    }

    public List<SpecVO> findBySpecList(Integer id) {
        if (null == id || id == 0) {
            throw new BusinessException("请求参数错误");
        }
        String specIds = tbTypeTemplateMapper.findBySpecList(id);
        List<SelectOptionVO> selectOptionVOS = JsonUtils.jsonToList(specIds, SelectOptionVO.class);
        if (null == selectOptionVOS || selectOptionVOS.size() == 0) {
            return new ArrayList<>();
        }
        List<SpecVO> listData = new ArrayList<>();
        for (SelectOptionVO selectOptionVO : selectOptionVOS) {
            SpecVO specVO = new SpecVO();
            specVO.setId(Integer.valueOf(selectOptionVO.getId()));
            specVO.setText(selectOptionVO.getText());

            List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionMapper
                .findBySepcId(Integer.valueOf(selectOptionVO.getId()));
            for (TbSpecificationOption tbSpecificationOption : tbSpecificationOptions) {
                specVO.addOption(tbSpecificationOption.getId(), tbSpecificationOption.getOptionName());
            }
        }
        return listData;
    }
}
