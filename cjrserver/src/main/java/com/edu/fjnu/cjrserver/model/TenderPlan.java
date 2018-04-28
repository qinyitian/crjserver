package com.edu.fjnu.cjrserver.model;

/**
 * 招标计划
 * Created by Administrator on 2018/3/4 0004.
 */
public class TenderPlan {
    /*招标计划ID*/
    private Integer tenderPlanID;
    /*招标计划名称*/
    private String tenderPlanName;
    /*招标计划开始时间*/
    private String tenderPlanStartTime;
    /*招标计划结束时间*/
    private String tenderPlanEndTime;
    /*招标计划文件*/
    private String tenderPlanFilePath;
    /*招标计划提醒*/
    private Integer tenderNotice;
    /*招标计划是否结束*/
    private Integer tenderWinstatus=0;
    /*招标计划投票时间*/
    private String voteEndTime;

    public Integer getTenderPlanID() {
        return tenderPlanID;
    }

    public void setTenderPlanID(Integer tenderPlanID) {
        this.tenderPlanID = tenderPlanID;
    }

    public String getTenderPlanName() {
        return tenderPlanName;
    }

    public void setTenderPlanName(String tenderPlanName) {
        this.tenderPlanName = tenderPlanName;
    }

    public String getTenderPlanStartTime() {
        return tenderPlanStartTime;
    }

    public void setTenderPlanStartTime(String tenderPlanStartTime) {
        this.tenderPlanStartTime = tenderPlanStartTime;
    }

    public String getTenderPlanEndTime() {
        return tenderPlanEndTime;
    }

    public void setTenderPlanEndTime(String tenderPlanEndTime) {
        this.tenderPlanEndTime = tenderPlanEndTime;
    }

    public String getTenderPlanFilePath() {
        return tenderPlanFilePath;
    }

    public void setTenderPlanFilePath(String tenderPlanFilePath) {
        this.tenderPlanFilePath = tenderPlanFilePath;
    }

    public Integer getTenderNotice() {
        return tenderNotice;
    }

    public void setTenderNotice(Integer tenderNotice) {
        this.tenderNotice = tenderNotice;
    }

    public Integer getTenderWinstatus() {
        return tenderWinstatus;
    }

    public void setTenderWinstatus(Integer tenderWinstatus) {
        this.tenderWinstatus = tenderWinstatus;
    }

    public String getVoteEndTime() {
        return voteEndTime;
    }

    public void setVoteEndTime(String voteEndTime) {
        this.voteEndTime = voteEndTime;
    }

    @Override

    public String toString() {
        return "TenderPlan{" +
                "tenderPlanID=" + tenderPlanID +
                ", tenderPlanName='" + tenderPlanName + '\'' +
                ", tenderPlanStartTime='" + tenderPlanStartTime + '\'' +
                ", tenderPlanEndTime='" + tenderPlanEndTime + '\'' +
                ", tenderPlanFilePath='" + tenderPlanFilePath + '\'' +
                ", tenderNotice='" + tenderNotice + '\'' +
                ", tenderWinstatus='" + tenderWinstatus + '\'' +
                '}';
    }
}
