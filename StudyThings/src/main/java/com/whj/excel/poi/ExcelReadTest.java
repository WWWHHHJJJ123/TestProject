package com.whj.excel.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/3
 * @描述
 */
public class ExcelReadTest {


    String PATH="E:\\MyLearnProject\\";

    //03版本
    @Test
    public void testRead03 () throws Exception {
        //获取文件流
        FileInputStream stream = new FileInputStream(PATH+"StudyThings03.xls");


        //1.创建工作簿
        Workbook workbook = new HSSFWorkbook(stream);
        //2.创建一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        Cell cell1 = row.getCell(0);
        Cell cell2 = row.getCell(1);
        System.out.println(cell1.toString()+cell2.toString());
        stream.close();


    }
    //07版本
    @Test
    public void testRead07 () throws Exception {
        //获取文件流
        FileInputStream stream = new FileInputStream(PATH+"StudyThings03.xlsx");

        //1.创建工作簿
        Workbook workbook = new XSSFWorkbook(stream);
        //2.创建一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell1 = row.getCell(0);
        Cell cell2 = row.getCell(1);
        System.out.println(cell1.toString()+cell2.toString());
        stream.close();


    }
}
