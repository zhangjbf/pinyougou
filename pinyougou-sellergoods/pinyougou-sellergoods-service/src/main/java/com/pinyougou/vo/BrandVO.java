package com.pinyougou.vo;

import com.pinyougou.model.PageVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
public class BrandVO extends PageVO {

    private static final long serialVersionUID = -8212980583741975361L;
    /**
     * null
     */
    private Integer           id;

    /**
     * 品牌名称
     */
    private String            name;

    /**
     * 品牌首字母
     */
    private String            firstChar;

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
        this.name = name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

}
