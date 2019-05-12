package com.pinyougou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.itf.ItemCatService;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.WebAppResult;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.vo.ItemCatVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Integer parentId) {
        if (null == parentId) {
            return new ArrayList<>();
        }
        ServiceResult<List<TbItemCat>> serviceResult = itemCatService.findByParentId(parentId);
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/add")
    public WebAppResult add(@RequestBody ItemCatVO vo) {
        if (null == vo) {
            return WebAppResult.build(false, "请求参数错误");
        }
        ServiceResult<Boolean> serviceResult = itemCatService.add(vo);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "保存错误");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/findOne")
    public TbItemCat findOne(Integer id) {
        if (null == id || 0 == id) {
            return new TbItemCat();
        }
        ServiceResult<TbItemCat> serviceResult = itemCatService.findOne(id);
        if (!serviceResult.getSuccess()) {
            return new TbItemCat();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/update")
    public WebAppResult update(@RequestBody ItemCatVO vo) {
        if (null == vo) {
            return WebAppResult.build(false, "请求参数错误");
        }
        ServiceResult<Boolean> serviceResult = itemCatService.update(vo);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "修改错误");
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
        ServiceResult<Boolean> serviceResult = itemCatService.delete(listData);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "删除错误");
        }
        return WebAppResult.ok();
    }

    @RequestMapping("/findAll")
    public List<TbItemCat> findAll() {
        ServiceResult<List<TbItemCat>> serviceResult = itemCatService.findAll();
        if (!serviceResult.getSuccess()) {
            return new ArrayList<>();
        }
        return serviceResult.getResult();
    }

}
