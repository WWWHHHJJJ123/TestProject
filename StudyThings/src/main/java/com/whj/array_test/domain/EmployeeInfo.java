package com.whj.array_test.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author CiZhong
 * @date 2024-11-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo implements Serializable {
//
//    @ApiModelProperty("主键")
//    private Long id;
//
//    @ApiModelProperty("员工工号")
//    private String empNo;

    @ApiModelProperty("员工花名")
    private String empLdap;
//
//    @ApiModelProperty("员工花名")
//    private String empName;
//
//    @ApiModelProperty("邮箱地址")
//    private String email;
//
//    @ApiModelProperty("所属岗位")
//    private Integer post;
//
//    @ApiModelProperty("所属岗位名称")
//    private String postName;
//
//    @ApiModelProperty("所属部门")
//    private String department;
//
//    @ApiModelProperty("所属部门名称")
//    private String departmentName;
//
//    @ApiModelProperty("激活状态")
//    private Boolean activeState;
//
//    @ApiModelProperty("失效日期")
//    private LocalDateTime invalidDate;
//
//    @ApiModelProperty("在职还是离职  0-离职 1-在职")
//    private Boolean status;
//
//    @ApiModelProperty("0-内部 1-外部")
//    private Boolean classify;
//
//    @ApiModelProperty("权限应用id")
//    private Long manageId;
//
//    @ApiModelProperty("权限名")
//    private String manageName;

}
