package com.xn2001.college.service.trade.feign.fallback;

import com.xn2001.college.common.base.result.R;
import com.xn2001.college.service.base.dto.CourseDto;
import com.xn2001.college.service.trade.feign.EduCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 乐心湖
 * @date 2020/8/4 12:29
 **/
@Service
@Slf4j
public class EduCourseServiceFallBack implements EduCourseService {
    @Override
    public CourseDto getCourseDtoById(String courseId) {
        log.info("熔断保护");
        return null;
    }

    @GetMapping("/api/edu/course/inner/update-buy-count/{id}")
    @Override
    public R updateBuyCountById(String id) {
        log.error("熔断器被执行");
        return R.error();
    }
}
