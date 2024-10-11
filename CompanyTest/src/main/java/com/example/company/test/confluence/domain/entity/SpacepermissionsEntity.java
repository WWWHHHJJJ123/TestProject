package com.example.company.test.confluence.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author whj
 * @since 2024-08-29 19:11:38
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("spacepermissions")
@ApiModel(value = "SpacepermissionsEntity对象", description = "")
public class SpacepermissionsEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "PERMID", type = IdType.AUTO)
    private Long permid;

    @TableField("SPACEID")
    private Long spaceid;

    @TableField("PERMTYPE")
    private String permtype;

    @TableField("PERMGROUPNAME")
    private String permgroupname;

    @TableField("PERMUSERNAME")
    private String permusername;

    @TableField("PERMALLUSERSSUBJECT")
    private String permalluserssubject;

    @TableField("CREATOR")
    private String creator;

    @TableField("CREATIONDATE")
    private LocalDateTime creationdate;

    @TableField("LASTMODIFIER")
    private String lastmodifier;

    @TableField("LASTMODDATE")
    private LocalDateTime lastmoddate;


}
