package com.bbd.util;

import com.bbd.controller.vo.ExceptionCompanyVo;
import com.bbd.domain.CompanyExItem;
import com.bbd.service.compare.AnnualModule;
import com.bbd.service.compare.InstantlyModule;
import com.bbd.service.impl.ExportReportExDetailServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
                    Object obj = declaredFields[j].get(datas.get(i));
                    if(obj instanceof String)
                        rs[i][j] = replaceBlank((String) obj);
                    else
                        rs[i][j] = obj;
                } catch (IllegalArgumentException e) {
                    logger.error("", e);
                } catch (IllegalAccessException e) {
                    logger.error("", e);
                }
            }
        }
        return rs;
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
