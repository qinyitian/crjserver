package com.edu.fjnu.cjrserver.model;

/**
 * DisabledAssessDemand 残疾人评价需求
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class DisabledAssessDemand extends ValueObject {

    /* 残疾人评价ID、唯一主键 */
    private Integer disabledAssessID;
    /* 需求目录ID */
    private DemandTable demandTable;
    /* 残疾人ID */
    private DisabledUser disabledUser;
    /* 评价等级 */
    private Double grade;

    public Integer getDisabledAssessID() {
        return disabledAssessID;
    }

    public void setDisabledAssessID(Integer disabledAssessID) {
        this.disabledAssessID = disabledAssessID;
    }

    public DemandTable getDemandTable() {
        return demandTable;
    }

    public void setDemandTable(DemandTable demandTable) {
        this.demandTable = demandTable;
    }

    public DisabledUser getDisabledUser() {
        return disabledUser;
    }

    public void setDisabledUser(DisabledUser disabledUser) {
        this.disabledUser = disabledUser;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

}
