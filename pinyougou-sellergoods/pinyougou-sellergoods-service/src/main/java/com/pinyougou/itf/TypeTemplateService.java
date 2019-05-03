package com.pinyougou.itf;

import java.util.List;

import com.pinyougou.model.PageResult;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.vo.TypeTemplateVO;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/3
 */
public interface TypeTemplateService {
    /**
     * 分页查询模板
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/3
     */
    ServiceResult<PageResult<TbTypeTemplate>> search(TypeTemplateVO vo);

    /**
     * 模板新增保存
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/3
     */
    ServiceResult<Boolean> add(TypeTemplateVO vo);

    /**
     * 模板删除
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/3
     */
    ServiceResult<Boolean> delete(List<Integer> listData);

    /**
     * 查询一条记录
     * 
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/3
     */
    ServiceResult<TbTypeTemplate> findOne(Integer id);

    /**
     * 模板更新
     *
     * @param
     * @return
     * @author jiabin.zhang 张佳宾
     * @date 2019/5/3
     */
    ServiceResult<Boolean> update(TypeTemplateVO vo);
}
