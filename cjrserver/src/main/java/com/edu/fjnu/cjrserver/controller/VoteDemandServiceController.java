package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.DemandTable;
import com.edu.fjnu.cjrserver.model.DemandVotes;
import com.edu.fjnu.cjrserver.model.DisabledUser;
import com.edu.fjnu.cjrserver.model.ResultData;
import com.edu.fjnu.cjrserver.service.VoteDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * VoteDemandServiceController 提交个人需求用例Controller设计实现
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
@RestController
@RequestMapping("/Demand/Votes")
public class VoteDemandServiceController {

    /* 提交个人需求Service */
    @Autowired
    VoteDemandService voteDemandService;

    /**
     * 记录用户投票的服务条目。
     *
     * @param DisabledIdentify     使用主体残疾人的VotesID
     * @param DemandTableID       调查表的DemandTableID
     * @param ServiceID        服务ID数组，二维数组，第一组
     *                          0：FieldService；1：EquipmentContent；2：ArtificialService；3：SportService；4：ActivityService；
     *                          第二组表示服务ID
     * @return  resultData          存储操作结果信息，不论成功失败都会有值，比如成功返回“服务记录成功！”，失败返回“添加失败”
     */
    @RequestMapping(value = "/RecordVote_Detail")
    public ResultData<Object> recordDemandVote_Detail(@RequestParam(value = "DisabledIdentify") String DisabledIdentify,
                                                      @RequestParam(value = "DemandTableID") Integer DemandTableID,
                                                      @RequestParam(value = "ServiceID") int[][] ServiceID){

        ResultData<Object> resultData = new ResultData<Object>();
        Integer VotesID = 0;
        if (DisabledIdentify != null && DemandTableID != null) {
            DemandVotes demandVotes = new DemandVotes();
            DisabledUser disabledUser = new DisabledUser();
            disabledUser.setDisabilityIdentity(DisabledIdentify);
            DemandTable demandTable = new DemandTable();
            demandTable.setDemandTableID(DemandTableID);
            demandVotes.setDisabledUser(disabledUser);
            demandVotes.setDemandTable(demandTable);
            voteDemandService.doPostDemandVote(demandVotes);
            VotesID = voteDemandService.doGetDemandVotesLastInsertID();
        } else {
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }
        if (VotesID != 0) {
            if (ServiceID.length == 5) {
                voteDemandService.doPostDemandVote_Detail(VotesID,ServiceID);
            } else {
                resultData.setErrorResult(0,false,"ServiceID数组是不合法的数组，添加失败");
                return resultData;
            }
            resultData.setRightResult("服务记录成功！");
            System.out.println("服务记录成功！");
            return resultData;
        } else {
            resultData.setErrorResult(0,false,"VotesID参数错误，添加失败");
            return resultData;
        }
    }

    /**
     *  更新调查表的投票记录。
     *
     * @param DemandTableID         调查表ID
     * @param ServiceID        服务ID数组，二维数组，第一组
     *                          0：FieldService；1：EquipmentContent；2：ArtificialService；3：SportService；4：ActivityService；
     *                          第二组表示服务ID
     * @return  resultData          存储操作结果信息，不论成功失败都会有值，比如成功返回“投票更新成功！”，失败返回“添加失败”
     */
    @RequestMapping(value = "/updateDemand_Detail")
    public ResultData<Object> updateDemand_Detail(@RequestParam(value = "DemandTableID") Integer DemandTableID,
                                                  @RequestParam(value = "ServiceID") int[][] ServiceID){

        ResultData<Object> resultData = new ResultData<Object>();
        if (DemandTableID != null) {
            if (ServiceID.length == 5) {
                voteDemandService.doPostDemand_Detail(DemandTableID,ServiceID);
            } else {
                resultData.setErrorResult(0,false,"ServiceID数组是不合法的数组，添加失败");
                return resultData;
            }
            resultData.setRightResult("投票更新成功！");
            System.out.println("投票更新成功！");
            return resultData;
        } else {
            resultData.setErrorResult(0,false,"DemandTableID参数错误，添加失败");
            return resultData;
        }
    }

    /**
     *  判断用户是否填写过该调查表（如果查找不到则为没填写过）。
     *
     * @param DisabilityIdentity        残疾人证号
     * @param DemandTableID         调查表ID
     * @return          true表示已填写，false表示没填写过
     */
    @RequestMapping(value = "/JudgeIsVoted")
    public Boolean JudgeExitMsg(@RequestParam(value = "DisabilityIdentity") String DisabilityIdentity,
                               @RequestParam(value = "DemandTableID") Integer DemandTableID) {

        if (DisabilityIdentity != null && DemandTableID != null) {
            return voteDemandService.JudgeExitMsg(DisabilityIdentity,DemandTableID);
        } else {
            return false;
        }
    }

    /**
     * 获取残疾人投票过的需求表
     * @param DisabilityIdentity
     * @param DemandTableID
     * @return ResultData<Map> 查询结果
     */
    @RequestMapping(value = "/SearchVotedDemandTable")
    public ResultData<Map<String,Integer[]>> SearchVotedDT(@RequestParam(value = "DisabilityIdentity") Integer DisabilityIdentity,
                                                           @RequestParam(value = "DemandTableID" ) Integer DemandTableID) {
        ResultData<Map<String,Integer[]> > resultData = new ResultData<Map<String,Integer[]> >();
        if (DemandTableID == null) {
            resultData.setErrorResult(0,false,"DemandTableID参数错误，添加失败");

        } else if(DisabilityIdentity == null) {
            resultData.setErrorResult(0,false,"DisabilityIdentity参数错误，添加失败");
        } else {
            resultData.setData(voteDemandService.SearchVotedDT(DisabilityIdentity,DemandTableID));
            resultData.setRightResult("查询投票服务成功!");
        }
        return resultData;

    }

}
