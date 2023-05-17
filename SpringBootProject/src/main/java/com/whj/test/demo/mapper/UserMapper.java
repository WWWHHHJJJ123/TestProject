package com.whj.test.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whj.test.demo.domain.enity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/8
 * @描述
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
