package com.edu.fjnu.cjrserver.model;

/**
 * 投标企业，竞标企业
 */
public class CheckCompany {

    /*记录ID*/
    Integer checkCompanyID;
    /*招标计划ID*/
    TenderPlan tenderPlanID;
    /*企业名称*/
    CompanyInfo companyName;
    /*投标为0，竞标为1*/
    String checkStatus;

    public Integer getCheckCompanyID() {
        return checkCompanyID;
    }

    public void setCheckCompanyID(Integer checkCompanyID) {
        this.checkCompanyID = checkCompanyID;
    }

    public TenderPlan getTenderPlanID() {
        return tenderPlanID;
    }

    public void setTenderPlanID(TenderPlan tenderPlanID) {
        this.tenderPlanID = tenderPlanID;
    }

    public CompanyInfo getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyInfo companyName) {
        this.companyName = companyName;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Override
    public String toString() {
        return "CheckCompany{" +
                "checkCompanyID=" + checkCompanyID +
                ", tenderPlanID=" + tenderPlanID +
                ", companyName=" + companyName +
                ", checkStatus='" + checkStatus + '\'' +
                '}';
    }
}
