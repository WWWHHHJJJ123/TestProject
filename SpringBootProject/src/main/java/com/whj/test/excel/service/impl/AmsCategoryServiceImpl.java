package com.whj.test.excel.service.impl;

import com.whj.test.excel.domain.entity.AmsCategoryEntity;
import com.whj.test.excel.dao.AmsCategoryDao;
import com.whj.test.excel.service.IAmsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whj
 * @since 2023-11-30 16:18:22
 */
@Service
public class AmsCategoryServiceImpl extends ServiceImpl<AmsCategoryDao, AmsCategoryEntity> implements IAmsCategoryService {

    @Autowired
    private AmsCategoryDao categoryDao;
    @Override
    public void importExcel(MultipartFile file) {


    }
}
