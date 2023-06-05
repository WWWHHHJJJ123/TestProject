package com.whj.stream.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;


/**
 * @创建人 JieSi
 * @创建时间 2023/5/3
 * @描述
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;

    private String name;

    private String category;

    private Integer score;

    private String intro;

}
