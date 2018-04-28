package com.edu.fjnu.cjrserver.model;

/**
 * 场地服务
 */
public class FieldServer {

    /*场地服务ID*/
    private Integer fieldID;
    /*场地服务名称*/
    private String fieldName;
    /*省*/
    private String province;
    /*市*/
    private String city;
    /*县，区*/
    private String county;
    /*详细地址*/
    private String  fieldAddress;
    /*价格*/
    private double price;
    /*营业时间*/
    private String businessTime;
    /*详细介绍*/
    private String detailIntroduct;
    /*企业*/
    private Company company;
    /*企业名称*/
    private String companyName;
    /*联系电话*/
    private String phone;
    /*经度*/
    private double lon;
    /*纬度*/
    private double lat;
    /*审核状态*/
    private Integer fieldState;
    /*图片*/
    private String fieldImg;
    /* 评价等级 */
    private Double assessGrade;
    /* 评价数量 */
    private Integer assessQty;

    public Double getAssessGrade() {
        return assessGrade;
    }

    public void setAssessGrade(Double assessGrade) {
        this.assessGrade = assessGrade;
    }

    public Integer getAssessQty() {
        return assessQty;
    }

    public void setAssessQty(Integer assessQty) {
        this.assessQty = assessQty;
    }

    public Integer getFieldID() {
        return fieldID;
    }

    public void setFieldID(Integer fieldID) {
        this.fieldID = fieldID;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getFieldAddress() {
        return fieldAddress;
    }

    public void setFieldAddress(String fieldAddress) {
        this.fieldAddress = fieldAddress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public String getDetailIntroduct() {
        return detailIntroduct;
    }

    public void setDetailIntroduct(String detailIntroduct) {
        this.detailIntroduct = detailIntroduct;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Integer getFieldState() {
        return fieldState;
    }

    public void setFieldState(Integer fieldState) {
        this.fieldState = fieldState;
    }

    public String getFieldImg() {
        return fieldImg;
    }

    public void setFieldImg(String fieldImg) {
        this.fieldImg = fieldImg;
    }

    @Override
    public String toString() {
        return "FieldServer{" +
                "fieldID=" + fieldID +
                ", fieldName='" + fieldName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", fieldAddress='" + fieldAddress + '\'' +
                ", price=" + price +
                ", businessTime='" + businessTime + '\'' +
                ", detailIntroduct='" + detailIntroduct + '\'' +
                ", company=" + company +
                ", companyName='" + companyName + '\'' +
                ", phone='" + phone + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", fieldState=" + fieldState +
                ", fieldImg='" + fieldImg + '\'' +
                '}';
    }
}
