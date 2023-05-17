package com.whj.test.demo.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/8
 * @描述 user分页需要的参数
 */
@Data
public class UserPageParamDTO implements Serializable {

    private Integer pageNum = 1;

    private Integer pageSize = 2;

    private String param;
}
