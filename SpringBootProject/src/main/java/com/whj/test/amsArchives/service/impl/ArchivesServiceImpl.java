package com.whj.test.amsArchives.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whj.test.amsArchives.dao.AmsArchivesNewDao;
import com.whj.test.amsArchives.domain.entity.AmsArchivesNewEntity;
import com.whj.test.amsArchives.service.ArchivesService;
import org.springframework.stereotype.Service;

/**
 * @Author JieSir
 * @Date 2023/10/24 13:59
 * @Version 1.0
 */
@Service
public class ArchivesServiceImpl extends ServiceImpl<AmsArchivesNewDao, AmsArchivesNewEntity> implements ArchivesService {
}
