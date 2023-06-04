package com.whj.domian.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/29
 * @描述
 */
@Data
public class User {
    private String name;
    private Integer age;
    private LocalDate birthday;
}
