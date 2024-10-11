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
@TableName("content_perm_set")
@ApiModel(value = "ContentPermSetEntity对象", description = "")
public class ContentPermSetEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private Long id;

    @TableField("CONT_PERM_TYPE")
    private String contPermType;

    @TableField("CONTENT_ID")
    private Long contentId;

    @TableField("CREATIONDATE")
    private LocalDateTime creationdate;

    @TableField("LASTMODDATE")
    private LocalDateTime lastmoddate;


}
