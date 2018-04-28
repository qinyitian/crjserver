package com.edu.fjnu.cjrserver.model;

/**
 * EquipmentContent 需求调查表
 *
 * @version 	2018-03-14
 * @author 	吴祖根
 */
public class EquipmentContent {

    /*器材ID*/
    private Integer demandID;
    /*器材名称*/
    private String demandName;
    /*器材类别*/
    private String demandCategory;
    /*器材简介*/
    private String demandRemarks;
    /*器材图片*/
    private String image;
    /*器材型号*/
    private String demandModel;
    /*审核状态*/
    private Integer demandState;
    /* 评价等级 */
    private Double assessGrade;
    /* 评价数量 */
    private Integer assessQty;
    /* 类型，0表示调查表，1表示需求目录 */
    private Integer type;

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

    public Integer getDemandID() {
        return demandID;
    }

    public void setDemandID(Integer demandID) {
        this.demandID = demandID;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getDemandCategory() {
        return demandCategory;
    }

    public void setDemandCategory(String demandCategory) {
        this.demandCategory = demandCategory;
    }

    public String getDemandRemarks() {
        return demandRemarks;
    }

    public void setDemandRemarks(String demandRemarks) {
        this.demandRemarks = demandRemarks;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDemandState() {
        return demandState;
    }

    public void setDemandState(Integer demandState) {
        this.demandState = demandState;
    }

    public String getDemandModel() {
        return demandModel;
    }

    public void setDemandModel(String demandModel) {
        this.demandModel = demandModel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
