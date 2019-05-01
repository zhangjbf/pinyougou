package com.pinyougou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pinyougou.itf.ItemService;
import com.pinyougou.pojo.TbItem;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/1
 */
@Controller
public class HelloController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/hello")
    @ResponseBody
    public List<TbItem> getMsg() {
        System.out.println("javaboy");
        List<TbItem> s = itemService.listItem();
        return s;
    }
}
