package com.xn2001.college.service.edu.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xn2001.college.common.base.result.R;
import com.xn2001.college.service.edu.entity.form.CourseInfoForm;
import com.xn2001.college.service.edu.entity.vo.CourseQueryVo;
import com.xn2001.college.service.edu.entity.vo.CourseVo;
import com.xn2001.college.service.edu.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author 乐心湖
 * @since 2020-06-23
 */
@Api(tags = "课程管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/edu/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation("新增课程")
    @PostMapping("save-course-info")
    public R saveCourseInfo(
            @ApiParam(value = "课程基本信息", required = true)
            @RequestBody CourseInfoForm courseInfoForm
    ) {
        String courseId = courseService.saveCourseInfo(courseInfoForm);
        return R.ok().data("courseId", courseId).message("保存成功");
    }

    @ApiOperation("根据ID查询课程")
    @GetMapping("course-info/{id}")
    public R getById(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable String id) {

        CourseInfoForm courseInfoForm = courseService.getCourseInfoById(id);
        if (courseInfoForm != null) {
            return R.ok().data("item", courseInfoForm);
        } else {
            return R.ok().message("数据不存在");
        }
    }

    @ApiOperation("更新课程")
    @PutMapping("update-course-info")
    public R updateCourseInfoById(
            @ApiParam(value = "课程基本信息", required = true)
            @RequestBody CourseInfoForm courseInfoForm) {

        courseService.updateCourseInfoById(courseInfoForm);
        return R.ok().message("修改成功");
    }

    @ApiOperation("分页课程列表")
    @GetMapping("list/{page}/{limit}")
    public R index(@ApiParam(value = "当前页码", required = true)
                   @PathVariable Long page,

                   @ApiParam(value = "每页记录数", required = true)
                   @PathVariable Long limit,

                   @ApiParam(value = "查询对象") CourseQueryVo courseQueryVo)
    {
        IPage<CourseVo> courseVoIPage = courseService.selectPage(page, limit, courseQueryVo);
        List<CourseVo> records = courseVoIPage.getRecords();
        long total = courseVoIPage.getTotal();
        return R.ok().data("total", total).data("rows",records);
    }


    @ApiOperation("根据ID删除课程")
    @DeleteMapping("remove/{id}")
    public R removeById(
            @ApiParam(value = "课程ID", required = true)
            @PathVariable String id){

        //TODO 删除视频：VOD
        //在此处调用vod中的删除视频文件的接口

        //删除封面：OSS
        courseService.removeCoverById(id);

        //删除课程
        boolean result = courseService.removeCourseById(id);
        if (result) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("数据不存在");
        }
    }
}

