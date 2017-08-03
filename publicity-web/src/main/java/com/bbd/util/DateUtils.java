/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
package com.bbd.util;

import com.google.common.collect.Lists;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/** 
 *  
 * @author liuweibo 
 * @version $Id: DateUtils.java, v 0.1 2017年8月1日 下午5:50:44 liuweibo Exp $ 
 */
public class DateUtils {

    // 将Date转换为LocalDateTime
    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    // 将Date转换为LocalDate
    public static LocalDate convertDateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone).toLocalDate();
    }

    // 将LocalDateTime转换为Date
    public static Date convertLocalDateTimeToDate(LocalDateTime date) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = date.atZone(zone).toInstant();
        return Date.from(instant);
    }

    // 返回日期最大的值
    public static LocalDateTime getMaxDate(LocalDateTime... params) {
        List<LocalDateTime> temp = Lists.newArrayList(params);
        Optional<LocalDateTime> result = temp.stream().max((x, y) -> x.compareTo(y));
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
