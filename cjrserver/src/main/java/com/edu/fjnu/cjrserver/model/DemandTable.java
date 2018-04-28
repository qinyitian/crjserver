package com.edu.fjnu.cjrserver.model;

/**
 * DemandTable 需求调查表
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class DemandTable extends ValueObject {

    /* 需求调查表名 */
    private String demandTableName;
    /* 需求调查表ID,唯一标识 */
    private Integer demandTableID;
    /* 需求调查表开始时间 */
    private String demandTableStartTime;
    /* 需求调查表结束时间 */
    private String demandTableEndTime;
    /* 需求调查表状态 */
    private Integer demandTableState;
    /* 评价等级 */
    private Double assessGrade;
    /* 评价数量 */
    private Integer assessQty;
    /* 0表示调查表，1表示需求目录*/
    private  Integer tag;

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    /* 需求目录名 */
    private  String aliasName;

    /* 需求目录状态*/
    private Integer catalogState;

    public Integer getCatalogState() {
        return catalogState;
    }

    public void setCatalogState(Integer catalogState) {
        this.catalogState = catalogState;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getDemandTableName() {
        return demandTableName;
    }

    public void setDemandTableName(String demandTableName) {
        this.demandTableName = demandTableName;
    }

    public Integer getDemandTableID() {
        return demandTableID;
    }

    public void setDemandTableID(Integer demandTableID) {
        this.demandTableID = demandTableID;
    }

    public String getDemandTableStartTime() {
        return demandTableStartTime;
    }

    public void setDemandTableStartTime(String demandTableStartTime) {
        this.demandTableStartTime = demandTableStartTime;
    }

    public String getDemandTableEndTime() {
        return demandTableEndTime;
    }

    public void setDemandTableEndTime(String demandTableEndTime) {
        this.demandTableEndTime = demandTableEndTime;
    }

    public Integer getDemandTableState() {
        return demandTableState;
    }

    public void setDemandTableState(Integer demandTableState) {
        this.demandTableState = demandTableState;
    }

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
}
