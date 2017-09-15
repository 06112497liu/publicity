package com.bbd.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "report")
public class ReportProperties {

    private String wholeCity;

    private String zhiGuan;

    private String nanMing;

    private String yunYan;

    private String huaXi;

    private String wuDang;

    private String baiYun;

    private String jingJi;

    private String guanShanHu;

    private String kaiYang;

    private String xiFeng;

    private String xiuWen;

    private String qingZhen;

    private String hangKongGang;

    private String baoShui;

    private String gaoXin;

    private String qiTa;

    public String getWholeCity() {
        return wholeCity;
    }

    public void setWholeCity(String wholeCity) {
        this.wholeCity = wholeCity;
    }

    public String getZhiGuan() {
        return zhiGuan;
    }

    public void setZhiGuan(String zhiGuan) {
        this.zhiGuan = zhiGuan;
    }

    public String getNanMing() {
        return nanMing;
    }

    public void setNanMing(String nanMing) {
        this.nanMing = nanMing;
    }

    public String getYunYan() {
        return yunYan;
    }

    public void setYunYan(String yunYan) {
        this.yunYan = yunYan;
    }

    public String getHuaXi() {
        return huaXi;
    }

    public void setHuaXi(String huaXi) {
        this.huaXi = huaXi;
    }

    public String getWuDang() {
        return wuDang;
    }

    public void setWuDang(String wuDang) {
        this.wuDang = wuDang;
    }

    public String getBaiYun() {
        return baiYun;
    }

    public void setBaiYun(String baiYun) {
        this.baiYun = baiYun;
    }

    public String getJingJi() {
        return jingJi;
    }

    public void setJingJi(String jingJi) {
        this.jingJi = jingJi;
    }

    public String getGuanShanHu() {
        return guanShanHu;
    }

    public void setGuanShanHu(String guanShanHu) {
        this.guanShanHu = guanShanHu;
    }

    public String getKaiYang() {
        return kaiYang;
    }

    public void setKaiYang(String kaiYang) {
        this.kaiYang = kaiYang;
    }

    public String getXiFeng() {
        return xiFeng;
    }

    public void setXiFeng(String xiFeng) {
        this.xiFeng = xiFeng;
    }

    public String getXiuWen() {
        return xiuWen;
    }

    public void setXiuWen(String xiuWen) {
        this.xiuWen = xiuWen;
    }

    public String getQingZhen() {
        return qingZhen;
    }

    public void setQingZhen(String qingZhen) {
        this.qingZhen = qingZhen;
    }

    public String getHangKongGang() {
        return hangKongGang;
    }

    public void setHangKongGang(String hangKongGang) {
        this.hangKongGang = hangKongGang;
    }

    public String getBaoShui() {
        return baoShui;
    }

    public void setBaoShui(String baoShui) {
        this.baoShui = baoShui;
    }

    public String getGaoXin() {
        return gaoXin;
    }

    public void setGaoXin(String gaoXin) {
        this.gaoXin = gaoXin;
    }

    public String getQiTa() {
        return qiTa;
    }

    public void setQiTa(String qiTa) {
        this.qiTa = qiTa;
    }

    @Override
    public String toString() {
        return "ReportProperties [wholeCity=" + wholeCity + ", zhiGuan=" + zhiGuan + ", nanMing=" + nanMing + ", yunYan=" + yunYan + ", huaXi=" + huaXi + ", wuDang=" + wuDang + ", baiYun=" + baiYun
               + ", jingJi=" + jingJi + ", guanShanHu=" + guanShanHu + ", kaiYang=" + kaiYang + ", xiFeng=" + xiFeng + ", xiuWen=" + xiuWen + ", qingZhen=" + qingZhen + ", hangKongGang="
               + hangKongGang + ", baoShui=" + baoShui + ", gaoXin=" + gaoXin + ", qiTa=" + qiTa + "]";
    }


}
