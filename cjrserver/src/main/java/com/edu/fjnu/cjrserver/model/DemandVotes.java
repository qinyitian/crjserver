package com.edu.fjnu.cjrserver.model;

/**
 * DemandVotes 记录用户是否投过票
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class DemandVotes extends ValueObject {

    /* 需求调查表投票ID、唯一标识 */
    private Integer votesID;
    /* 使用主体 */
    private DisabledUser disabledUser;
    /* 需求调查表 */
    private DemandTable demandTable;

    public Integer getVotesID() {
        return votesID;
    }

    public void setVotesID(Integer votesID) {
        this.votesID = votesID;
    }

    public DisabledUser getDisabledUser() {
        return disabledUser;
    }

    public void setDisabledUser(DisabledUser disabledUser) {
        this.disabledUser = disabledUser;
    }

    public DemandTable getDemandTable() {
        return demandTable;
    }

    public void setDemandTable(DemandTable demandTable) {
        this.demandTable = demandTable;
    }

    @Override
    public String toString() {
        return "DemandVotes{" +
                "votesID=" + votesID +
                '}';
    }
}
