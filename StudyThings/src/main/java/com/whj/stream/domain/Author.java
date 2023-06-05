package com.whj.stream.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



import java.util.List;
import java.util.Objects;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/3
 * @描述
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private Long id;

    private String name;

    private Integer age;


    private String intro;

    private List<Book> books;


}
