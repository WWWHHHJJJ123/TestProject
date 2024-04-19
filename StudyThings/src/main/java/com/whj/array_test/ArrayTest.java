package com.whj.array_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayTest {


    @Test
    public void main() {
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student("张三", Arrays.asList("语文", "数学", "英语")));
        studentList.add(new Student("李四", Arrays.asList("物理", "化学", "生物")));
        studentList.add(new Student("王五", Arrays.asList("地理", "历史", "政治")));

        List<String> collect = studentList.stream().flatMap(s -> s.getCourses().stream().map(c->s.getName()+"-"+c)).collect(Collectors.toList());
        System.out.println(collect);
    }
    @AllArgsConstructor
    @Data
    class Student{
        private String name;

        private List<String> courses;
    }
}
