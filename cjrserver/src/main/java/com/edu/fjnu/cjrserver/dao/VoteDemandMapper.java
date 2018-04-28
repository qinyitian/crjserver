package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.DemandVotes;

/**
 * VoteDemandMapper 提交个人需求用例Mapper设计API
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public interface VoteDemandMapper {

    /**
     * 记录用户成功投票了某一期调查表。
     *
     * @param demandVotes       使用主体残疾人的身份证DisabledIdentify以及调查表的DemandTableID
     */
    void addDemandVote(DemandVotes demandVotes);

    /**
     * 判断该使用主体用户是否投选了某期调查表
     * 如果查找不到则为没填写过
     *
     * @param disabledIdentify          使用主体残疾人的身份证DisabledIdentify
     * @param demandTableID         调查表的DemandTableID
     * @return  DemandVotes对象
     */
    DemandVotes judgeExitMsg(String disabledIdentify, int demandTableID);

    /**
     * 记录用户投票的人工服务条目。
     *
     * @param serviceID       投选的服务条目ID，一个或者俩个，至多俩个的int数组
     * @param VotesID       需求投票的VotesID
     */
    void addDemandVote_ArtificialService_Detail(int serviceID, int VotesID);

    /**
     * 记录用户投票的体育赛事服务条目。
     *
     * @param serviceID       投选的服务条目ID，一个或者俩个，至多俩个的int数组
     * @param VotesID       需求投票的VotesID
     */
    void addDemandVote_SportService_Detail(int serviceID, int VotesID);

    /**
     * 记录用户投票的场地服务条目。
     *
     * @param serviceID       投选的服务条目ID，一个或者俩个，至多俩个的int数组
     * @param VotesID       需求投票的VotesID
     */
    void addDemandVote_FieldService_Detail(int serviceID, int VotesID);

    /**
     * 记录用户投票的器材服务条目。
     *
     * @param serviceID       投选的服务条目ID，一个或者俩个，至多俩个的int数组
     * @param VotesID       需求投票的VotesID
     */
    void addDemandVote_EquipmentContent_Detail(int serviceID, int VotesID);

    /**
     * 记录用户投票的活动服务条目。
     *
     * @param serviceID       投选的服务条目ID，一个或者俩个，至多俩个的int数组
     * @param VotesID       需求投票的VotesID
     */
    void addDemandVote_ActivityService_Detail(int serviceID, int VotesID);

    /**
     * 根据服务ID获取调查表的场地服务条目投票数量+1。
     *
     * @param serviceID       投选的服务条目ID
     * @param demandTableID         投选的调查表ID
     */
    void updateDemand_FieldService_Detail(int serviceID, int demandTableID);

    /**
     * 根据服务ID获取调查表的器材服务条目投票数量+1。
     *
     * @param serviceID       投选的服务条目ID
     * @param demandTableID         投选的调查表ID
     */
    void updateDemand_EquipmentContent_Detail(int serviceID, int demandTableID);

    /**
     * 根据服务ID获取调查表的人工服务条目投票数量+1。
     *
     * @param serviceID       投选的服务条目ID
     * @param demandTableID         投选的调查表ID
     */
    void updateDemand_ArtificialService_Detail(int serviceID, int demandTableID);

    /**
     * 根据服务ID获取调查表的体育赛事服务条目投票数量+1。
     *
     * @param serviceID       投选的服务条目ID
     * @param demandTableID         投选的调查表ID
     */
    void updateDemand_SportService_Detail(int serviceID, int demandTableID);

    /**
     * 根据服务ID获取调查表的活动服务条目投票数量+1。
     *
     * @param serviceID       投选的服务条目ID
     * @param demandTableID         投选的调查表ID
     */
    void updateDemand_ActivityService_Detail(int serviceID, int demandTableID);

    /**
     * 查询Demand_Votes最后一个自增ID
     * @return 自增ID
     */
    Integer findDemandVotesLastInsertID();

    /**
     * 根据残疾人ID查询已经投票过的服务
     * @param DisabilityIdentity 残疾人ID
     * @param DemandTableID 调查表ID
     * @return 表中相应记录
     */
    Integer[] getdemandActivityVotes (Integer DisabilityIdentity, Integer DemandTableID);

    Integer[] getdemandArtificialv(Integer DisabilityIdentity, Integer DemandTableID);

    Integer[] getdemandEquipmentVotes(Integer DisabilityIdentity, Integer DemandTableID);

    Integer[] getdemandFiledVotes(Integer DisabilityIdentity, Integer DemandTableID);

    Integer[] getdemandSportVotes(Integer DisabilityIdentity, Integer DemandTableID);
}
