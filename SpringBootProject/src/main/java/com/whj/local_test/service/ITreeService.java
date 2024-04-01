package com.whj.local_test.service;

import com.whj.local_test.domain.dto.TreePageDTO;
import com.whj.local_test.domain.entity.TreeEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whj
 * @since 2024-01-15 19:55:09
 */
public interface ITreeService extends IService<TreeEntity> {

    List<TreeEntity> list(TreePageDTO dto);

    void export(TreePageDTO dto, HttpServletResponse response);
}
