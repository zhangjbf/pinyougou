package com.pinyougou.model.param;

import java.util.List;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/23
 */
public class ImportItemParam {

    private List<Integer> goodsIds;

    private String        status;

    public ImportItemParam(List<Integer> goodsIds, String status) {
        this.goodsIds = goodsIds;
        this.status = status;
    }

    public List<Integer> getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(List<Integer> goodsIds) {
        this.goodsIds = goodsIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
