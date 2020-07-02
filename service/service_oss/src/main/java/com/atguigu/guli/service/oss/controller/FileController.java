package com.atguigu.guli.service.oss.controller;

import com.atguigu.guli.common.base.result.R;
import com.atguigu.guli.common.base.result.ResultCodeEnum;
import com.atguigu.guli.service.base.exception.GuliException;
import com.atguigu.guli.service.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author 乐心湖
 * @date 2020/6/30 23:10
 **/
@Api(tags = "阿里云文件管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/oss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     *
     * @param file
     */
    @ApiOperation("文件上传")
    @PostMapping("upload")
    public R upload(
            @ApiParam(value = "文件", required = true) @RequestParam("file") MultipartFile file,
            @ApiParam(value = "模块", required = true) @RequestParam("module") String module)  {
        try {
            InputStream inputStream = file.getInputStream();
            //获取上传文件的原文件名
            String originalFilename = file.getOriginalFilename();
            String uploadUrl = fileService.upload(inputStream, module, originalFilename);
            //返回
            return R.ok().message("文件上传成功").data("url", uploadUrl);
        } catch (Exception e) {
            throw new GuliException(ResultCodeEnum.FILE_UPLOAD_ERROR);
        }
    }
}
