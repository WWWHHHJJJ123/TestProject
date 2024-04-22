package com.whj.array_test;

import cn.hutool.core.collection.ListUtil;
import com.whj.array_test.domain.PersonDto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * @Author WHJ
 * @Date 2024/4/22 13:55
 * @Description: TODO
 * @Version 1.0
 */
public class MapTest {
    //基础数据
    private static final List<PersonDto> personDtos = ListUtil.toList(
            new PersonDto(1, "张三", "西安", 22),
            new PersonDto(2, "李四1", "咸阳", 23),
            new PersonDto(2, "李四2", "咸阳", 23),
            new PersonDto(3, "王五1", "榆林", 24),
            new PersonDto(3, "王五2", "榆林", 24),
            new PersonDto(4, "赵六1", "宝鸡", 25),
            new PersonDto(4, "赵六2", "宝鸡", 25),
            new PersonDto(5, "孙七", "延安", 26)
    );

    /**
     * 如果Id重复取第一个元素
     */
    @Test
    public void test1() {
        //List转Map，id作为key，元素对象作为value，如果Id重复取第一个元素
        Map<Integer, PersonDto> collect1 = personDtos
                .stream()
                .collect(toMap(PersonDto::getId, o -> o, (value1, value2) -> value2));
        System.out.println("collect1 = " + collect1);

    }

    /**
     * 获取到以id为key,对象本身为value
     */
    @Test
    public void test2() {
        Map<Integer, Object> collect = personDtos
                .stream()
                .collect(toMap(PersonDto::getId, o->o,(v1,v2)->v2));
        System.out.println(collect);
    }
}
