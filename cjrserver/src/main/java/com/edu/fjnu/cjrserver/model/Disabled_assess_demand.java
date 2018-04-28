package com.edu.fjnu.cjrserver.model;

/**
 * 残疾人评价表
 * Created by 朱仲策 on 2018/1/2.
 */
public class Disabled_assess_demand {
    private Integer DisabledAssessID;
    private Integer DemadID;
    private Integer DisabledID;
    private Double Grade;

    public Integer getDisabledAssessID() {
        return DisabledAssessID;
    }

    public void setDisabledAssessID(Integer disabledAssessID) {
        DisabledAssessID = disabledAssessID;
    }

    public Integer getDemadID() {
        return DemadID;
    }

    public void setDemadID(Integer demadID) {
        DemadID = demadID;
    }

    public Integer getDisabledID() {
        return DisabledID;
    }

    public void setDisabledID(Integer disabledID) {
        DisabledID = disabledID;
    }

    public Double getGrade() {
        return Grade;
    }

    public void setGrade(Double grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Disabled_assess_demand{" +
                "DisabledAssessID=" + DisabledAssessID +
                ", DemadID=" + DemadID +
                ", DisabledID=" + DisabledID +
                ", Grade=" + Grade +
                '}';
    }
}
