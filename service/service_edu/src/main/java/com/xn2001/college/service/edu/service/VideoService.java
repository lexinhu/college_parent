package com.xn2001.college.service.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.netflix.client.ClientException;
import com.xn2001.college.service.edu.entity.Video;

import java.util.List;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
public interface VideoService extends IService<Video> {
    void removeMediaVideoById(String id);

    void removeVideoByIdList(List<String> videoIdList) throws ClientException, com.aliyuncs.exceptions.ClientException;

    void removeMediaVideoByChapterId(String chapterId);

    void removeMediaVideoByCourseId(String courseId);
}
