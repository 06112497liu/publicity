
/** 
 * BBD Service Inc 
 * All Rights Reserved @2017 
 */
 package com.bbd.util;

import java.util.List;

import com.google.common.collect.Lists;

/** 
 *  
 * @author liuweibo 
 * @version $Id: NumUtils.java, v 0.1 2017年8月22日 上午10:50:18 liuweibo Exp $ 
 */
public class NumUtils {
    public static List<Integer> getExistNum(int num, List<Integer> base) {
        List<Integer> rs = Lists.newArrayList();
        for (int i = 0; i < base.size(); i++) {
            int t = base.get(i);
            int temp = (num / t) % 2;
            if(temp == 1) rs.add(t);
        }
        return rs;
    }

}

