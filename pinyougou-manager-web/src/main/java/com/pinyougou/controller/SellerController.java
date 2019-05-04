package com.pinyougou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinyougou.itf.SellerService;
import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.model.WebAppResult;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.vo.SellerVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping("/search")
    public PageResult<TbSeller> search(@RequestBody SellerVO vo, Integer page, Integer rows) {
        if (null == vo) {
            return new PageResult<>();
        }
        vo.setPage(page);
        vo.setRows(rows);

        ServiceResult<PageResult<TbSeller>> serviceResult = sellerService.search(vo);
        if (!serviceResult.getSuccess()) {
            return new PageResult<>();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/findOne")
    public TbSeller findOne(String id) {
        if (StringUtils.isEmpty(id)) {
            return new TbSeller();
        }
        ServiceResult<TbSeller> serviceResult = sellerService.findOne(id);
        if (!serviceResult.getSuccess()) {
            return new TbSeller();
        }
        return serviceResult.getResult();
    }

    @RequestMapping("/updateStatus")
    public WebAppResult updateStatus(String sellerId, String status) {
        if (StringUtils.isEmpty(sellerId) || StringUtils.isEmpty(status)) {
            return WebAppResult.build(false, "参数错误");
        }
        ServiceResult<Boolean> serviceResult = sellerService.updataStatus(sellerId, status);
        if (!serviceResult.getSuccess()) {
            return WebAppResult.build(false, serviceResult.getMessage());
        }
        if (!serviceResult.getResult()) {
            return WebAppResult.build(false, "商家审核失败");
        }
        return WebAppResult.ok();
    }

}
