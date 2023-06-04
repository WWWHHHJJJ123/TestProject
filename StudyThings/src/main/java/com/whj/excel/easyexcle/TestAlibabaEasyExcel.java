package com.whj.excel.easyexcle;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/3
 * @描述
 */
public class TestAlibabaEasyExcel {
    String PATH = "E:\\MyLearnProject\\StudyThings";


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
}
