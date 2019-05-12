package com.pinyougou.content.vo;

import com.pinyougou.model.PageVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/12
 */
public class ContentCategoryVO extends PageVO {

    private static final long serialVersionUID = -5902742091735892188L;

    private Integer           id;

    private String            name;

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
