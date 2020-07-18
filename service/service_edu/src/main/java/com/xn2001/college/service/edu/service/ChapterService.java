package com.xn2001.college.service.edu.service;

import com.xn2001.college.service.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xn2001.college.service.edu.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
public interface ChapterService extends IService<Chapter> {

    boolean removeChapterById(String id);

    List<ChapterVo> nestedList(String courseId);
}
