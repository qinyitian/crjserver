package com.edu.fjnu.cjrserver.model;

/**
 * DisabledAssessServer 残疾人评价服务
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class DisabledAssessServer {

    /* 残疾人评价ID、唯一主键 */
    private Integer disabledAssessID;
    /* 服务ID */
    private Integer serverID;
    /* 服务表名 */
    private String serverTableName;
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

    public Integer getServerID() {
        return serverID;
    }

    public void setServerID(Integer serverID) {
        this.serverID = serverID;
    }

    public String getServerTableName() {
        return serverTableName;
    }

    public void setServerTableName(String serverTableName) {
        this.serverTableName = serverTableName;
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
