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
 * @since 2024-09-04 11:55:46
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("content_perm")
@ApiModel(value = "ContentPermEntity对象", description = "")
public class ContentPermEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("CP_TYPE")
    private String cpType;

    @TableField("USERNAME")
    private String username;

    @TableField("GROUPNAME")
    private String groupname;

    @TableField("CPS_ID")
    private Long cpsId;

    @TableField("CREATOR")
    private String creator;

    @TableField("CREATIONDATE")
    private LocalDateTime creationdate;

    @TableField("LASTMODIFIER")
    private String lastmodifier;

    @TableField("LASTMODDATE")
    private LocalDateTime lastmoddate;


}
