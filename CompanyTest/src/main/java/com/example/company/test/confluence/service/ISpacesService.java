package com.example.company.test.confluence.service;

import com.example.company.test.confluence.domain.ao.SpacePermissionAO;
import com.example.company.test.confluence.domain.entity.SpacesEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whj
 * @since 2024-08-29 19:07:01
 */
public interface ISpacesService extends IService<SpacesEntity> {

    void toTarget(SpacePermissionAO ao);

    Boolean deleteLimit(String ldap);
}
