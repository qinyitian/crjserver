package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.*;
import com.edu.fjnu.cjrserver.service.AssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AssessServiceController 评价已完成服务用例Controller设计实现
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
@RestController
@RequestMapping("/Assess")
public class AssessServiceController {

    /* 评价已完成服务Service */
    @Autowired
    AssessService assessService;

    /**
     * 插入残疾人服务评价信息到DisabledAssessServer表并且更新服务的评价等级和评价数量
     *
     * @param serverID          服务ID
     * @param serverTableName           服务表名称
     * @param disabilityId          残疾人号码
     * @param grade             评价等级
     * @return          存储操作结果信息，不论成功失败都会有值，比如成功返回“添加成功！对应的服务评价等级和数量更新成功！”，失败返回“填写信息缺少，添加失败”
     */
    @RequestMapping(value = "/AssessServer")
    public ResultData<Object> savePostDisabledAssessServer(@RequestParam(value = "ServerID") Integer serverID,
                                                           @RequestParam(value = "ServerTableName") String serverTableName,
                                                           @RequestParam(value = "DisabilityId") Integer disabilityId,
                                                           @RequestParam(value = "Grade") Double grade) {

        ResultData<Object> resultData = new ResultData<Object>();
        if (serverID != null && serverTableName != null && disabilityId != null && grade != null) {
//            DisabledAssessServer disabledAssessServer = new DisabledAssessServer();
//            DisabledUser disabledUser = new DisabledUser();
//            disabledUser.setDisabilityId(DisabilityId);
//            disabledAssessServer.setGrade(Grade);
//            disabledAssessServer.setServerTableName(ServerTableName);
//            disabledAssessServer.setServerID(ServerID);
//            disabledAssessServer.setDisabledUser(disabledUser);
//            assessService.doPostDisabledAssessServer(disabledAssessServer);
//            resultData.setRightResult(assessService.toString() + "添加成功！对应的服务评价等级和数量更新成功！");
//            System.out.println(assessService.toString() + "添加成功！对应的服务评价等级和数量更新成功！");
            return resultData;
        } else {
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }
    }

    /**
     * 插入残疾人需求表评价信息到DisabledAssessDemand表并且更新需求表的评价等级和数量
     *
     * @param demandTableID             需求目录表ID
     * @param disabilityId              残疾人号码
     * @param grade             评价等级
     * @return          存储操作结果信息，不论成功失败都会有值，比如成功返回“添加成功！对应的需求表评价等级和数量更新成功！”，失败返回“填写信息缺少，添加失败”
     */
    @RequestMapping(value = "/AssessDemand")
    public ResultData<Object> savePostDisabledAssessDemand(@RequestParam(value = "DemandTableID") Integer demandTableID,
                                                           @RequestParam(value = "DisabilityId") Integer disabilityId,
                                                           @RequestParam(value = "Grade") Double grade) {

        ResultData<Object> resultData = new ResultData<Object>();
        if (demandTableID != null && disabilityId != null && grade != null) {
            DisabledAssessDemand disabledAssessDemand = new DisabledAssessDemand();
            DemandTable demandTable = new DemandTable();
            demandTable.setDemandTableID(demandTableID);
            DisabledUser disabledUser = new DisabledUser();
            disabledUser.setDisabilityId(disabilityId);
            disabledAssessDemand.setDisabledUser(disabledUser);
            disabledAssessDemand.setDemandTable(demandTable);
            disabledAssessDemand.setGrade(grade);
            assessService.doPostDisabledAssessDemand(disabledAssessDemand);
            resultData.setRightResult(assessService.toString() + "添加成功！对应的需求表评价等级和数量更新成功！");
            System.out.println(assessService.toString() + "添加成功！对应的需求表评价等级和数量更新成功！");
            return resultData;
        } else {
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }
    }

    /**
     * 插入残疾人服务招标评价信息到DisabledAssessTender表并且更新招标表的评价等级和数量
     *
     * @param tenderID             招标ID
     * @param disabilityId              残疾人号码
     * @param grade             评价等级
     * @return          存储操作结果信息，不论成功失败都会有值，比如成功返回“添加成功！对应的招标表评价等级和数量更新成功！”，失败返回“填写信息缺少，添加失败”
     */
    @RequestMapping(value = "/AssessTender")
    public ResultData<Object> savePostDisabledAssessTender(@RequestParam(value = "TenderID") Integer tenderID,
                                                           @RequestParam(value = "DisabilityId") Integer disabilityId,
                                                           @RequestParam(value = "Grade") Double grade) {

        ResultData<Object> resultData = new ResultData<Object>();
        if (tenderID != null && disabilityId != null && grade != null) {
            DisabledAssessTender disabledAssessTender = new DisabledAssessTender();
            DisabledUser disabledUser = new DisabledUser();
            disabledUser.setDisabilityId(disabilityId);
            disabledAssessTender.setTenderID(tenderID);
            disabledAssessTender.setDisabledUser(disabledUser);
            disabledAssessTender.setGrade(grade);
            assessService.doPostDisabledAssessTender(disabledAssessTender);
            resultData.setRightResult(assessService.toString() + "添加成功！对应的招标表评价等级和数量更新成功！");
            System.out.println(assessService.toString() + "添加成功！对应的招标表评价等级和数量更新成功！");
            return resultData;
        } else {
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }
    }

}
