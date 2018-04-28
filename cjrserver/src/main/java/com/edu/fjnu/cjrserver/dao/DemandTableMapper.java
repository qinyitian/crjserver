package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.*;
import com.edu.fjnu.cjrserver.service.ActivityService;
import com.edu.fjnu.cjrserver.service.ArtificialService;

import java.util.List;

/**
 * 发布需求调查表
 */
public interface DemandTableMapper {
    /**
     *添加需求调查表
     * @param demandTable 需求倒插表
     */
    void addDemandTable(DemandTable demandTable);

    /**
     *添加需求-活动服务详细表
     * @param demandActivityServiceDetail 需求-活动服务详细表
     */
    void addDemandActivityServiceDetail(DemandActivityServiceDetail demandActivityServiceDetail);

    /**
     *添加需求-人工服务详细表
     * @param demandArtificialServiceDetail 需求-人工服务详细表
     */
    void addDemandArtificialServiceDetail(DemandArtificialServiceDetail demandArtificialServiceDetail);

    /**
     *添加需求-器材服务详细表
     * @param demandEquipmentContentDetail 需求-器材务详细表
     */
    void addDemandEquipmentContentDetail(DemandEquipmentContentDetail demandEquipmentContentDetail);

    /**
     *添加需求-场地服务详细表
     * @param demandFieldServiceDetail 需求-场地服务详细表
     */
    void addDemandFieldServiceDetail(DemandFieldServiceDetail demandFieldServiceDetail);

    /**
     *添加需求-赛事服务详细表
     * @param demandSportServiceDetail 需求-赛事服务详细表
     */
    void addDemandSportServiceDetail(DemandSportServiceDetail demandSportServiceDetail);

    /**
     * 获取需求调查ID
     * @return
     */
    Integer getLastId();

    /**
     * 删除需求调查表
     * @param DemandTable 需求调查表ID
     */
    void delDemandTable(Integer DemandTable);

    /**
     * 修改需求调查表
     * @param demandTable 需求调查表ID
     */
    void updateDemandTable(DemandTable demandTable);

    /**
     * 删除需求-活动服务详细表
     * @param DemandTable 需求调查表ID
     */
    void delDemandActivityServiceDetail(Integer DemandTable);

    /**
     *删除需求-人工服务详细表
     * @param DemandTable 需求调查表ID
     */
    void delDemandArtificialServiceDetail(Integer DemandTable);

    /**
     *删除需求-器材服务详细表
     * @param DemandTable 需求调查表ID
     */
    void delDemandEquipmentContentDetail(Integer DemandTable);

    /**
     *删除需求-场地服务详细表
     * @param DemandTable 需求调查表ID
     */
    void delDemandFieldServiceDetail(Integer DemandTable);

    /**
     *删除需求-赛事服务详细表
     * @param DemandTable 需求调查表ID
     */
    void delDemandSportServiceDetail(Integer DemandTable);

    /**
     * 根据ID 获取-需求调查表
     * @param DemandTableID
     * @return
     */
    DemandTable findDemandTableByID(Integer DemandTableID);

    /**
     * 返回-所有需求调查表,不包括删除的
     * @return
     */
    List<DemandTable> getAllDemandTable();

    /**
     * 返回-所有需求调查表, 包括已删除的
      * @return
     */    
    List<DemandTable> getDemandTableList();

    /**
     * 根据需求调查表ID查询体育器材列表
     * @param DemandTableID 需求调查表ID
     * @return 体育器材列表
     */
    List<EquipmentContent> findDemandCatalogEquipmentContent(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询活动服务列表
     * @param DemandTableID 需求调查表ID
     * @return 活动服务列表
     */
    List<ActivityService> findDemandCatalogActivityService(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询人工服务列表
     * @param DemandTableID 需求调查表ID
     * @return 人工服务列表
     */
    List<ArtificialService> findDemandCatalogArtificialService(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询场地服务列表
     * @param DemandTableID 需求调查表ID
     * @return 场地服务列表
     */
    List<FieldServer> findDemandCatalogFieldService(Integer DemandTableID);
    /**
     * 根据需求调查表ID查询体育服务列表
     * @param DemandTableID 需求调查表ID
     * @return 体育服务列表
     */
    List<Sport> findDemandCatalogSportService(Integer DemandTableID);


}
