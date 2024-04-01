package com.whj.local_test.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whj.local_test.domain.dto.TreePageDTO;
import com.whj.local_test.domain.entity.TreeEntity;
import com.whj.local_test.dao.TreeDao;
import com.whj.local_test.service.ITreeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author whj
 * @since 2024-01-15 19:55:09
 */
@Service
@Slf4j
public class TreeServiceImpl extends ServiceImpl<TreeDao, TreeEntity> implements ITreeService {

    @Override
    public List<TreeEntity> list(TreePageDTO dto) {

        Page<TreeEntity> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        Page<TreeEntity> treeEntityPage = this.page(page);
        List<TreeEntity> records = treeEntityPage.getRecords();
        return records;
    }

    @Override
    public void export(TreePageDTO dto, HttpServletResponse response) {

        //此处设置pageNo和pageSize
        int pageNum = 1;
        int pageSize = 100;


        try {
            ExcelWriter excelWriter = null;
            WriteSheet writeSheet = null;


            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("导出结果", "UTF-8").replace("\\+", "%20");
            response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename" + fileName + ".xlsx");

            writeSheet = EasyExcel.writerSheet("qq").build();
            while (true) {
                dto.setPageNum(pageNum);
                dto.setPageSize(pageSize);
                List<TreeEntity> list = list(dto);
                if (CollectionUtil.isEmpty(list)) {
                    break;
                }
                excelWriter = EasyExcel.write(response.getOutputStream(), TreeEntity.class)
                        .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                        .build();

                excelWriter.write(list, writeSheet);
                pageNum++;
            }

        } catch (Exception e) {
            log.error("导出失败   {}", e);
        }
    }
}
