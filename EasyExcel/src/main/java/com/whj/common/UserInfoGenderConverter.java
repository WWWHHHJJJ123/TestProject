package com.whj.common;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @Author JieSir
 * @Date 2023/7/30 10:50
 * @Version 1.0
 */

public class UserInfoGenderConverter implements Converter<Integer> {

//    @Override
//    public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
//        String stringValue = cellData.getStringValue();
//        switch (stringValue) {
//            case "男":
//                return 1;
//            case "女":
//                return 2;
//            default:
//                return 0;
//        }
//    }

    @Override
    public WriteCellData<?> convertToExcelData(Integer value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        switch (value) {
            case 1:
                return new WriteCellData<>("男");
            case 2:
                return new WriteCellData<>("女");
            default:
                return new WriteCellData<>("未知");
        }
    }
}
