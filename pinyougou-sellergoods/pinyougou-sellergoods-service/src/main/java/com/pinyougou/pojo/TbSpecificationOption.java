package com.pinyougou.pojo;

import java.io.Serializable;

public class TbSpecificationOption implements Serializable {

    private static final long serialVersionUID = -9028101351135597691L;

    private Integer           id;

    private String            optionName;

    private Integer           specId;

    private Integer           orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName == null ? null : optionName.trim();
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}