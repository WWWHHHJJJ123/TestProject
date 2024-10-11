package com.whj.local_test.dao;

import com.whj.local_test.domain.entity.PersonDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author whj
 * @since 2024-10-11 16:59:59
 */
@Mapper
public interface PersonMapper extends BaseMapper<PersonDO> {


    List<PersonDO> selectAll();
}
