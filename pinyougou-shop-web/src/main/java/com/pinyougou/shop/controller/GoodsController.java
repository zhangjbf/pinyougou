package com.pinyougou.shop.controller;

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
 * @CreateDate 2019/5/7
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
        if (null == serviceResult.getResult()) {
            return new PageResult<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/add")
    public WebAppResult add(@RequestBody GoodsVO vo) {
        if (null == vo) {
            return WebAppResult.build(false, "请求参数为空");
        }
        ServiceResult<Boolean> serviceResult = goodsService.add(vo);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "新增出错");
        }
        return WebAppResult.ok();

    }

    @RequestMapping("/findOne")
    public GoodsVO findOne(Integer id) {
        if (null == id || id == 0) {
            return new GoodsVO();
        }
        ServiceResult<GoodsVO> serviceResult = goodsService.findOne(id);
        if (!serviceResult.getSuccess()) {
            return new GoodsVO();
        }
        if (null == serviceResult.getResult()) {
            return new GoodsVO();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/delete")
    public WebAppResult delete(String ids) {
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
        ServiceResult<Boolean> serviceResult = goodsService.delete(listData);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "删除错误");
        }
        return WebAppResult.ok();
    }

}
