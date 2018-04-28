package com.edu.fjnu.cjrserver.model;

/**
 * DisabledAssessTender 残疾人评价招标
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class DisabledAssessTender extends ValueObject {

    /* 残疾人评价ID、唯一主键 */
    private Integer disabledAssessID;
    /* 招标ID */
    private Integer tenderID;
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

    public Integer getTenderID() {
        return tenderID;
    }

    public void setTenderID(Integer tenderID) {
        this.tenderID = tenderID;
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
