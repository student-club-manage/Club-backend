package com.feng.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.feng.entity.User;
import com.feng.service.UserexcelService;
import org.springframework.context.annotation.Scope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangzhenjun
 * @date 2022/12/2 15:38
 */
@Slf4j
@Component
// 每次bean都是新的，不要单例
@Scope("prototype")
public class ImportDataListener implements ReadListener<User> {

    @Autowired
    @Lazy
    private UserexcelService userexcelService;

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<User> importExcelDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);


    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(User data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        importExcelDataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (importExcelDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            importExcelDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", importExcelDataList.size());
        userexcelService.insertBatch(importExcelDataList);
        log.info("存储数据库成功！");
    }
}
