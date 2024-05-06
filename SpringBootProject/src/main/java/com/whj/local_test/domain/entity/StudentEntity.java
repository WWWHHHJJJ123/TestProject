package com.whj.local_test.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author whj
 * @since 2024-03-07 17:36:26
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("student")
@ApiModel(value = "StudentEntity对象", description = "")
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("sex")
    private String sex;

    @TableField("age")
    private Integer age;

    @TableField("time")
    private Date time;

}
