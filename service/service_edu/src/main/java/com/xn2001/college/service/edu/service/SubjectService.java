package com.xn2001.college.service.edu.service;

import com.xn2001.college.service.edu.entity.Subject;
import com.xn2001.college.service.edu.entity.vo.SubjectVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
public interface SubjectService extends IService<Subject> {

    void batchImport(InputStream inputStream);

    List<SubjectVo> nestedList();
}
