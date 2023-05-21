package com.whj.test.token.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whj.test.token.domain.entity.JwtUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/21
 * @描述
 */
@Mapper
public interface JwtUserMapper extends BaseMapper<JwtUser> {
}
