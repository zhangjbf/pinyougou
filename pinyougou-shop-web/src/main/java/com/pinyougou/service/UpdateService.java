package com.pinyougou.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.pinyougou.utils.FtpUtil;
import com.pinyougou.utils.IDUtils;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/11
 */
public class UpdateService {

    private static final String  IMAGE_BASE_URL      = "http://192.168.1.113:9999/images";

    private static final String  FILE_UPLOAD_PATH    = "/home/ftpuser/www/images";

    private static final String  FTP_SERVER_IP       = "192.168.1.113";

    private static final Integer FTP_SERVER_PORT     = 21;

    private static final String  FTP_SERVER_USERNAME = "ftpuser";

    private static final String  FTP_SERVER_PASSWORD = "123456a";

    public String uploadFile(MultipartFile uploadFile) {
        String result = null;
        try {
            // 上传文件功能实现
            // 判断文件是否为空
            if (uploadFile.isEmpty()) {
                return null;
            }
            // 上传文件以日期为单位分开存放，可以提高图片的查询速度
            String filePath = "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
                              + new SimpleDateFormat("MM").format(new Date()) + "/"
                              + new SimpleDateFormat("dd").format(new Date());

            // 取原始文件名
            String originalFilename = uploadFile.getOriginalFilename();
            // 新文件名
            String newFileName = IDUtils.genImageName() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 转存文件，上传到ftp服务器
            FtpUtil.uploadFile(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_SERVER_USERNAME, FTP_SERVER_PASSWORD,
                FILE_UPLOAD_PATH, filePath, newFileName, uploadFile.getInputStream());
            result = filePath + "/" + newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IMAGE_BASE_URL + result;
    }
}
