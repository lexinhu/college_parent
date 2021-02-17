package com.xn2001.college.service.vod.controller.admin;

import com.xn2001.college.common.base.result.R;
import com.xn2001.college.common.base.result.ResultCodeEnum;
import com.xn2001.college.common.base.util.ExceptionUtils;
import com.xn2001.college.service.base.exception.CollegeException;
import com.xn2001.college.service.vod.service.VideoService;
import com.xn2001.college.service.vod.util.VodSignatureUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * @author 乐心湖
 * @date 2020/7/18 17:17
 **/
@Api(tags = "腾讯视频点播")
@RestController
@RequestMapping("/admin/vod/media")
@Slf4j
public class MediaController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private VodSignatureUtils vodSignatureUtils;

    @DeleteMapping("remove/{vodId}")
    public R removeVideo(
            @ApiParam(value = "腾讯云视频id", required = true)
            @PathVariable String vodId) {

        try {
            videoService.removeVideo(vodId);
            return R.ok().message("视频删除成功");
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new CollegeException(ResultCodeEnum.VIDEO_DELETE_TENCENT_ERROR);
        }
    }

    @DeleteMapping("remove")
    public R removeVideoByIdList(
            @ApiParam(value = "阿里云视频id列表", required = true)
            @RequestBody List<String> videoIdList) {

        try {
            videoService.removeVideoByIdList(videoIdList);
            return R.ok().message("视频删除成功");
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new CollegeException(ResultCodeEnum.VIDEO_DELETE_TENCENT_ERROR);
        }
    }

    @GetMapping("signature")
    public R getSignature() {
        vodSignatureUtils.setCurrentTime(System.currentTimeMillis() / 1000);
        vodSignatureUtils.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));
        vodSignatureUtils.setSignValidDuration(3600 * 24 / 2); // 签名有效期：半天
        try {
            String signature = vodSignatureUtils.getUploadSignature();
            System.out.println("signature : " + signature);
            return R.ok().data("signature",signature);
        } catch (Exception e) {
            System.out.print("获取签名失败");
            e.printStackTrace();
        }
        return R.error();
    }

}
