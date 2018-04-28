package com.edu.fjnu.cjrserver.model;

/**
 * DemandVotesSportServiceDetail 记录用户对体育赛事服务投票保留
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class DemandVotesSportServiceDetail extends ValueObject {

    /* 需求调查表投票明细ID */
    private Integer no;
    /* 调查表投票 */
    private DemandVotes demandVotes;
    /* 服务ID */
    private Integer serviceID;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public DemandVotes getDemandVotes() {
        return demandVotes;
    }

    public void setDemandVotes(DemandVotes demandVotes) {
        this.demandVotes = demandVotes;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }
}
