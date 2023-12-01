package com.whj.test.excel.service.impl;

import com.alibaba.excel.EasyExcel;
import com.whj.test.excel.domain.entity.AmsCategoryEntity;
import com.whj.test.excel.dao.AmsCategoryDao;
import com.whj.test.excel.domain.vo.ZHDataVO;
import com.whj.test.excel.service.IAmsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whj
 * @since 2023-11-30 16:18:22
 */
@Service
public class AmsCategoryServiceImpl extends ServiceImpl<AmsCategoryDao, AmsCategoryEntity> implements IAmsCategoryService {

    @Autowired
    private AmsCategoryDao categoryDao;
    @Override
    public void importExcel(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<ZHDataVO> objects = EasyExcel.read(inputStream, ZHDataVO.class, null).headRowNumber(1).sheet("成衣分类").doReadSync();
        objects.stream().peek(first->{
            if (first.getFirst()!=null){
                AmsCategoryEntity amsCategoryEntity=new AmsCategoryEntity();
                categoryDao.insert(amsCategoryEntity.set)
            }
        })
    }
}
