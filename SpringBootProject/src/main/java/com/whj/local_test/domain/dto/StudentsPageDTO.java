package com.whj.local_test.domain.dto;


import lombok.Data;

@Data
public class StudentsPageDTO {
    private Integer pageSize;
    private Integer pageNum;

    private String name;

    private String sex;

    private Integer age;
}
