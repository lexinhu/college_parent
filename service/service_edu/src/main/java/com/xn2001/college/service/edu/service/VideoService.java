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
    //根据标识删除视频
    void removeMediaVideoById(String id);
    //删除章节视频
    void removeMediaVideoByChapterId(String chapterId);
    //删除课程视频
    void removeMediaVideoByCourseId(String courseId);
}
