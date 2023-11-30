package com.whj;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.whj.domain.entity.UserEntity;
import com.whj.listener.UserInfoReadListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author JieSir
 * @Date 2023/7/30 10:11
 * @Version 1.0
 */

@Slf4j
public class easyexcelTest {

    @Test
    public void testFile() {
        File file = new File("E:\\TestProject\\EasyExcel\\src\\main\\resources\\FileTest.xlsx");
        List<Object> objects = EasyExcel.read(file).sheet(0).doReadSync();
        for (Object item : objects) {
            System.out.println("item:{}   " + item);
        }
    }

    @Test
    public void testInputStream() {
        InputStream inputStream = EasyExcel.class.getClassLoader().getResourceAsStream("FileTest.xlsx");
        List<Map<Integer, Object>> objects = EasyExcel.read(inputStream).sheet(0).doReadSync();
        for (Map<Integer, Object> item : objects) {
//            log.info("item:{}"+item);
            System.out.println("昵称：{}，性别{}，生日：{}，邮箱：{}，积分：{}" + item.get(0) + "," + item.get(1) + "," + item.get(2) + "," + item.get(3) + "," + item.get(4));
        }
    }

    @Test
    public void testInputStreamWithModel() {
        InputStream inputStream = EasyExcel.class.getClassLoader().getResourceAsStream("FileTest.xlsx");
        List<UserEntity> objects = EasyExcel.read(inputStream).head(UserEntity.class).headRowNumber(1).sheet(0).doReadSync();
        int i =1;
        for (UserEntity item : objects) {
//            log.info("item:{}"+item);
            if (item.getUserName().equals("666")){
                System.out.println("插入数据库的数据："+item+"        第"+i+"条数据");
            }else {
                System.out.println(item + ": 第" + i + "条");
            }

            i++;
        }
        System.out.println(objects.size());
    }

    @Test
    public void testReadListener() {
        InputStream inputStream = EasyExcel.class.getClassLoader().getResourceAsStream("FileTest.xlsx");
        UserInfoReadListener userInfoReadListener = new UserInfoReadListener();
//        List<UserEntity> objects = EasyExcel.read(inputStream).sheet(0).head(UserEntity.class).registerReadListener(userInfoReadListener).doReadSync();
        EasyExcel.read(inputStream, UserEntity.class, userInfoReadListener).headRowNumber(7).sheet(0).doRead();

    }

    @Test
    public void testIExport() {
        List<Object> list1 = Arrays.asList(1, 2, 3);
        List<Object> list2 = Arrays.asList("郭德纲", "于谦", "栾云平");
        List<List<Object>> list = Arrays.asList(list1, list2);
        EasyExcel.write("E:\\export.xlsx")
                .sheet("测试模版")
                .doWrite(list);
    }


}
