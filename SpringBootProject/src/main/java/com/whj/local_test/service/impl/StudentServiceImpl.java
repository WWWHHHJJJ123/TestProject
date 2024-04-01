package com.whj.common_structures.service.impl;

import com.whj.common_structures.domain.entity.StudentEntity;
import com.whj.common_structures.dao.StudentDao;
import com.whj.common_structures.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whj
 * @since 2024-03-07 17:36:26
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements IStudentService {

}
