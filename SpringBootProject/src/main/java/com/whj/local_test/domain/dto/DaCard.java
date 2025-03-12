package com.whj.local_test.domain.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author CiZhong
 * @date 2024-12-02
 */
@Data
public class DaCard {

    @ExcelProperty("text")
    private String text;
}
