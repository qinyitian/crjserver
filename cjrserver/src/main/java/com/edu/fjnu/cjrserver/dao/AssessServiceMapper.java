package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.DisabledAssessDemand;
import com.edu.fjnu.cjrserver.model.DisabledAssessServer;
import com.edu.fjnu.cjrserver.model.DisabledAssessTender;

/**
 * AssessServiceMapper 评价已完成服务用例Mapper设计API
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public interface AssessServiceMapper {

    /**
     * 插入残疾人服务评价信息到DisabledAssessServer表
     *
     * @param disabledAssessServer          残疾人对服务的评价信息
     */
    void insertDisabledAssessServer(DisabledAssessServer disabledAssessServer);

    /**
     * 插入残疾人需求表评价信息到DisabledAssessDemand表
     *
     * @param disabledAssessDemand          残疾人对需求目录的评价信息
     */
    void insertDisabledAssessDemand(DisabledAssessDemand disabledAssessDemand);

    /**
     * 插入残疾人服务招标评价信息到DisabledAssessTender表
     *
     * @param disabledAssessTender          残疾人对招标计划的评价信息
     */
    void insertDisabledAssessTender(DisabledAssessTender disabledAssessTender);

    /**
     * 更新服务的评价等级和评价数量
     *
     * @param ServiceID         服务的ID
     * @param grade         新的评价等级
     */
    void updateActivity_service(int ServiceID, double grade);
    void updateArtificial_service(int ServiceID, double grade);
    void updateEquipment_content(int ServiceID, double grade);
    void updateField_service(int ServiceID, double grade);
    void updateSport_service(int ServiceID, double grade);

    /**
     * 更新需求表的评价等级和数量
     *
     * @param DemandTable_ID            需求目录ID
     * @param grade             新的评价等级
     */
    void updateDemand_table(int DemandTable_ID, double grade);

    /**
     * 更新招标表的评价等级和数量
     *
     * @param TenderPlan_ID             招标ID
     * @param grade             新的评价等级
     */
    void updateTender_plan(int TenderPlan_ID, double grade);


}
