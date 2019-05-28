package com.pinyougou.page.pojo;

import java.io.Serializable;

public class TbItemCat implements Serializable {

    private static final long serialVersionUID = 7770601096339890309L;

    private Integer           id;

    private Integer           parentId;

    private String            name;

    private Integer           typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}