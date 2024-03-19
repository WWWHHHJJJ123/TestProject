package com.whj.common_structures.domain.vo;

import com.whj.common_structures.domain.entity.StudentEntity;
import lombok.Data;

import java.util.List;

@Data
public class StudentsPageVO {

    private Long total;

    private List<StudentEntity> studentsList;

}
