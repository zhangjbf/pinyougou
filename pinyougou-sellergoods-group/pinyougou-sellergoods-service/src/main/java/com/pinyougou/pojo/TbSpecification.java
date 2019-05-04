package com.pinyougou.pojo;

import java.io.Serializable;

public class TbSpecification implements Serializable {

    private static final long serialVersionUID = -8876878495767289122L;

    private Integer           id;

    private String            specName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }
}