package com.whj.array_test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author WHJ
 * @Date 2024/4/22 13:55
 * @Description: TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class PersonDto {

    private Integer id;

    private String name;

    private String address;

    private Integer age;
}
