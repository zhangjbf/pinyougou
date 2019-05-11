package com.pinyougou.model;

import java.io.Serializable;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/3
 */
public class SelectOptionVO implements Serializable {

    private static final long serialVersionUID = -6204289419089005402L;
    /**
     * id : 1
     * text : 联想
     */

    private String            id;

    private String            text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
