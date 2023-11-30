package com.whj.test.amsArchives.dateListener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSON;
import com.whj.test.amsArchives.dao.AmsArchivesNewDao;
import com.whj.test.amsArchives.domain.dto.ExcelImportDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JieSir
 * @Date 2023/10/24 11:29
 * @Version 1.0
 */
@Slf4j
public class ArchivesListener extends AnalysisEventListener<ExcelImportDTO> {

    @Override
    public void invoke(ExcelImportDTO excelImportDTO, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
