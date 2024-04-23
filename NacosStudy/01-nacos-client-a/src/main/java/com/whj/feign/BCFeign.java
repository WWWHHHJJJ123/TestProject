package com.whj.feign;

import com.whj.common.Result;
import com.whj.domain.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/27
 * @描述
 */
@FeignClient(value = "user-service",fallbackFactory = BCFeign.class)
public interface BCFeign {

    @GetMapping("/info")
    public String info();
    @GetMapping("/getUser")
    public Result getUser();

    @GetMapping("/getUserOther")
    public Result<User> getUserOther();
}
