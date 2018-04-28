package com.edu.fjnu.cjrserver.model;

/**
 * 企业表
 * Created by Administrator on 2017/12/27 0027.
 */
public class Company {

    /*企业ID*/
    private Integer companyID;
    /*企业密码*/
    private String companyPassword;
    /*企业名称*/
    private String companyName;
    /*企业邀请码*/
    private String companyInviteCode;
    /*企业联系电话*/
    private String phone;
    /*企业状态*/
    private Integer state;

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyInviteCode() {
        return companyInviteCode;
    }

    public void setCompanyInviteCode(String companyInviteCode) {
        this.companyInviteCode = companyInviteCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID=" + companyID +
                ", companyPassword='" + companyPassword + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyInviteCode='" + companyInviteCode + '\'' +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                '}';
    }
}
