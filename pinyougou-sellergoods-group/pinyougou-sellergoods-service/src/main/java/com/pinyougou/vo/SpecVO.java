package com.pinyougou.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/7
 */
public class SpecVO implements Serializable {

    private static final long serialVersionUID = 1842594842983640954L;

    private Integer           id;

    private String            text;

    private List<SpecOption>  options          = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addOption(Integer id, String name) {
        options.add(new SpecOption(id, name));
    }

    class SpecOption implements Serializable {

        private static final long serialVersionUID = 8184991558858496961L;

        private Integer           id;

        private String            optionName;

        public SpecOption(Integer id, String optionName) {
            this.id = id;
            this.optionName = optionName;
        }

        public String getOptionName() {
            return optionName;
        }

        public void setOptionName(String optionName) {
            this.optionName = optionName;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
