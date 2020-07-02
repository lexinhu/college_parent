package com.atguigu.guli.service.oss.service;

import java.io.InputStream;

/**
 * @author 乐心湖
 * @date 2020/6/30 22:34
 **/
public interface FileService {

    /**
     * 文件上传至阿里云
     * @param inputStream 输入流
     * @param module 文件夹
     * @param originalFilename 文件名
     * @return 文件上传后的地址
     */
    String upload(InputStream inputStream, String module, String originalFilename);
}
