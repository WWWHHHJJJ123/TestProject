package com.whj.excel.easyexcle.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author JieSir
 * @Date 2023/11/27 9:44
 * @Version 1.0
 */

@Data
@AllArgsConstructor
public class DemoMergeData {

    private Integer id;

    @ExcelProperty("姓名")
    private String sub;

    @ExcelProperty("分数")
    private String date;
}
