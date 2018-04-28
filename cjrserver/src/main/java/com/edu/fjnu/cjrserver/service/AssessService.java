package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.DisabledAssessDemand;
import com.edu.fjnu.cjrserver.model.DisabledAssessServer;
import com.edu.fjnu.cjrserver.model.DisabledAssessTender;

/**
 * AssessService 评价已完成服务用例Service设计API
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public interface AssessService {

    /**
     * 根据服务表名与服务ID查询是否有这个服务存在
     *
     * @param ServerID          服务ID
     * @param ServerTableName           服务表名称
     * @return
     */
    boolean doGetServerByID(int ServerID, String ServerTableName);

    //以下俩个方法对应的model不完整，Mapper未实现，功能暂时无法实现
    //boolean doGetDemandIDByID(int DemandTableID);
    //boolean doGetTenderPlanIDByID(int TenderID);

    /**
     * 插入残疾人服务评价信息到DisabledAssessServer表并且更新服务的评价等级和评价数量
     *
     * @param disabledAssessServer          残疾人对服务的评价信息
     */
    void doPostDisabledAssessServer(DisabledAssessServer disabledAssessServer);

    /**
     * 插入残疾人需求表评价信息到DisabledAssessDemand表并且更新需求表的评价等级和数量
     *
     * @param disabledAssessDemand          残疾人对需求目录的评价信息
     */
    void doPostDisabledAssessDemand(DisabledAssessDemand disabledAssessDemand);

    /**
     * 插入残疾人服务招标评价信息到DisabledAssessTender表并且更新招标表的评价等级和数量
     *
     * @param disabledAssessTender          残疾人对招标计划的评价信息
     */
    void doPostDisabledAssessTender(DisabledAssessTender disabledAssessTender);

}
