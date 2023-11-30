package com.whj.excel.easyexcle;

import com.alibaba.excel.EasyExcel;
import com.whj.excel.easyexcle.common.ExcelFillCellMergeStrategy;
import com.whj.excel.easyexcle.domain.DemoMergeData;
import com.whj.excel.easyexcle.domain.ZHDataVO;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/3
 * @描述
 */
public class TestAlibabaEasyExcel {
    String PATH = "E:\\t1.xlsx";
    //  设置文件名称


    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData demoData = new DemoData();
            demoData.setString("字符串" + i);
            demoData.setDate(new Date());
            demoData.setDoubleData(0.56);
            list.add(demoData);
        }
        return list;
    }

    //根据list写入值
    @Test
    public void simpleWrite() {

        String fileName = PATH + "EasyExcel.xls";
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());


    }

    //初始化数据
    public List<DemoMergeData> readyData() {
        List<DemoMergeData> resultList = new ArrayList<>();
        resultList.add(new DemoMergeData(1, "张胜男", "12"));
        resultList.add(new DemoMergeData(2, "李四", "224"));
        resultList.add(new DemoMergeData(3, "王五", "224"));
        resultList.add(new DemoMergeData(4, "赵柳", "224"));
        resultList.add(new DemoMergeData(5, "赵柳", "224"));
        resultList.add(new DemoMergeData(6, "赵柳", "224"));
        resultList.add(new DemoMergeData(7, "赵柳", "225"));
        resultList.add(new DemoMergeData(8, "赵柳", "225"));
        resultList.add(new DemoMergeData(9, "陈琪", "226"));
        resultList.add(new DemoMergeData(10, "小白", "226"));
        resultList.add(new DemoMergeData(11, "小黑", "226"));
        resultList.add(new DemoMergeData(12, "小黑", "227"));
        resultList.add(new DemoMergeData(13, "小黑", "224"));
        resultList.add(new DemoMergeData(14, "小黑", "228"));
        resultList.add(new DemoMergeData(15, "小黑", "228"));

        return resultList;

    }

    //测试导出
    @Test
    public void testWrite1() throws IOException {

        //  设置文件名称
        String fileName = "E:\\t1.xlsx";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        //  sheet名称
        EasyExcel.write(fileName, DemoMergeData.class)
                .autoCloseStream(Boolean.TRUE)
                .sheet("测试导出").doWrite(this.readyData());
    }

    //加策略的导出
    @Test
    public void testWrite2() throws IOException, ClassNotFoundException {

        int mergeRowIndex = 1;
        // 数据就不初始化了
        List<DemoMergeData> resultList = new ArrayList<>();
        // 设置文件名称
        String fileName = "E:\\t1.xlsx";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        // 需要从第几行开始合并
        List<Integer> mergeColumnIndex = new ArrayList<>();
        Field[] declaredFields = Class.forName("com.whj.excel.easyexcle.domain.DemoMergeData").getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            if (declaredFields[i].getName().equals("sub") || declaredFields[i].getName().equals("date")) {
                mergeColumnIndex.add(i);
            }
        }

        //  sheet名称
        EasyExcel.write(fileName, DemoMergeData.class)
                .autoCloseStream(Boolean.TRUE)
                .registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumnIndex))
                .sheet("测试导出").doWrite(this.readyData());
    }


    @Test
    public void testZh() throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\asus\\Desktop\\紫涵2.0档案字段+预定义.xlsx");
        List<ZHDataVO> objects = EasyExcel.read(fis, ZHDataVO.class, null).headRowNumber(1).sheet("成衣分类").doReadSync();
        System.out.println(objects);
    }
}
