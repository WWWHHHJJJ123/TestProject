package com.whj.local_test.dao;

import com.whj.local_test.domain.entity.StudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author whj
 * @since 2024-03-07 17:36:26
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

}
