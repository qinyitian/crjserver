package com.edu.fjnu.cjrserver.model;

/**
 * 企业信息表
 * Created by 朱仲策 on 2018/1/2.
 */
public class CompanyInfo {
    /*企业ID*/
    private Integer companyID;
    /*企业名称*/
    private String companyName;
    /*企业地址*/
    private String companyAddress;
    /*企业邮箱*/
    private String companyEmail;
    /*企业经营范围*/
    private String companyBusinessScope;
    /*企业营业执照号*/
    private String businessLicense;

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyBusinessScope() {
        return companyBusinessScope;
    }

    public void setCompanyBusinessScope(String companyBusinessScope) {
        this.companyBusinessScope = companyBusinessScope;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "companyID=" + companyID +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyBusinessScope='" + companyBusinessScope + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                '}';
    }
}
