package com.edu.fjnu.cjrserver.model;

/**
 * Artificial 人工服务
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class Artificial extends ValueObject {
    /*活动服务ID*/
    private Integer artificialID;
    /*活动服务名称*/
    private String artificialName;
    /*详情文件*/
    private String artificialFile;
    /*联系电话*/
    private String phone;
    /*企业*/
    private Company company;
    /*企业名称*/
    private String companyName;
    /*价格*/
    private String price;
    /*适用人群*/
    private String suitableCrowd;
    /*审核状态*/
    private Integer artificialState;
    /* 评价等级 */
    private Double assessGrade;
    /* 评价数量 */
    private Integer assessQty;

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

    @Override
    public String toString() {
        return "Artificial{" +
                "artificialID=" + artificialID +
                ", artificialName='" + artificialName + '\'' +
                ", artificialFile='" + artificialFile + '\'' +
                ", phone='" + phone + '\'' +
                ", company=" + company.getCompanyID() +
                ", companyName='" + companyName + '\'' +
                ", price='" + price + '\'' +
                ", suitableCrowd='" + suitableCrowd + '\'' +
                ", artificialState=" + artificialState +
                '}';
    }

    public Integer getArtificialID() {
        return artificialID;
    }

    public void setArtificialID(Integer artificialID) {
        this.artificialID = artificialID;
    }

    public String getArtificialName() {
        return artificialName;
    }

    public void setArtificialName(String artificialName) {
        this.artificialName = artificialName;
    }

    public String getArtificialFile() {
        return artificialFile;
    }

    public void setArtificialFile(String artificialFile) {
        this.artificialFile = artificialFile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSuitableCrowd() {
        return suitableCrowd;
    }

    public void setSuitableCrowd(String suitableCrowd) {
        this.suitableCrowd = suitableCrowd;
    }

    public Integer getArtificialState() {
        return artificialState;
    }

    public void setArtificialState(Integer artificialState) {
        this.artificialState = artificialState;
    }
}
