package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.DemandTable;
import com.edu.fjnu.cjrserver.model.EquipmentContent;
import com.edu.fjnu.cjrserver.model.FieldServer;
import com.edu.fjnu.cjrserver.model.Sport;

import java.util.List;

/**
 * 发布需求调查表
 */
public interface DemandTableService {
    /**
     * 发布需求调查表
     * @param demandTable 需求调查表
     * @param filed 场地服务ID
     * @param activity 活动服务ID
     * @param artificial 人工服务ID
     * @param equip 体育器材ID
     * @param sport 体育服务ID
     */
    void doAddDemandTableAndDetail(DemandTable demandTable, Integer[] filed, Integer[] activity, Integer[] artificial, Integer[] equip, Integer[] sport);

    /**
     * 根据ID删除需求调查
     * @param DemandTableID 需求调查表ID
     */
    void doDelDemandTable(Integer DemandTableID);

    /**
     * 根据ID修改需求调查表
     * @param demandTable 需求调查表ID
     */
    void doUpdateDemandTable(DemandTable demandTable);
    /**
     * 根据ID查询需求调查表
     * @param DemandTableID ID
     * @return 需求调查表
     */
    DemandTable doGetDemandTableByID(Integer DemandTableID);

    /**
     * 获取所有需求调查表，不包括删除的
     * @return
     */
    List<DemandTable> doGetAllDemandTable();

    /**
     * 获取所有的包括删除的
     * @return
     */
    List<DemandTable> getDemandTableList();
    /**
     * 根据需求调查表ID查询体育器材列表
     * @param DemandTableID 需求调查表ID
     * @return 体育器材列表
     */
    List<EquipmentContent> doGetEquipmentContent(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询活动服务列表
     * @param DemandTableID 需求调查表ID
     * @return 活动服务列表
     */
    List<ActivityService> doGetActivityService(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询人工服务列表
     * @param DemandTableID 需求调查表ID
     * @return 人工服务列表
     */
    List<ArtificialService> doGetArtificialService(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询场地服务列表
     * @param DemandTableID 需求调查表ID
     * @return 场地服务列表
     */
    List<FieldServer> doGetFieldService(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询体育服务列表
     * @param DemandTableID 需求调查表ID
     * @return 体育服务列表
     */
    List<Sport> doGetSportService(Integer DemandTableID);


}
