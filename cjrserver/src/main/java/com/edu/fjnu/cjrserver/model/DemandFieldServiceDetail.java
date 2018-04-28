package com.edu.fjnu.cjrserver.model;

/**
 * DemandFieldServiceDetail 场地服务详情表
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class DemandFieldServiceDetail extends ValueObject {

    /* 场地服务详情表ID */
    private Integer no;
    /* 场地服务ID */
    private FieldServer serviceID;
    /* 需求调查表 */
    private DemandTable demandTable;
    /* 采购数量 */
    private Integer count=0;
    /* 投票数量 */
    private Integer votes=0;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public FieldServer getServiceID() {
        return serviceID;
    }

    public void setServiceID(FieldServer serviceID) {
        this.serviceID = serviceID;
    }

    public DemandTable getDemandTable() {
        return demandTable;
    }

    public void setDemandTable(DemandTable demandTable) {
        this.demandTable = demandTable;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }
}
