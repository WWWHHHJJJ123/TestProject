package com.whj.common;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * @Author JieSir
 * @Date 2023/8/5 11:33
 * @Version 1.0
 */

public class UserMergeStrategy implements CellWriteHandler {
    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        //校验：表头不做处理
        if (isHead) {
            return;
        }
        //校验：如果是数据第一行，则不处理
        if (relativeRowIndex == 1) {
            return;
        }
        //获取上一行的下标，当前行的下标以及上一行对象
        Sheet sheet = cell.getSheet();
        int rowIndexCurrent = cell.getRowIndex();
        int rowIndexPrev = rowIndexCurrent - 1;
        Row rowPrev = sheet.getRow(rowIndexPrev);

    }
}
