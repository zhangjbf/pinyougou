package com.pinyougou.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/2
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/showName")
    public Map showName() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap();
        map.put("loginName", name);
        return map;
    }

}
