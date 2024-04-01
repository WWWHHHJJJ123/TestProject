package com.whj.local_test.domain.vo;

import com.whj.local_test.domain.entity.StudentEntity;
import lombok.Data;

import java.util.List;

@Data
public class StudentsPageVO {

    private Long total;

    private List<StudentEntity> studentsList;

}
