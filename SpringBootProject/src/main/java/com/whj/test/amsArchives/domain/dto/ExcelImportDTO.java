package com.whj.test.amsArchives.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author JieSir
 * @Date 2023/10/24 10:34
 * @Version 1.0
 */

@Data
public class ExcelImportDTO {

    @ExcelProperty(value = "档案",index = 0)
    private String archives;


    @ExcelProperty(value = "档案code",index = 1)
    private String archivesCode;

    @ExcelProperty(value = "一级字段",index = 2)
    private String firstField;

    @ExcelProperty(value = "字段code",index = 3)
    private String fieldCode;

    @ExcelProperty(value = "一级字段",index = 4)
    private String secondField;


}
