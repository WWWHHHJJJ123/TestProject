package com.whj.excel.poi;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/3
 * @描述
 */
public class ExcelWriteTest {

    String PATH="E:\\MyLearnProject\\StudyThings";

    //03版本
    @Test
    public void testWrite03 () throws Exception {
        //1.创建工作簿
        Workbook workbook = new HSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("无敌大企业1");
        //3.创建一行
        Row row1 = sheet.createRow(0);
        //4.创建一个单元格   第一行
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("企业部门1");
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("企业部门2");

        //第二行
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");

        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(LocalDate.now().toString());


        //生成一张表
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "03.xls");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        System.out.println("Excel生成成功");
    }
    //07版本
    @Test
    public void testWrite07 () throws Exception {
        //1.创建工作簿
        Workbook workbook = new XSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("无敌大企业1");
        //3.创建一行
        Row row1 = sheet.createRow(0);
        //4.创建一个单元格   第一行
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("企业部门1");
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue("企业部门2");

        //第二行
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");

        Cell cell22 = row2.createCell(1);
        cell22.setCellValue(LocalDate.now().toString());


        //生成一张表
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "03.xlsx");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        System.out.println("Excel生成成功");
    }
    @Test
    public void testWrite03BigData() throws Exception {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook=new HSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNum =0; rowNum <65536 ; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum <10 ; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }

        System.out.println("OVER");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"testWrite03BigData.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
    @Test
    public void testWrite07BigData() throws Exception {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook=new XSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNum =0; rowNum <100000 ; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum <10 ; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }

        System.out.println("OVER");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"testWrite07BigData.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
    @Test
    public void testWrite07BigDataS() throws Exception {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook=new SXSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNum =0; rowNum <100000 ; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum <10 ; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }

        System.out.println("OVER");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"testWrite07BigDataS.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        //清除临时文件!
        ((SXSSFWorkbook)workbook).dispose();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
}
