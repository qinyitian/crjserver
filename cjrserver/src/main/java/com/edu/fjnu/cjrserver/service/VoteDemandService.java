package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.DemandVotes;

import java.util.Map;

/**
 * VoteDemandService 提交个人需求用例Service设计API
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public interface VoteDemandService {

    /**
     * 记录用户成功投票了某一期调查表。
     *
     * @param demandVotes       使用主体残疾人以及调查表
     */
    void doPostDemandVote(DemandVotes demandVotes);

    /**
     * 记录用户投票的服务条目。
     *
     * @param votesID       使用主体残疾人的VotesID
     * @param serviceID        服务ID数组，二维数组，第一组
     *                          0：FieldService；1：EquipmentContent；2：ArtificialService；3：SportService；4：ActivityService；
     *                          第二组表示服务ID
     */
    void doPostDemandVote_Detail(int votesID, int[][] serviceID);

    /**
     *  更新调查表的投票记录。
     *
     * @param demandTableID         调查表ID
     * @param serviceID        服务ID数组，二维数组，第一组
     *                          0：FieldService；1：EquipmentContent；2：ArtificialService；3：SportService；4：ActivityService；
     *                          第二组表示服务ID
     */
    void doPostDemand_Detail(int demandTableID, int[][] serviceID);

    /**
     *  判断用户是否填写过该调查表（如果查找不到则为没填写过）。
     *
     * @param disabilityIdentity        残疾人证号
     * @param demandTableID         调查表ID
     * @return          true表示已填写，false表示没填写过
     */
    Boolean JudgeExitMsg(String disabilityIdentity, int demandTableID);

    /**
     * 查询Demand_Votes最后一个自增ID
     * @return 自增ID
     */
    Integer doGetDemandVotesLastInsertID();

    /**
     * 获取五种调查表中对应残疾人投票的服务
     * @param DisabilityIdentity
     * @param DemandTableID
     * @return List<ValueObject>  结果列表
     */
    Map<String,Integer[]> SearchVotedDT(Integer DisabilityIdentity, Integer DemandTableID);
}
