package com.whj.feign;

import com.whj.common.AjaxResult;
import com.whj.domain.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/27
 * @描述
 */
@FeignClient(value = "user-service")
public interface TestFeign {

    @GetMapping("/info")
    public String info();
    @GetMapping("/getUser")
    public AjaxResult getUser();

    @GetMapping("/getUserOther")
    public AjaxResult<User> getUserOther();
}
