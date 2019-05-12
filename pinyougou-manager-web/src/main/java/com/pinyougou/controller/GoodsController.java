package com.pinyougou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.itf.GoodsService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.WebAppResult;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.vo.GoodsVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/search")
    public PageResult<TbGoods> search(@RequestBody GoodsVO vo, Integer page, Integer rows) {
        vo.setPage(page);
        vo.setRows(rows);
        ServiceResult<PageResult<TbGoods>> serviceResult = goodsService.search(vo);
        if (!serviceResult.getSuccess()) {
            return new PageResult<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/updateStatus")
    public WebAppResult updateStatus(String ids, String status) {
        if (StringUtils.isEmpty(ids)) {
            return WebAppResult.build(false, "参数错误");
        }
        String[] idArray = ids.split(",");
        if (null == idArray || idArray.length == 0) {
            return WebAppResult.build(false, "参数错误");
        }
        List<Integer> listData = new ArrayList<>();
        for (String idStr : idArray) {
            listData.add(Integer.valueOf(idStr));
        }
        ServiceResult<Boolean> serviceResult = goodsService.updateStatus(listData, status);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "更新状态出错");
        }
        return WebAppResult.ok();
    }

}
