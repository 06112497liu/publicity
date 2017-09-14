package com.bbd.util;

import com.bbd.service.impl.ExportReportExDetailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

public class ReportUtils {

    private static final Logger logger = LoggerFactory.getLogger(ExportReportExDetailServiceImpl.class);

    // 构建二维数组
    public static <T> Object[][] buildTwoArray(List<T> datas) {

        Integer rows = datas.size();
        if(rows == 0) {
            return null;
        }

        Field[] declaredFields = datas.get(0).getClass().getDeclaredFields();
        Integer columns = declaredFields.length;

        Object[][] rs = new Object[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                declaredFields[j].setAccessible(true);
                try {
                    rs[i][j] = declaredFields[j].get(datas.get(i));
                } catch (IllegalArgumentException e) {
                    logger.error("", e);
                } catch (IllegalAccessException e) {
                    logger.error("", e);
                }
            }
        }
        return rs;
    }


}
