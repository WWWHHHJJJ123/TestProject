package com.whj.test.amsArchives.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 档案管理
 * </p>
 *
 * @author lzj
 * @since 2020-08-07
 */
@Getter
@Setter
@TableName("ams_archives_new")
@ApiModel(value = "AmsArchivesNewEntity", description = "档案管理")
public class AmsArchivesNewEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租户id，后台用户登录时为0")
    private Long tenantId;

    @ApiModelProperty("所属模块（1平台模块 2客户端模块）")
    private Integer type;

    @ApiModelProperty("行业分类id")
    private Long industryCategoryId;

    @ApiModelProperty("行业分类名称")
    private String industryCategoryName;

    @ApiModelProperty("序号")
    private String code;


    @ApiModelProperty("档案唯一code")
    private String modeCode;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("别名")
    private String alias;
    @ApiModelProperty("父id")
    private Long pid;

    @ApiModelProperty("层级")
    private Integer level;
//    @ApiModelProperty("特殊档案字段 0-普通档案 1-主销分组 2-商品号型 3-疵点配置 4-尺码组 5-物料分类 6-商品分类")
//    private Integer archivesSpecial ;
    @ApiModelProperty("是否启用")
    private Boolean useStatus;

    @ApiModelProperty("删除标志 0、未删除；1、已删除")
    private Boolean delFlag;

    @ApiModelProperty("创建者id")
    private Long createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改者id")
    private Long updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("系统时间")
    private LocalDateTime repTime;

}
