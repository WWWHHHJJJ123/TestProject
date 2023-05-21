package com.whj.test.token.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/21
 * @描述
 */
@TableName("jwt_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUser {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;
}
