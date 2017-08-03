/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare.collector;

import com.bbd.domain.PubCompanyInfo;
import com.bbd.service.compare.CompareProperty;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * @author tjwang
 * @version $Id: AbstractPropertyCollector.java, v 0.1 2017/8/2 0002 9:59 tjwang Exp $
 */
public abstract class AbstractPropertyCollector<T, V> implements PropertyCollector {

    /**
     * 前置校验
     *
     * @param c
     * @return
     */
    protected abstract boolean precheck(PubCompanyInfo c);

    /**
     * 是否只有单个对比项
     *
     * @return
     */
    protected abstract boolean isSingle();

    protected abstract List<T> getStds(String nbxh);

    protected abstract List<V> getCmps(String nbxh);

    protected String getStdKey(T std) {
        return null;
    }

    protected String getCmpKey(V cmp) {
        return null;
    }

    protected abstract List<CompareProperty> getProperties(PubCompanyInfo c, Optional<T> stdOpt, Optional<V> cmpOpt);

    public List<CompareProperty> getCompareProperties(PubCompanyInfo c) {
        List<CompareProperty> result = Lists.newArrayList();

        if (!precheck(c)) {
            return result;
        }

        String nbxh = c.getNbxh();
        List<T> stds = getStds(nbxh);
        List<V> cmps = getCmps(nbxh);

        if (isSingle()) {
            Optional stdOpt = getSingleOpt(stds);
            Optional cmpOpt = getSingleOpt(cmps);
            result = getProperties(c, stdOpt, cmpOpt);
        } else {
            result = getProperties(c, stds, cmps);
        }

        return result;
    }

    private Set<String> getStdKeys(List<T> stds) {
        Set<String> keys = Sets.newHashSet();

        if (stds.size() == 0) {
            return keys;
        }

        stds.forEach(p -> keys.add(getStdKey(p)));
        return keys;
    }

    /**
     * 获取能与标准信息对上的比较信息
     *
     * @param cmps
     * @param stdKeys
     * @return
     */
    private List<V> getCmpItems(List<V> cmps, Set<String> stdKeys) {
        List<V> result = Lists.newArrayList();
        if (cmps.size() == 0 || stdKeys.size() == 0) {
            return result;
        }
        cmps.forEach(p -> {
            if (stdKeys.contains(getCmpKey(p))) {
                result.add(p);
            }
        });
        return result;
    }

    private List<CompareProperty> getProperties(PubCompanyInfo c, List<T> stds, List<V> cmps) {
        List<CompareProperty> result = Lists.newArrayList();

        if (stds.size() == 0) {
            return result;
        }

        Set<String> stdKeys = getStdKeys(stds);
        List<V> matchCmps = getCmpItems(cmps, stdKeys);

        for (T std : stds) {
            String key = getStdKey(std);
            Optional stdOpt = Optional.of(std);
            Optional cmpOpt = getCmpByKey(key, matchCmps);
            result.addAll(getProperties(c, stdOpt, cmpOpt));
        }

        return result;
    }

    private Optional getCmpByKey(String key, List<V> cmps) {
        if (cmps.size() == 0) {
            return Optional.absent();
        }
        for (V cmp : cmps) {
            if (getCmpKey(cmp).equals(key)) {
                return Optional.of(cmp);
            }
        }
        return Optional.absent();
    }

    private Optional getSingleOpt(List ds) {
        if (ds.size() == 0) {
            return Optional.absent();
        }
        return Optional.of(ds.get(0));
    }

}
