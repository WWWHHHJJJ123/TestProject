package com.whj.test.excel.service;

import com.whj.test.excel.domain.entity.AmsCategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whj
 * @since 2023-11-30 16:18:22
 */
public interface IAmsCategoryService extends IService<AmsCategoryEntity> {

    void importExcel(MultipartFile file) throws IOException;
}
