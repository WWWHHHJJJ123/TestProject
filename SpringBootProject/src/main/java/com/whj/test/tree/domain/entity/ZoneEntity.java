package com.whj.test.tree.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author WHJ
 * @Date 2024/5/8 14:06
 * @Description: TODO
 * @Version 1.0
 */
@Data
@TableName("zone")
public class ZoneEntity {
    @TableId
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("code")
    private String code;

    @TableField("parentId")
    private Integer parentId;
}
