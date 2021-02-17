package com.xn2001.college.service.vod.controller.api;

import com.xn2001.college.common.base.result.R;
import com.xn2001.college.common.base.result.ResultCodeEnum;
import com.xn2001.college.common.base.util.ExceptionUtils;
import com.xn2001.college.service.base.exception.CollegeException;
import com.xn2001.college.service.vod.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 乐心湖
 * @date 2020/7/28 13:21
 **/
@Api(tags = "腾讯云视频点播")
@RestController
@RequestMapping("/api/vod/media")
@Slf4j
public class ApiMediaController {

    @Autowired
    private VideoService videoService;

}
