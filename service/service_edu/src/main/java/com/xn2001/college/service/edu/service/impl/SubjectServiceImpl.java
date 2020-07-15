package com.xn2001.college.service.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xn2001.college.service.edu.entity.Subject;
import com.xn2001.college.service.edu.entity.excel.ExcelSubjectData;
import com.xn2001.college.service.edu.entity.vo.SubjectVo;
import com.xn2001.college.service.edu.listener.ExcelSubjectDataListener;
import com.xn2001.college.service.edu.mapper.SubjectMapper;
import com.xn2001.college.service.edu.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void batchImport(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelSubjectData.class,new ExcelSubjectDataListener(baseMapper))
                .excelType(ExcelTypeEnum.XLS).sheet().doRead();
    }

    @Override
    public List<SubjectVo> nestedList() {
        return baseMapper.selectNestedList("0");
    }
}
