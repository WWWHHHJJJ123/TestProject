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
 * @since 2024-09-04 12:00:23
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_mapping")
@ApiModel(value = "UserMappingEntity对象", description = "")
public class UserMappingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_key", type = IdType.ASSIGN_UUID)
    private String userKey;

    @TableField("username")
    private String username;

    @TableField("lower_username")
    private String lowerUsername;


}
