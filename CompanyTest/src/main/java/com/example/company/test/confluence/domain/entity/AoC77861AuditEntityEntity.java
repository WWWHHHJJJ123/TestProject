package com.example.company.test.confluence.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
 * @since 2024-08-30 11:45:59
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("ao_c77861_audit_entity")
@ApiModel(value = "AoC77861AuditEntityEntity对象", description = "")
public class AoC77861AuditEntityEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ACTION")
    private String action;

    @TableField("ACTION_T_KEY")
    private String actionTKey;

    @TableField("AREA")
    private String area;

    @TableField("ATTRIBUTES")
    private String attributes;

    @TableField("CATEGORY")
    private String category;

    @TableField("CATEGORY_T_KEY")
    private String categoryTKey;

    @TableField("CHANGE_VALUES")
    private String changeValues;

    @TableField("ENTITY_TIMESTAMP")
    private Long entityTimestamp;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("LEVEL")
    private String level;

    @TableField("METHOD")
    private String method;

    @TableField("NODE")
    private String node;

    @TableField("PRIMARY_RESOURCE_ID")
    private String primaryResourceId;

    @TableField("PRIMARY_RESOURCE_TYPE")
    private String primaryResourceType;

    @TableField("RESOURCES")
    private String resources;

    @TableField("RESOURCE_ID_3")
    private String resourceId3;

    @TableField("RESOURCE_ID_4")
    private String resourceId4;

    @TableField("RESOURCE_ID_5")
    private String resourceId5;

    @TableField("RESOURCE_TYPE_3")
    private String resourceType3;

    @TableField("RESOURCE_TYPE_4")
    private String resourceType4;

    @TableField("RESOURCE_TYPE_5")
    private String resourceType5;

    @TableField("SEARCH_STRING")
    private String searchString;

    @TableField("SECONDARY_RESOURCE_ID")
    private String secondaryResourceId;

    @TableField("SECONDARY_RESOURCE_TYPE")
    private String secondaryResourceType;

    @TableField("SOURCE")
    private String source;

    @TableField("SYSTEM_INFO")
    private String systemInfo;

    @TableField("USER_ID")
    private String userId;

    @TableField("USER_NAME")
    private String userName;

    @TableField("USER_TYPE")
    private String userType;


}
