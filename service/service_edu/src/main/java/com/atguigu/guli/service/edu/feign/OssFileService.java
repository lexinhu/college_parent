package com.atguigu.guli.service.edu.feign;

import com.atguigu.guli.common.base.result.R;
import com.atguigu.guli.service.edu.feign.fallBack.OssFileServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 乐心湖
 * @date 2020/7/3 23:38
 **/
@Component
@FeignClient(value = "service-oss",fallback = OssFileServiceFallBack.class)
public interface OssFileService {

    @DeleteMapping("/admin/oss/file/remove")
    R removeFile(@RequestBody String url);

}
