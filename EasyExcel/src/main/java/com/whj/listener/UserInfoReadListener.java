package com.whj.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.whj.domain.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JieSir
 * @Date 2023/7/30 13:52
 * @Version 1.0
 */

public class UserInfoReadListener implements ReadListener<UserEntity> {


    private final int batchSize;

    private List<UserEntity> cacheData;

    public UserInfoReadListener(int batchSize) {

        this.batchSize = batchSize;
        this.cacheData = new ArrayList<>(this.batchSize);
    }

    public UserInfoReadListener(){
        this(5);
    }

    @Override
    public void invoke(UserEntity userEntity, AnalysisContext analysisContext) {
        this.cacheData.add(userEntity);
        System.out.println("invoke{}:      "+userEntity);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("doAfterAllAnalysed{}:        "+analysisContext);
    }
}
