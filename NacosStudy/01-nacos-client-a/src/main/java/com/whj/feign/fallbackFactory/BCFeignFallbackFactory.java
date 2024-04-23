package com.whj.feign.fallbackFactory;


import com.whj.common.ErrorCode;
import com.whj.common.ErrorCodeException;
import com.whj.common.Result;
import com.whj.domain.entity.User;
import com.whj.feign.BCFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author WHJ
 * @Date 2024/4/23 15:51
 * @Description: TODO
 * @Version 1.0
 */
@Component
@Slf4j
public class BCFeignFallbackFactory implements FallbackFactory<BCFeign> {

    @Override
    public BCFeign create(Throwable cause) {
        log.error("异常原因:{}",cause.getMessage(),cause);
        return new BCFeign() {
            @Override
            public String info() {
               throw  new ErrorCodeException(ErrorCode.SYSTEM_ERROR);
            }

            @Override
            public Result getUser() {
                return null;
            }

            @Override
            public Result<User> getUserOther() {
                return null;
            }
        };
    }
}
