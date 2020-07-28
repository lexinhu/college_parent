package com.xn2001.college.service.cms.feign.impl;

import com.xn2001.college.common.base.result.R;
import com.xn2001.college.service.cms.feign.OssFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 乐心湖
 * @date 2020/7/28 17:33
 **/
@Service
@Slf4j
public class OssFileServiceFallBack implements OssFileService {

    @Override
    public R removeFile(String url) {
        log.info("熔断保护");
        return R.error().message("调用超时");
    }
}
