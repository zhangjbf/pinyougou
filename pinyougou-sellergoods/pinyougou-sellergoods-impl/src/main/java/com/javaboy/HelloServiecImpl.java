package com.javaboy;

import com.com.javaboy.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/1
 */
@Service("helloService")
public class HelloServiecImpl implements HelloService {

    @Override
    public String sayHello(Integer i) {
        return "hello";
    }
}
