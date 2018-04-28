package com.edu.fjnu.cjrserver.service;


import com.edu.fjnu.cjrserver.dao.*;
import com.edu.fjnu.cjrserver.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AssessServiceImpl 评价已完成服务用例Service设计实现
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
@Service("AssessService")
public class AssessServiceImpl implements AssessService{

    /* 调用评价已完成服务用例的Mapper */
    @Autowired
    AssessServiceMapper assessServiceMapper;

    /* 调用已实现的服务Mapper，用与实现服务查询 */
    @Autowired
    ArtificialServiceMapper artificialServiceMapper;
    ActivityServiceMapper activityServiceMapper;
    EquipmentContentMapper equipmentContentMapper;
    FieldServiceMapper fieldServiceMapper;
    SportServiceMapper sportServiceMapper;

    /**
     * 根据服务表名与服务ID查询是否有这个服务存在
     *
     * @param ServerID          服务ID
     * @param ServerTableName           服务表名称
     * @return
     */
    public boolean doGetServerByID(int ServerID, String ServerTableName) {
        //根据ServerTableName判读属于哪张服务表
        if (ServerTableName.contains("人工")) {
            Artificial artificial = new Artificial();
            return (artificial = artificialServiceMapper.getArtificialServiceByID(ServerID)) != null?true:false;
        } else if (ServerTableName.contains("活动")) {
            Activity activity = new Activity();
            return (activity = activityServiceMapper.getActivityServiceByID(ServerID)) != null?true:false;
        } else if (ServerTableName.contains("器材")) {
            EquipmentContent equipmentContent = new EquipmentContent();
            return (equipmentContent = equipmentContentMapper.getEquipmentContentById(ServerID)) != null?true:false;
        } else if (ServerTableName.contains("场地")) {
            FieldServer fieldServer = new FieldServer();
            return (fieldServer = fieldServiceMapper.getFiledServiceByID(ServerID)) != null?true:false;
        } else if (ServerTableName.contains("赛事")) {
            Sport sport = new Sport();
            return (sport = sportServiceMapper.getSportServiceByID(ServerID)) != null?true:false;
        } else {
            return false;
        }
    }

    /**
     * 插入残疾人服务评价信息到DisabledAssessServer表并且更新服务的评价等级和评价数量
     *
     * @param disabledAssessServer          残疾人对服务的评价信息
     */
    public void doPostDisabledAssessServer(DisabledAssessServer disabledAssessServer) {
        double grade = disabledAssessServer.getGrade();
        String ServerTableName = disabledAssessServer.getServerTableName();
        int ServiceID = disabledAssessServer.getServerID();
        if (ServerTableName.contains("人工")) {
            assessServiceMapper.updateArtificial_service(ServiceID, grade);
        } else if (ServerTableName.contains("活动")) {
            assessServiceMapper.updateActivity_service(ServiceID, grade);
        } else if (ServerTableName.contains("器材")) {
            assessServiceMapper.updateEquipment_content(ServiceID, grade);
        } else if (ServerTableName.contains("场地")) {
            assessServiceMapper.updateEquipment_content(ServiceID, grade);
        } else if (ServerTableName.contains("赛事")) {
            assessServiceMapper.updateSport_service(ServiceID, grade);
        }
        assessServiceMapper.insertDisabledAssessServer(disabledAssessServer);
    }

    /**
     * 插入残疾人需求表评价信息到DisabledAssessDemand表并且更新需求表的评价等级和数量
     *
     * @param disabledAssessDemand          残疾人对需求目录的评价信息
     */
    public void doPostDisabledAssessDemand(DisabledAssessDemand disabledAssessDemand) {
        double grade = disabledAssessDemand.getGrade();
        int DemandTable_ID = disabledAssessDemand.getDemandTable().getDemandTableID();
        assessServiceMapper.updateDemand_table(DemandTable_ID, grade);
        assessServiceMapper.insertDisabledAssessDemand(disabledAssessDemand);
    }

    /**
     * 插入残疾人服务招标评价信息到DisabledAssessTender表并且更新招标表的评价等级和数量
     *
     * @param disabledAssessTender          残疾人对招标计划的评价信息
     */
    public void doPostDisabledAssessTender(DisabledAssessTender disabledAssessTender) {
        double grade = disabledAssessTender.getGrade();
        int Tender_ID = disabledAssessTender.getTenderID();
        assessServiceMapper.updateTender_plan(Tender_ID, grade);
        assessServiceMapper.insertDisabledAssessTender(disabledAssessTender);
    }

}
