package com.whj.excel.poi;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.RegionUtil;
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

    String PATH = "E:\\";

    //03版本
    @Test
    public void testWrite03() throws Exception {
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
    public void testWrite07() throws Exception {
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

    //测试紫涵excel表格画出
    @Test
    public void testExcel() throws Exception {
        //1.创建工作簿
        Workbook workbook = new XSSFWorkbook();
        //2.创建一个工作表
        Sheet sheet = workbook.createSheet("测试");


        //第一行
        Row row0 = sheet.createRow(0);
        row0.setHeight((short) (25 * 20));
        Cell cell1 = row0.createCell(0);
        cell1.setCellValue("加工费核算");
        CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 11);
        sheet.addMergedRegion(region1);
        setRegionUtil(sheet,region1);
        //设置单元格内容水平垂直居中
        CellUtil.setAlignment(cell1, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell1, VerticalAlignment.CENTER);


        //第2行第1格

        CellRangeAddress region2 = new CellRangeAddress(1, 1, 0, 5);
        sheet.addMergedRegion(region2);
        Row row1 = sheet.createRow(1);
        Cell cell21 = row1.createCell(0);
        setRegionUtil(sheet,region2);
        cell21.setCellValue("加工费:");
        //设置单元格内容水平垂直居中
        CellUtil.setAlignment(cell21, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell21, VerticalAlignment.CENTER);
        //第2行第2格
        Cell cell22 = row1.createCell(6);
        cell22.setCellValue("加工费值");
        region2.setFirstRow(1);
        region2.setLastRow(1);
        region2.setFirstColumn(6);
        region2.setLastColumn(11);
        sheet.addMergedRegion(region2);
        setRegionUtil(sheet,region2);
        //设置单元格内容水平垂直居中
        CellUtil.setAlignment(cell22, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell22, VerticalAlignment.CENTER);

        //设置第三行

        CellRangeAddress region3 = new CellRangeAddress(2, 2, 0, 11);
        sheet.addMergedRegion(region3);
        setRegionUtil(sheet,region3);
        //设置第四行
        Row row3 = sheet.createRow(3);
        Cell cell31 = row3.createCell(0);
        cell31.setCellValue("品质系数：");
        CellRangeAddress region31 = new CellRangeAddress(3, 3, 0, 4);
        setRegionUtil(sheet,region31);
        sheet.addMergedRegion(region31);

        CellUtil.setAlignment(cell31, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell31, VerticalAlignment.CENTER);

        Cell cell32 = row3.createCell(5);
        cell32.setCellValue(1);
        CellRangeAddress region32 = new CellRangeAddress(3, 3, 5, 7);
        setRegionUtil(sheet,region32);
        sheet.addMergedRegion(region32);
        CellUtil.setAlignment(cell32, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell32, VerticalAlignment.CENTER);

        Cell cell33 = row3.createCell(8);
        cell33.setCellValue("-");
        CellRangeAddress region33 = new CellRangeAddress(3, 3, 8, 11);
        setRegionUtil(sheet,region33);
        sheet.addMergedRegion(region33);
        CellUtil.setAlignment(cell33, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell33, VerticalAlignment.CENTER);

        //设置第五行空行
        CellRangeAddress region4 = new CellRangeAddress(4, 4, 0, 11);
        sheet.addMergedRegion(region4);
        setRegionUtil(sheet,region4);

        //设置第六行
        Row row5 = sheet.createRow(5);
        Cell cell51 = row5.createCell(0);
        cell51.setCellValue("款号:");
        CellRangeAddress region51 = new CellRangeAddress(5, 5, 0, 1);
        setRegionUtil(sheet,region51);
        sheet.addMergedRegion(region51);
        CellUtil.setAlignment(cell51, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell51, VerticalAlignment.CENTER);

        Cell cell52 = row5.createCell(2);
        cell52.setCellValue("款号值");
        CellRangeAddress region52 = new CellRangeAddress(5, 5, 2, 3);
        setRegionUtil(sheet,region52);
        sheet.addMergedRegion(region52);
        CellUtil.setAlignment(cell52, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell52, VerticalAlignment.CENTER);

        Cell cell53 = row5.createCell(4);
        cell53.setCellValue("品牌:");
        CellRangeAddress region53 = new CellRangeAddress(5, 5, 4, 5);
        setRegionUtil(sheet,region53);
        sheet.addMergedRegion(region53);
        CellUtil.setAlignment(cell53, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell53, VerticalAlignment.CENTER);

        Cell cell54 = row5.createCell(6);
        cell54.setCellValue("品牌值");
        CellRangeAddress region54 = new CellRangeAddress(5, 5, 6, 7);
        setRegionUtil(sheet,region54);
        sheet.addMergedRegion(region54);
        CellUtil.setAlignment(cell54, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell54, VerticalAlignment.CENTER);

        Cell cell55 = row5.createCell(8);
        cell55.setCellValue("品名:");
        CellRangeAddress region55 = new CellRangeAddress(5, 5, 8, 9);
        setRegionUtil(sheet,region55);
        sheet.addMergedRegion(region55);
        CellUtil.setAlignment(cell55, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell55, VerticalAlignment.CENTER);

        Cell cell56 = row5.createCell(10);
        cell56.setCellValue("品名值");
        CellRangeAddress region56 = new CellRangeAddress(5, 5, 10, 11);
        setRegionUtil(sheet,region56);
        sheet.addMergedRegion(region56);
        CellUtil.setAlignment(cell56, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell56, VerticalAlignment.CENTER);

        //设置第七行
        Row row6 = sheet.createRow(6);

        Cell cell61 = row6.createCell(0);
        cell61.setCellValue("核算申请人:");
        CellRangeAddress region61 = new CellRangeAddress(6, 6, 0, 1);
        setRegionUtil(sheet,region61);
        sheet.addMergedRegion(region61);
        CellUtil.setAlignment(cell61, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell61, VerticalAlignment.CENTER);

        Cell cell62 = row6.createCell(2);
        cell62.setCellValue("核算申请人值");
        CellRangeAddress region62 = new CellRangeAddress(6, 6, 2, 5);
        setRegionUtil(sheet,region62);
        sheet.addMergedRegion(region62);
        CellUtil.setAlignment(cell62, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell62, VerticalAlignment.CENTER);

        Cell cell63 = row6.createCell(6);
        cell63.setCellValue("核算申请时间:");
        CellRangeAddress region63 = new CellRangeAddress(6, 6, 6, 7);
        setRegionUtil(sheet,region63);
        sheet.addMergedRegion(region63);
        CellUtil.setAlignment(cell63, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell63, VerticalAlignment.CENTER);

        Cell cell64 = row6.createCell(8);
        cell64.setCellValue("核算申请时间值");
        CellRangeAddress region64 = new CellRangeAddress(6, 6, 8, 11);
        setRegionUtil(sheet,region64);
        sheet.addMergedRegion(region64);
        CellUtil.setAlignment(cell64, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell64, VerticalAlignment.CENTER);

        //设置第八行
        Row row7 = sheet.createRow(7);

        Cell cell71 = row7.createCell(0);
        cell71.setCellValue("订货会加工费:");
        CellRangeAddress region71 = new CellRangeAddress(7, 7, 0, 1);
        setRegionUtil(sheet,region71);
        sheet.addMergedRegion(region71);
        CellUtil.setAlignment(cell71, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell71, VerticalAlignment.CENTER);

        Cell cell72 = row7.createCell(2);
        cell72.setCellValue("订货会加工费值");
        CellRangeAddress region72 = new CellRangeAddress(7, 7, 2, 3);
        setRegionUtil(sheet,region72);
        sheet.addMergedRegion(region72);
        CellUtil.setAlignment(cell72, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell72, VerticalAlignment.CENTER);

        Cell cell73 = row7.createCell(4);
        cell73.setCellValue("系数标准价:");
        CellRangeAddress region73 = new CellRangeAddress(7, 7, 4, 5);
        setRegionUtil(sheet,region73);
        sheet.addMergedRegion(region73);
        CellUtil.setAlignment(cell73, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell73, VerticalAlignment.CENTER);

        Cell cell74 = row7.createCell(6);
        cell74.setCellValue("-");
        CellRangeAddress region74 = new CellRangeAddress(7, 7, 6, 11);
        setRegionUtil(sheet,region74);
        sheet.addMergedRegion(region74);
        CellUtil.setAlignment(cell74, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell74, VerticalAlignment.CENTER);


        //设置第九行
        Row row8 = sheet.createRow(8);

        Cell cell81 = row8.createCell(0);
        cell81.setCellValue("配饰:");
        CellRangeAddress region81 = new CellRangeAddress(8, 8, 0, 1);
        setRegionUtil(sheet,region81);
        sheet.addMergedRegion(region81);
        CellUtil.setAlignment(cell81, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell81, VerticalAlignment.CENTER);

        Cell cell82 = row8.createCell(2);
        cell82.setCellValue("-");
        CellRangeAddress region82 = new CellRangeAddress(8, 8, 2, 11);
        setRegionUtil(sheet,region82);
        sheet.addMergedRegion(region82);
        CellUtil.setAlignment(cell82, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell82, VerticalAlignment.CENTER);

        //设置第十行
        Row row9 = sheet.createRow(9);
        row9.setHeight((short) (250 * 20));

        Cell cell91 = row9.createCell(0);
        cell91.setCellValue("款式图前片:");
        CellRangeAddress region91 = new CellRangeAddress(9, 9, 0, 1);
        setRegionUtil(sheet,region91);
        sheet.addMergedRegion(region91);
        CellUtil.setAlignment(cell91, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell91, VerticalAlignment.CENTER);

        Cell cell92 = row9.createCell(2);
        cell92.setCellValue("款式图前片值");
        CellRangeAddress region92 = new CellRangeAddress(9, 9, 2, 5);
        setRegionUtil(sheet,region92);
        sheet.addMergedRegion(region92);
        CellUtil.setAlignment(cell92, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell92, VerticalAlignment.CENTER);

        Cell cell93 = row9.createCell(6);
        cell93.setCellValue("款式图后片:");
        CellRangeAddress region93 = new CellRangeAddress(9, 9, 6, 7);
        setRegionUtil(sheet,region93);
        sheet.addMergedRegion(region93);
        CellUtil.setAlignment(cell93, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell93, VerticalAlignment.CENTER);

        Cell cell94 = row9.createCell(8);
        cell94.setCellValue("款式图后片值");
        CellRangeAddress region94 = new CellRangeAddress(9, 9, 8, 11);
        setRegionUtil(sheet,region94);
        sheet.addMergedRegion(region94);
        CellUtil.setAlignment(cell94, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell94, VerticalAlignment.CENTER);


        //设置第十一行
        Row row10 = sheet.createRow(10);

        Cell cell101 = row10.createCell(0);
        cell101.setCellValue("核算记录:");
        CellRangeAddress region101 = new CellRangeAddress(10, 10, 0, 1);
        setRegionUtil(sheet,region101);
        sheet.addMergedRegion(region101);
        CellUtil.setAlignment(cell101, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell101, VerticalAlignment.CENTER);

        Cell cell102 = row10.createCell(2);
        cell102.setCellValue("程仕娟 审批通过 2023-11-07 14:34\n" +
                "吴鸣英 审核通过 2023-11-07 10:12\n:");
        CellRangeAddress region102 = new CellRangeAddress(10, 10, 2, 11);
        setRegionUtil(sheet,region102);
        sheet.addMergedRegion(region102);
        CellUtil.setAlignment(cell102, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell102, VerticalAlignment.CENTER);

        //第十二行是空行
        CellRangeAddress region11 = new CellRangeAddress(11, 11, 0, 11);
        setRegionUtil(sheet, region11);
        sheet.addMergedRegion(region11);

        //第十三行
        Row row12 = sheet.createRow(12);

        Cell cell121 = row12.createCell(0);
        cell121.setCellValue("项目名称:");
        CellRangeAddress region121 = new CellRangeAddress(12, 12, 0, 1);
        setRegionUtil(sheet,region121);
        sheet.addMergedRegion(region121);
        CellUtil.setAlignment(cell121, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell121, VerticalAlignment.CENTER);

        Cell cell122 = row12.createCell(2);
        cell122.setCellValue("工序名称");
        CellRangeAddress region122 = new CellRangeAddress(12, 12, 2, 5);
        setRegionUtil(sheet,region122);
        sheet.addMergedRegion(region122);
        CellUtil.setAlignment(cell122, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell122, VerticalAlignment.CENTER);

        Cell cell123 = row12.createCell(6);
        cell123.setCellValue("工序总价");
        CellRangeAddress region123 = new CellRangeAddress(12, 12, 6, 11);
        setRegionUtil(sheet,region123);
        sheet.addMergedRegion(region123);
        CellUtil.setAlignment(cell123, HorizontalAlignment.CENTER);
        CellUtil.setVerticalAlignment(cell123, VerticalAlignment.CENTER);

        //生成一张表
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "03.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    @Test
    public void testWrite03BigData() throws Exception {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }

        System.out.println("OVER");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "testWrite03BigData.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end - begin) / 1000);
    }

    @Test
    public void testWrite07BigData() throws Exception {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }

        System.out.println("OVER");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "testWrite07BigData.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end - begin) / 1000);
    }

    @Test
    public void testWrite07BigDataS() throws Exception {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个工作簿
        Workbook workbook = new SXSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for (int rowNum = 0; rowNum < 100000; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }

        System.out.println("OVER");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "testWrite07BigData.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        //清除临时文件!
        ((SXSSFWorkbook) workbook).dispose();
        long end = System.currentTimeMillis();
        System.out.println((double) (end - begin) / 1000);
    }

    private static void setRegionUtil(Sheet sheet, CellRangeAddress rangeAddress) {
        RegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, sheet); // 设置合并单元格上边框样式为细线
        RegionUtil.setTopBorderColor(IndexedColors.BLACK.getIndex(), rangeAddress, sheet); // 设置合并单元格上边框颜色为黑色
        RegionUtil.setBorderBottom(BorderStyle.THIN, rangeAddress, sheet); // 设置合并单元格下边框样式为细线
        RegionUtil.setBottomBorderColor(IndexedColors.BLACK.getIndex(), rangeAddress, sheet); // 设置合并单元格下边框颜色为黑色
        RegionUtil.setBorderLeft(BorderStyle.THIN, rangeAddress, sheet); // 设置合并单元格左边框样式为细线
        RegionUtil.setLeftBorderColor(IndexedColors.BLACK.getIndex(), rangeAddress, sheet); // 设置合并单元格左边框颜色为黑色
        RegionUtil.setBorderRight(BorderStyle.THIN, rangeAddress, sheet); // 设置合并单元格右边框样式为细线
        RegionUtil.setRightBorderColor(IndexedColors.BLACK.getIndex(), rangeAddress, sheet); // 设置合并单元格右边框颜色为黑色
    }
}
