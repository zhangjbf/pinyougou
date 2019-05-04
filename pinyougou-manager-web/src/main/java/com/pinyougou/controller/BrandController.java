package com.pinyougou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.itf.BrandService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.SelectOptionVO;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.WebAppResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.vo.BrandVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/search")
    public PageResult<TbBrand> search(@RequestBody BrandVO brandVO, Integer page, Integer rows) {
        brandVO.setPage(page);
        brandVO.setRows(rows);
        ServiceResult<PageResult<TbBrand>> serviceResult = brandService.search(brandVO);
        if (!serviceResult.getSuccess()) {
            return new PageResult<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/save")
    public WebAppResult save(@RequestBody BrandVO brandVO) {
        if (null == brandVO) {
            return WebAppResult.build(false, "参数错误");
        }
        ServiceResult<Boolean> serviceResult = brandService.save(brandVO);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "保存失败");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/delete")
    public WebAppResult delete(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return WebAppResult.build(false, "请选中要删除的数据");
        }
        String[] idArray = ids.split(",");
        List<Integer> idList = new ArrayList<>();
        if (null != idArray && idArray.length > 0) {
            for (String idStr : idArray) {
                idList.add(Integer.valueOf(idStr));
            }
        }
        ServiceResult<Boolean> serviceResult = brandService.delete(idList);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "删除出错");
        }
        return WebAppResult.ok();

    }

    @RequestMapping("/findById")
    public TbBrand findById(Integer id) {
        ServiceResult<TbBrand> serviceResult = brandService.findById(id);
        if (!serviceResult.getSuccess()) {
            return null;
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/update")
    public WebAppResult update(@RequestBody BrandVO brandVO) {
        ServiceResult<Boolean> serviceResult = brandService.update(brandVO);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "修改出错");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/selectOptionList")
    @ResponseBody
    public List<SelectOptionVO> selectOptionList() {
        ServiceResult<List<SelectOptionVO>> serviceResult = brandService.selectOptionList();
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }

}
