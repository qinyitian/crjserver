package com.edu.fjnu.cjrserver.model;


/**
 * 赛事服务
 * @author lm
 *
 */
public class Sport {

    /*赛事服务信息*/
	private Integer sportID;
	/*赛事服务类型*/
    private String sportType;
    /*赛事服务名称*/
    private String sportName;
    /*企业*/
    private Company company;
    /*企业名称*/
    private String companyName;
    /*介绍文件*/
    private String introductFile;
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

    public Integer getSportID() {
        return sportID;
    }

    public void setSportID(Integer sportID) {
        this.sportID = sportID;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
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

    public String getIntroductFile() {
        return introductFile;
    }

    public void setIntroductFile(String introductFile) {
        this.introductFile = introductFile;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportID=" + sportID +
                ", sportType='" + sportType + '\'' +
                ", sportName='" + sportName + '\'' +
                ", company=" + company +
                ", companyName='" + companyName + '\'' +
                ", introductFile='" + introductFile + '\'' +
                '}';
    }
}
