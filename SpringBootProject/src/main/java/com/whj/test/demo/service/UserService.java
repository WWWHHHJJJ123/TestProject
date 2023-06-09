package com.whj.test.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whj.test.demo.domain.vo.UserPageResultVO;
import com.whj.test.demo.domain.dto.UsrListParamDTO;
import com.whj.test.demo.domain.enity.UserEntity;
import com.whj.test.demo.domain.dto.UserPageParamDTO;

import java.util.List;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/8
 * @描述
 */

public interface UserService extends IService<UserEntity> {

    List<UserPageResultVO> selectUserList(UserPageParamDTO userPageParamVO);

    int insertUser(UserEntity user);

    List<UserEntity> getUserListContainParam(UsrListParamDTO usrListParamDTO);


    UserEntity getOneById(Long id);
}
