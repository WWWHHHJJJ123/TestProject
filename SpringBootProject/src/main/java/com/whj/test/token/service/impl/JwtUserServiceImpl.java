package com.whj.test.token.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.whj.test.token.domain.entity.JwtUser;
import com.whj.test.token.mapper.JwtUserMapper;
import com.whj.test.token.service.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Wrapper;
import java.util.Objects;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/21
 * @描述
 */
@Service
public class JwtUserServiceImpl implements JwtUserService {

    @Autowired
    private JwtUserMapper jwtUserMapper;


    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public JwtUser login(JwtUser jwtUser) {
        JwtUser user = jwtUserMapper.selectOne(Wrappers.<JwtUser>lambdaQuery()
                .eq(JwtUser::getName, jwtUser.getName())
                .eq(JwtUser::getPassword, jwtUser.getPassword()));
        if (!Objects.isNull(user)) {
            return user;
        }
        throw new RuntimeException("抱歉,登录失败~~~~~");

    }
}
