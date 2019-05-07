package com.pinyougou.shop.controller;

import com.pinyougou.itf.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
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
}
