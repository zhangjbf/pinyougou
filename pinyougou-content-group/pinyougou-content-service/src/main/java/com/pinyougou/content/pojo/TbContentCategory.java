package com.pinyougou.content.pojo;

import java.io.Serializable;

public class TbContentCategory implements Serializable {

    private static final long serialVersionUID = 6728780978775791938L;

    private Integer id;

    private String  name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}