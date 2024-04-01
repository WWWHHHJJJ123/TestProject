package com.whj.common_structures.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author whj
 * @since 2024-01-15 19:55:09
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tree")
@ApiModel(value = "TreeEntity对象", description = "")
@Data
public class TreeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("parent_id")
    private Integer parentId;


}
