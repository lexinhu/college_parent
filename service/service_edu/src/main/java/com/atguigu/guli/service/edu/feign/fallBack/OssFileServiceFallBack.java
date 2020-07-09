package com.atguigu.guli.service.edu.feign.fallBack;

import com.atguigu.guli.common.base.result.R;
import com.atguigu.guli.service.edu.feign.OssFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 乐心湖
 * @date 2020/7/5 15:25
 **/
@Service
@Slf4j
public class OssFileServiceFallBack implements OssFileService {

    @Override
    public R removeFile(String url) {
        log.info("熔断保护");
        return R.error();
    }
}
