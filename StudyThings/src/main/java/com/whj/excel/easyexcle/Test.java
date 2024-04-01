package com.whj.excel.easyexcle;

public class Test {

    public static void main(String[] args) {
//        int pageNum = 1;
//        int pageSize = 100;
//
//        try {
//            ExcelWriter excelWriter = null;
//            WriteSheet writeSheet = null;
//
//            writeSheet = EasyExcel.writerSheet(itemTypeName).build();
//            while (true) {
//                qryDto.setPageSize(pageSize);
//                qryDto.setPageNum(pageNum);
//                CmsProcessCountOrderPageVo pageVo = list(qryDto);
//                List<CmsProcessCountOrderExtVo> resultVoList = new ArrayList<>();
//                if (CollectionUtils.isNotEmpty(pageVo.getList())) {
//                    resultVoList = pageVo.getList();
//                }
//                if (CollectionUtils.isEmpty(resultVoList)) {
//                    break;
//                }
//                List<CmsProcessCountOrderExportVo> exportVoList = new ArrayList<>();
//                if (CollectionUtils.isNotEmpty(resultVoList)) {
//                    resultVoList.forEach(e -> {
//                        CmsProcessCountOrderExportVo exportVo = e.toExportVo();
//                        exportVoList.add(exportVo);
//                    });
//                }
//                excelWriter = EasyExcel.write(response.getOutputStream(), CmsProcessCountOrderExportVo.class)
//                        .registerWriteHandler(EasyExcelUtil.resetFontProperty())
//                        .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
//                        .registerWriteHandler(new CmsProcessCountOrderMergeStrategy(exportVoList))
//                        .build();
//                excelWriter.write(exportVoList, writeSheet);
//                pageNum++;
//            }
//    }
    }
}