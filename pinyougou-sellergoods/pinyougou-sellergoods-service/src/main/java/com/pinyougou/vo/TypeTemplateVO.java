package com.pinyougou.vo;

import java.io.Serializable;
import java.util.List;

import com.pinyougou.model.PageVO;
import com.pinyougou.model.SelectOptionVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/3
 */
public class TypeTemplateVO extends PageVO {

    private static final long    serialVersionUID = -9033208758332859702L;

    private Integer              id;

    private String               name;

    private List<SelectOptionVO> brandIds;

    private List<SelectOptionVO> specIds;

    private List<AttributeItem>  customAttributeItems;

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

    public List<SelectOptionVO> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<SelectOptionVO> brandIds) {
        this.brandIds = brandIds;
    }

    public List<SelectOptionVO> getSpecIds() {
        return specIds;
    }

    public void setSpecIds(List<SelectOptionVO> specIds) {
        this.specIds = specIds;
    }

    public List<AttributeItem> getCustomAttributeItems() {
        return customAttributeItems;
    }

    public void setCustomAttributeItems(List<AttributeItem> customAttributeItems) {
        this.customAttributeItems = customAttributeItems;
    }

    class AttributeItem implements Serializable {

        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
