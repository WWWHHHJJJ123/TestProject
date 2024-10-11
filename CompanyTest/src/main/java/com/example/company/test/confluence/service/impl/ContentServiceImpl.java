package com.example.company.test.confluence.service.impl;

import com.example.company.test.confluence.domain.entity.ContentEntity;
import com.example.company.test.confluence.dao.ContentDao;
import com.example.company.test.confluence.service.IContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whj
 * @since 2024-09-04 11:55:46
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentDao, ContentEntity> implements IContentService {

}
