package com.xn2001.college.service.vod.service;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import java.io.InputStream;
import java.util.List;

/**
 * @author 乐心湖
 * @date 2020/7/18 17:13
 **/
public interface VideoService {

    void removeVideo(String videoId) throws TencentCloudSDKException;

    void removeVideoByIdList(List<String> videoIdList) ;
}
