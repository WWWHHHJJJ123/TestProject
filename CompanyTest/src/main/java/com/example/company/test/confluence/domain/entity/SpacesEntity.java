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
 * @since 2024-08-29 19:07:01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("spaces")
@ApiModel(value = "SpacesEntity对象", description = "")
public class SpacesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SPACEID", type = IdType.ASSIGN_UUID)
    private Long spaceId;

    @TableField("SPACENAME")
    private String spaceName;

    @TableField("SPACEKEY")
    private String spaceKey;

    @TableField("LOWERSPACEKEY")
    private String lowerSpaceKey;

    @TableField("SPACEDESCID")
    private Long spaceDescId;

    @TableField("HOMEPAGE")
    private Long homePage;

    @TableField("CREATOR")
    private String creator;

    @TableField("CREATIONDATE")
    private LocalDateTime creationDate;

    @TableField("LASTMODIFIER")
    private String lastModifier;

    @TableField("LASTMODDATE")
    private LocalDateTime lastModdate;

    @TableField("SPACETYPE")
    private String spaceType;

    @TableField("SPACESTATUS")
    private String spaceStatus;


}
