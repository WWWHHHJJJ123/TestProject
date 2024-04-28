package com.whj.stream;

import com.alibaba.fastjson2.JSONObject;
import com.whj.stream.domain.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author WHJ
 * @Date 2024/4/28 12:14
 * @Description: TODO
 * @Version 1.0
 */
public class StreamTest {

    /**
     * 获取数据源
     * @return
     */
    public static List<User> getUser(){
        List<User> userList = Arrays.asList(
                new User(1, "张三", 10),
                new User(2, "李四", 10),
                new User(3, "王五", 10),
                new User(3, "赵六", 10),
                new User(4, "马七", 10),
                new User(4, "羊八", 10),
                new User(5, "猴九", 10)
        );
        return userList;
    }

    //测试map去重
    @Test
    public void test1(){
        List<User> user = getUser();
        Map<Integer, String> collect = user.stream().collect(Collectors.toMap(User::getId, User::getName,(v1,v2)->v2));
        System.out.println(collect);
    }


}
