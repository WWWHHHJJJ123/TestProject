package com.whj.local_test.service.impl;

import com.whj.local_test.domain.entity.StudentEntity;
import com.whj.local_test.dao.StudentDao;
import com.whj.local_test.service.IStudentService;
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
