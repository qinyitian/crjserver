package com.edu.fjnu.cjrserver.model;

/**
 * 中标企业信息
 * Created by 朱仲 on 2018/2/22.
 */
public class WinBidCompany {
    /*记录信息*/
    Integer winBidCompanyID;
    /*招标计划*/
    TenderPlan tenderPlan;
    /*企业信息*/
    CompanyInfo company;
    /*投票数量*/
    Integer vote;

    public Integer getWinBidCompanyID() {
        return winBidCompanyID;
    }

    public void setWinBidCompanyID(Integer winBidCompanyID) {
        this.winBidCompanyID = winBidCompanyID;
    }

    public TenderPlan getTenderPlan() {
        return tenderPlan;
    }

    public void setTenderPlan(TenderPlan tenderPlan) {
        this.tenderPlan = tenderPlan;
    }

    public CompanyInfo getCompany() {
        return company;
    }

    public void setCompany(CompanyInfo company) {
        this.company = company;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "WinBidCompany{" +
                "winBidCompanyID=" + winBidCompanyID +
                ", tenderPlan=" + tenderPlan +
                ", company=" + company +
                ", vote=" + vote +
                '}';
    }
}
