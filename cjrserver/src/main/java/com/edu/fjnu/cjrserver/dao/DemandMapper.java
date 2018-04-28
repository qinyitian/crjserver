package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.*;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3 0003.
 */
public interface DemandMapper {
    /**
     * 查询需求调查表列表
     * @return 需求调查表列表
     */
    List<DemandTable> findDemandTable();
    /**
     * 根据需求调查表ID查询活动服务列表
     * @param DemandTableID 需求调查表ID
     * @return 活动服务列表
     */
    List<Activity> findActivityByDemandTableID(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询人工服务列表
     * @param DemandTableID 需求调查表ID
     * @return 人工服务列表
     */
    List<Artificial> findArtificialByDemandTableID(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询体育器材列表
     * @param DemandTableID 需求调查表ID
     * @return 体育器材列表
     */
    List<EquipmentContent> findEquipmentContentByDemandTableID(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询场地服务列表
     * @param DemandTableID 需求调查表ID
     * @return 场地服务列表
     */
    List<FieldServer> findFieldServerByDemandTableID(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询体育服务列表
     * @param DemandTableID 需求调查表ID
     * @return 体育服务列表
     */
    List<Sport> findSportByDemandTableID(Integer DemandTableID);
}
