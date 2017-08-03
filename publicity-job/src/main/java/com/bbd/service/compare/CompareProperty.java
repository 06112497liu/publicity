/**
 * BBD Service Inc
 * All Rights Reserved @2016
 */
package com.bbd.service.compare;

/**
 * 对比属性
 *
 * @author tjwang
 * @version $Id: CompareProperty.java, v 0.1 2017/7/10 0010 17:51 tjwang Exp $
 */
public abstract class CompareProperty<T> {

    /**
     * 属性名称
     */
    private String name;

    /**
     * 所属子模块
     */
    private Integer submodule;

    /**
     * 标准数据
     */
    private T base;

    /**
     * 对比数据
     */
    private T other;

    /**
     * 对比信息。0. 正常；1. 隐瞒未报；2. 登记不一致；4. 格式错误
     *
     * @return
     */
    public abstract int compare();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSubmodule() {
        return submodule;
    }

    public void setSubmodule(Integer submodule) {
        this.submodule = submodule;
    }

    public T getBase() {
        return base;
    }

    public void setBase(T base) {
        this.base = base;
    }

    public T getOther() {
        return other;
    }

    public void setOther(T other) {
        this.other = other;
    }
}
