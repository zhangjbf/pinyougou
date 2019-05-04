package com.pinyougou.itf;

import java.util.List;

import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbItemCat;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
public interface ItemCatService {
    /**
     * 根据parentId查询分类列表
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/4
     */
    ServiceResult<List<TbItemCat>> findByParentId(Integer parentId);
}
