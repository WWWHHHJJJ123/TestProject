package com.whj.local_test.service.impl;

import com.whj.local_test.domain.entity.PersonDO;
import com.whj.local_test.dao.PersonMapper;
import com.whj.local_test.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whj
 * @since 2024-10-11 16:59:59
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, PersonDO> implements PersonService {

}
