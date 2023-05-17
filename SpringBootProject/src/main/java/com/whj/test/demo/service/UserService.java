package com.whj.test.demo.service;

import com.whj.test.demo.domain.dto.UserPageResultVO;
import com.whj.test.demo.domain.vo.UserPageParamDTO;

import java.util.List;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/8
 * @描述
 */

public interface UserService {

    List<UserPageResultVO> selectUserList(UserPageParamDTO userPageParamVO);
}
