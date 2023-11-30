package com.whj.domain.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.whj.common.UserInfoGenderConverter;
import lombok.Data;

import java.util.Date;

/**
 * @Author JieSir
 * @Date 2023/7/30 10:30
 * @Version 1.0
 */

@Data
public class UserEntity {


    //昵称
    @ExcelProperty(value = {"昵称"})
    private String userName;

    //生日
    @ExcelProperty(value = {"生日"})
    private String userBirth;
    //邮箱
    @ExcelProperty(value = {"邮箱"})
    private String usrEmail;
    //积分
    @ExcelProperty(value = "积分")
    private Integer userScore;

    //性别
    @ExcelProperty(value = "性别")
    private Integer userGender;

}
