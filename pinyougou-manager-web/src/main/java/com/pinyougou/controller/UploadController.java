package com.pinyougou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pinyougou.model.WebAppResult;
import com.pinyougou.service.UploadService;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/13
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping("/uploadFile")
    public WebAppResult uploadFile(MultipartFile file) {
        try {
            String url = uploadService.uploadFile(file);
            return WebAppResult.build(true, url);
        } catch (Exception e) {
            return WebAppResult.build(false, e.getMessage());
        }
    }
}
