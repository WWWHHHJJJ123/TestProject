package com.whj.test.token.service;

import com.whj.test.token.domain.entity.JwtUser;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/21
 * @描述
 */
public interface JwtUserService {

    JwtUser login(JwtUser jwtUser);
}
