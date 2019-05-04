package com.pinyougou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.itf.SpecService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.SelectOptionVO;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.WebAppResult;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.vo.SpecificationVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
@RestController
@RequestMapping("/specification")
public class SpecController {

    @Autowired
    private SpecService specService;

    @RequestMapping("/search")
    public PageResult<TbSpecification> search(@RequestBody SpecificationVO specificationVO, Integer page,
                                              Integer rows) {
        specificationVO.setPage(page);
        specificationVO.setRows(rows);
        ServiceResult<PageResult<TbSpecification>> serviceResult = specService.search(specificationVO);
        if (!serviceResult.getSuccess()) {
            return new PageResult<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/add")
    public WebAppResult add(@RequestBody SpecificationVO specificationVO) {
        if (null == specificationVO) {
            return WebAppResult.build(false, "参数错误");
        }
        ServiceResult<Boolean> serviceResult = specService.add(specificationVO);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "保存错误");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/delete")
    public WebAppResult delete(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return WebAppResult.build(false, "请求参数错误");
        }
        String[] idArray = ids.split(",");
        if (null == idArray || idArray.length == 0) {
            return WebAppResult.build(false, "请求参数错误");
        }
        List<Integer> listData = new ArrayList<>();
        for (String idStr : idArray) {
            listData.add(Integer.valueOf(idStr));
        }
        ServiceResult<Boolean> serviceResult = specService.delete(listData);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "删除错误");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/findOne")
    public SpecificationVO findOne(Integer id) {
        if (null == id || id == 0) {
            return new SpecificationVO();
        }
        ServiceResult<SpecificationVO> serviceResult = specService.findOne(id);
        if (!serviceResult.getSuccess()) {
            return new SpecificationVO();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/update")
    public WebAppResult update(@RequestBody SpecificationVO specificationVO) {
        if (null == specificationVO) {
            return WebAppResult.build(false, "参数错误");
        }
        ServiceResult<Boolean> serviceResult = specService.update(specificationVO);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "修改异常");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/selectOptionList")
    @ResponseBody
    public List<SelectOptionVO> selectOptionList() {
        ServiceResult<List<SelectOptionVO>> serviceResult = specService.selectOptionList();
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }

}
