package com.edu.fjnu.cjrserver.model;

/**
 * AssessReport 评价报告
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class AssessReport extends ValueObject {

    /*评价报告ID*/
    private Integer assessID;
    /*评价机构ID*/
    private Integer mediaID;
    /*评价报告名称*/
    private String assessName;
    /*文件路径*/
    private String path;
    /*文件类型*/
    private Integer reportType;

    public Integer getAssessID() {
        return assessID;
    }

    public void setAssessID(Integer assessID) {
        this.assessID = assessID;
    }

    public Integer getMediaID() {
        return mediaID;
    }

    public void setMediaID(Integer mediaID) {
        this.mediaID = mediaID;
    }

    public String getAssessName() {
        return assessName;
    }

    public void setAssessName(String assessName) {
        this.assessName = assessName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    @Override
    public String toString() {
        return "AssessReport{" +
                "assessID=" + assessID +
                ", mediaID=" + mediaID +
                ", assessName='" + assessName + '\'' +
                ", path='" + path + '\'' +
                ", reportType=" + reportType +
                '}';
    }
}
