package com.edu.fjnu.cjrserver.model;

/**
 * Activity 活动服务
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 * @change 朱荣盛  20180-03-13
 */
public class Activity extends ValueObject {

	/*活动服务ID*/
	private Integer activityID;
	/*活动服务名称*/
    private String activityName;
    /*企业*/
    private Company company;
    /*企业名称*/
    private String companyName;
    /*详情文件*/
    private String detailFile;
    /*详细地址*/
    private String activityAddress;
    /*省*/
	private String province;
	/*市*/
	private String city;
	/*县，区*/
	private String county;
	/*经度*/
	private double lon;
	/*纬度*/
	private double lat;

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	private String linkman;
    private String linkmanTelephone;
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

	public Integer getActivityID() {
		return activityID;
	}

	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
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

	public String getDetailFile() {
		return detailFile;
	}

	public void setDetailFile(String detailFile) {
		this.detailFile = detailFile;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanTelephone() {
		return linkmanTelephone;
	}

	public void setLinkmanTelephone(String linkmanTelephone) {
		this.linkmanTelephone = linkmanTelephone;
	}

	@Override
	public String toString() {
		return "Activity{" +
				"activityID=" + activityID +
				", activityName='" + activityName + '\'' +
				", company=" + company.getCompanyID() +
				", companyName='" + companyName + '\'' +
				", detailFile='" + detailFile + '\'' +
				", activityAddress='" + activityAddress + '\'' +
				", linkman='" + linkman + '\'' +
				", linkmanTelephone='" + linkmanTelephone + '\'' +
				'}';
	}
}
