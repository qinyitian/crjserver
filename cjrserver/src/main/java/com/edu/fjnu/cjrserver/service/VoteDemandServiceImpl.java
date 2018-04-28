package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.VoteDemandMapper;
import com.edu.fjnu.cjrserver.model.DemandVotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * VoteDemandServiceImpl 提交个人需求用例Service设计实现
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
@Service("VoteDemandService")
public class VoteDemandServiceImpl implements VoteDemandService {

    /* 提交个人需求用例的Mapper */
    @Autowired
    VoteDemandMapper voteDemandMapper;

    /**
     * 记录用户成功投票了某一期调查表。
     *
     * @param demandVotes       使用主体残疾人以及调查表
     */
    public void doPostDemandVote(DemandVotes demandVotes) {
        voteDemandMapper.addDemandVote(demandVotes);
    }

    /**
     * 记录用户投票的服务条目。
     *
     * @param votesID       使用主体残疾人的VotesID
     * @param serviceID        服务ID数组，二维数组，第一组
     *                          0：FieldService；1：EquipmentContent；2：ArtificialService；3：SportService；4：ActivityService；
     *                          第二组表示服务ID
     */
    public void doPostDemandVote_Detail(int votesID, int[][] serviceID) {
        int i;
        /* 批量记录投选的场地服务 */
        for (i = 0; i < serviceID[0].length; i++) {
            voteDemandMapper.addDemandVote_FieldService_Detail(serviceID[0][i],votesID);
        }
        /* 批量记录投选的器材服务 */
        for (i = 0; i < serviceID[1].length; i++) {
            voteDemandMapper.addDemandVote_EquipmentContent_Detail(serviceID[1][i],votesID);
        }
        /* 批量记录投选的人工服务 */
        for (i = 0; i < serviceID[2].length; i++) {
            voteDemandMapper.addDemandVote_ArtificialService_Detail(serviceID[2][i],votesID);
        }
        /* 批量记录投选的体育赛事服务 */
        for (i = 0; i < serviceID[3].length; i++) {
            voteDemandMapper.addDemandVote_SportService_Detail(serviceID[3][i],votesID);
        }
        /* 批量记录投选的活动服务 */
        for (i = 0; i < serviceID[4].length; i++) {
            voteDemandMapper.addDemandVote_ActivityService_Detail(serviceID[4][i],votesID);
        }
    }

    /**
     *  更新调查表的投票记录。
     *
     * @param demandTableID         调查表ID
     * @param serviceID        服务ID数组，二维数组，第一组
     *                          0：FieldService；1：EquipmentContent；2：ArtificialService；3：SportService；4：ActivityService；
     *                          第二组表示服务ID
     */
    public void doPostDemand_Detail(int demandTableID, int[][] serviceID) {
        int i;
        /* 批量更新投选的场地服务 */
        for (i = 0; i < serviceID[0].length; i++) {
            voteDemandMapper.updateDemand_FieldService_Detail(serviceID[0][i],demandTableID);
        }
        /* 批量更新投选的器材服务 */
        for (i = 0; i < serviceID[1].length; i++) {
            voteDemandMapper.updateDemand_EquipmentContent_Detail(serviceID[1][i],demandTableID);
        }
        /* 批量更新投选的人工服务 */
        for (i = 0; i < serviceID[2].length; i++) {
            voteDemandMapper.updateDemand_ArtificialService_Detail(serviceID[2][i],demandTableID);
        }
        /* 批量更新投选的体育赛事服务 */
        for (i = 0; i < serviceID[3].length; i++) {
            voteDemandMapper.updateDemand_SportService_Detail(serviceID[3][i],demandTableID);
        }
        /* 批量更新投选的活动服务 */
        for (i = 0; i < serviceID[4].length; i++) {
            voteDemandMapper.updateDemand_ActivityService_Detail(serviceID[4][i],demandTableID);
        }
    }

    /**
     *  判断用户是否填写过该调查表（如果查找不到则为没填写过）。
     *
     * @param disabilityIdentity        残疾人证号
     * @param demandTableID         调查表ID
     * @return          true表示已填写，false表示没填写过
     */
    public Boolean JudgeExitMsg(String disabilityIdentity, int demandTableID) {
        DemandVotes demandVotes = null;
        return ((demandVotes = voteDemandMapper.judgeExitMsg(disabilityIdentity, demandTableID)) != null)? true : false;
    }

    /**
     * 查询Demand_Votes最后一个自增ID
     * @return 自增ID
     */
    public Integer doGetDemandVotesLastInsertID() {
        return voteDemandMapper.findDemandVotesLastInsertID();
    }

    /**
     * 获取五种调查表中对应残疾人投票的服务
     * @param DisabilityIdentity
     * @param DemandTableID
     * @return List<ValueObject>  结果列表
     */
    public Map<String, Integer[]> SearchVotedDT(Integer DisabilityIdentity, Integer DemandTableID) {
        Map<String,Integer[]> map = new HashMap<String,Integer[]>();
        if(voteDemandMapper.getdemandActivityVotes(DisabilityIdentity,DemandTableID)!=null)
            map.put("Activity", voteDemandMapper.getdemandActivityVotes(DisabilityIdentity,DemandTableID));
        if(voteDemandMapper.getdemandArtificialv(DisabilityIdentity,DemandTableID)!=null)
            map.put("Artificial", voteDemandMapper.getdemandArtificialv(DisabilityIdentity,DemandTableID));
        if(voteDemandMapper.getdemandEquipmentVotes(DisabilityIdentity,DemandTableID)!=null)
            map.put("Equipment", voteDemandMapper.getdemandEquipmentVotes(DisabilityIdentity,DemandTableID));
        if(voteDemandMapper.getdemandFiledVotes(DisabilityIdentity,DemandTableID)!=null)
            map.put("Field", voteDemandMapper.getdemandFiledVotes(DisabilityIdentity,DemandTableID));
        if( voteDemandMapper.getdemandSportVotes(DisabilityIdentity,DemandTableID)!=null)
            map.put("Sport", voteDemandMapper.getdemandSportVotes(DisabilityIdentity,DemandTableID));
        return map;
    }

}
