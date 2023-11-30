package com.whj.excel.easyexcle.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author JieSir
 * @Date 2023/11/30 15:43
 * @Version 1.0
 */

@Data
public class ZHDataVO {

    @ExcelProperty("一级分类")
    private String first;

    @ExcelProperty("二级分类")
    private String second;

    @ExcelProperty("三级分类")
    private String third;
}
