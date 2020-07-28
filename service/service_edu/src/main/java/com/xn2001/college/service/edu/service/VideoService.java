package com.xn2001.college.service.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xn2001.college.service.edu.entity.Video;

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
    void removeMediaVideoByChapterId(String chapterId);
    void removeMediaVideoByCourseId(String courseId);
}
