package com.xn2001.college.service.oss.service;

import java.io.InputStream;

/**
 * @author 乐心湖
 * @date 2020/6/30 22:34
 **/
public interface FileService {

    /**
     * 阿里云oss 文件上传
     * @param inputStream 输入流
     * @param module 文件夹
     * @param originalFilename 文件名
     * @return 文件上传后的地址
     */
    String upload(InputStream inputStream, String module, String originalFilename);


    /**
     * 阿里云oss 文件删除
     * @param url 文件的url地址
     */
    void removeFile(String url);
}
