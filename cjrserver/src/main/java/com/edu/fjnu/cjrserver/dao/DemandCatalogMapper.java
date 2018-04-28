package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.*;
import com.edu.fjnu.cjrserver.service.ActivityService;
import com.edu.fjnu.cjrserver.service.ArtificialService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 发布需求目录
 * Created by Administrator on 2018/1/3 0003.
 */
public interface DemandCatalogMapper {
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
    Integer[] findEquipmentContentByDemandTableID(Integer DemandTableID);
    Integer[] findActivityServiceByDemandTableID(Integer DemandTableID);
    Integer[] findArtificialServiceByDemandTableID(Integer DemandTableID);
    Integer[] findFieldServiceByDemandTableID(Integer DemandTableID);
    Integer[] findSportServiceByDemandTableID(Integer DemandTableID);
    void delEquipmentContentByServerID(@Param(value = "DemandTableID") Integer DemandTableID,@Param(value = "ServerID") Integer[] ServerID);
    void delActivityServiceByServerID(@Param(value = "DemandTableID") Integer DemandTableID,@Param(value = "ServerID") Integer[] ServerID);
    void delArtificialServiceByServerID(@Param(value = "DemandTableID") Integer DemandTableID,@Param(value = "ServerID") Integer[] ServerID);
    void delFieldServiceByServerID(@Param(value = "DemandTableID") Integer DemandTableID,@Param(value = "ServerID") Integer[] ServerID);
    void delSportServiceByServerID(@Param(value = "DemandTableID") Integer DemandTableID,@Param(value = "ServerID") Integer[] ServerID);

    /**
     * 转化成需求目录
     * @param DemandTableID             需求调查表ID
     * @param DemandTableMame           需求目录名称
     */
    void changeToDemandDirectory(Integer DemandTableID, String DemandTableMame,String currentTime);

    /**
     * 获取所有需求目录，不包含已删除的
     * @return
     */
    List<DemandTable> getAllDemandCatalog();

    /**
     * 获取 所有需求目录，包含已删除的
     * @return
     */
    List<DemandTable> getDemandTableList();
    /**
     * 根据ID 需求目录
     * @param DemandTableID
     * @return
     */
    DemandTable getDemandCatalogByID(Integer DemandTableID);

    /**
     * 修改需求目录
     * @param demandTable
     */
    void updateDemandCatalog(DemandTable demandTable);

    /**
     * 删除需求目录
     * @param demandTableID
     */
    void delDemandCatalog(Integer demandTableID);

    /**
     * 获取最新的需求目录
     * @return
     */
    DemandTable getLatestDemand();

    /**
     * 获取最新的前几个需求目录，返回map数组，其中key为需求目录ID，value为需求目录发布时间
     * @param state 默认为1，表示查询的是需求目录
     * @param qty 默认为3表示查询几条记录
     * @return 返回map数组
     */
    List<Map> getNewDemandCatalog(Integer state,Integer qty);

}
