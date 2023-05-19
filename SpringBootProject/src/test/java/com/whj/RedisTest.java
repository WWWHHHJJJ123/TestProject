package com.whj;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/18
 * @描述
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * redis操作string类型数据
     */
    @Test
    public void testString() {

        Object ksy1 = redisTemplate.opsForValue().get("key1");
        System.out.println(ksy1);

//        redisTemplate.opsForValue().set("string","Welcome to the lalalala");
        Object string = redisTemplate.opsForValue().get("string");
        System.out.println(string);


    }

    /**
     * 操作Hash类型数据
     */
    @Test
    public void testHash() {
        HashOperations hashOperations = redisTemplate.opsForHash();

        //存值
        hashOperations.put("002", "name", "zhangSan");
        hashOperations.put("002", "age", "20");
        hashOperations.put("002", "address", "bj");

        //取值
        String age = (String) hashOperations.get("002", "age");
        System.out.println(age);
        System.out.println("===============");
        //获得hash结构中的所有字段
        Set keys = hashOperations.keys("002");
        for (Object key : keys) {
            System.out.println("字段:"+key);
        }
        System.out.println("===============");
        //获得hash结构中的所有值
        List values = hashOperations.values("002");
        for (Object value : values) {
            System.out.println("字段值:"+value);
        }

        Object name = redisTemplate.boundHashOps("002").get("name");
        System.out.println(name);
        System.out.println("=============");


    }

    /**
     * 操作Set类型的数据
     */
    @Test
    public void testSet() {
        SetOperations setOperations = redisTemplate.opsForSet();

        /**
         * set类型的数据不可重复
         */
        setOperations.add("myset", "a", "b", "c", "a","a", "b", "c", "a","d","b","m","t");

        //取值
        Set<String> myset = setOperations.members("myset");
        for (String o : myset) {
            System.out.println(o);
        }
        System.out.println("=================");
//        //删除成员
//        setOperations.remove("myset","a","b");
        //取值
//        myset = setOperations.members("myset");
//        for (String o : myset) {
//            System.out.println("myset值:" + o);
//        }

    }

    /**
     * 操作ZSet类型的数据
     */
    @Test
    public void testZset() {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

        //存值
        zSetOperations.add("myZset", "a", 10.0);
        zSetOperations.add("myZset", "b", 11.0);
        zSetOperations.add("myZset", "c", 12.0);
        zSetOperations.add("myZset", "a", 13.0);

        //取值
        Set<String> myZset = zSetOperations.range("myZset", 0, -1);
        for (String s : myZset) {
            System.out.println("myZset:" + s);
        }

        //修改分数
        zSetOperations.incrementScore("myZset", "b", 20.0);

        //取值
        myZset = zSetOperations.range("myZset", 0, -1);
        for (String s : myZset) {
            System.out.println("myZset:" + s);
        }

        //删除成员
        zSetOperations.remove("myZset", "a", "b");

        //取值
        myZset = zSetOperations.range("myZset", 0, -1);
        for (String s : myZset) {
            System.out.println("myZset:" + s);
        }
    }
    /**
     * 通用操作，针对不同的数据类型都可以操作
     */
    @Test
    public void testCommon(){
        //获取Redis中所有的key
        Set<String> keys = redisTemplate.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }

        //判断某个key是否存在
        Boolean itcast = redisTemplate.hasKey("itcast");
        System.out.println(itcast);

        //删除指定key
        redisTemplate.delete("myZset");

        //获取指定key对应的value的数据类型
        DataType dataType = redisTemplate.type("myset");
        System.out.println(dataType.name());

    }


}
