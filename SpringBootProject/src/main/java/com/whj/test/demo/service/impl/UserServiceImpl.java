package com.whj.test.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whj.test.demo.domain.vo.UserPageResultVO;
import com.whj.test.demo.domain.dto.UsrListParamDTO;
import com.whj.test.demo.domain.enity.UserEntity;
import com.whj.test.demo.domain.dto.UserPageParamDTO;
import com.whj.test.demo.mapper.UserMapper;
import com.whj.test.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @创建人 JieSi
 * @创建时间 2023/5/8
 * @描述
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询
     */
    public List<UserPageResultVO> selectUserList(UserPageParamDTO userPageParamVO) {

//        IPage page = new Page(userPageParamVO.getPageNum(), userPageParamVO.getPageSize());
//        userMapper.selectPage(page, Wrappers.<UserEntity>lambdaQuery()
//                .like(UserEntity::getName, userPageParamVO.getParam()));
        PageHelper.startPage(userPageParamVO.getPageNum(), userPageParamVO.getPageSize());
//        List<UserEntity> userList = userMapper.selectList(Wrappers.<UserEntity>lambdaQuery()
//                .like(UserEntity::getName, userPageParamVO.getParam()));
        List<UserEntity> userList = userMapper.selectList(null);
        PageInfo<UserEntity> userEntityPageInfo = new PageInfo<>(userList);
        List<UserEntity> userFilterList = userEntityPageInfo.getList();
        System.out.println("总数据:"+userEntityPageInfo.getList());
        System.out.println("分页总页数:"+userEntityPageInfo.getPages());
        System.out.println("分页页数:"+userEntityPageInfo.getPageNum());
        System.out.println("分页条数:"+userEntityPageInfo.getPageSize());
        System.out.println(":"+userEntityPageInfo.getNavigatePages());
        System.out.println(":"+userEntityPageInfo.getEndRow());


//        List<UserEntity> records = page.getRecords();
        List<UserPageResultVO> users = new ArrayList<>();

        if (!Objects.isNull(userFilterList)) {
            for (UserEntity user : userFilterList) {
                UserPageResultVO resultDTO = new UserPageResultVO();
                BeanUtils.copyProperties(user, resultDTO);
                users.add(resultDTO);
            }
        }
        return users;
    }

    @Override
    public int insertUser(UserEntity user) {

        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public List<UserEntity> getUserListContainParam(UsrListParamDTO usrListParamDTO) {

        List<UserEntity> userEntities = userMapper.selectList(Wrappers.<UserEntity>lambdaQuery()
                                                                .like(UserEntity::getName, usrListParamDTO.getParam()));
        return userEntities;
    }

    @Override
    public UserEntity getOne(Long id) {
        UserEntity userEntity = userMapper.selectOne(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getId, id));

        return userEntity;
    }

}
