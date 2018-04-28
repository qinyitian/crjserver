package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.*;

import java.util.List;
import java.util.Map;

/**
 * 需求目录
 */
public interface DemandCatalogService {
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
	Integer[] doGetEquipmentContentByDemandTableID(Integer DemandTableID);
	Integer[] doGetActivityServiceByDemandTableID(Integer DemandTableID);
	Integer[] doGetArtificialServiceByDemandTableID(Integer DemandTableID);
	Integer[] doGetFieldServiceByDemandTableID(Integer DemandTableID);
	Integer[] doGetSportServiceByDemandTableID(Integer DemandTableID);
	void doPostEquipmentContentDetail(Integer DemandTableID, Integer[] allID, String[] needID);
	void doPostActivityServiceDetail(Integer DemandTableID, Integer[] allID, String[] needID);
	void doPostArtificialServiceDetail(Integer DemandTableID, Integer[] allID, String[] needID);
	void doPostFieldServiceDetail(Integer DemandTableID, Integer[] allID, String[] needID);
	void doPostSportServiceDetail(Integer DemandTableID, Integer[] allID, String[] needID);
	/**
	 * 转化成需求目录
	 * @param DemandTableID             需求调查表ID
	 * @param DemandTableMame           需求目录名称
	 */
	void changeToDemandDirectory(Integer DemandTableID, String DemandTableMame,String currentTime);

	/**
	 * 获取所有需求目录，不包含删除的
	 * @return
	 */
	List<DemandTable> doGetAllDemandCatalog();

	/**
	 * 获取 所有需求目录，包含已删除的
	 * @return
	 */
	List<DemandTable> getDemandTableList();
	/**
	 * 根据ID 获取需求目录
	 * @param DemandTableID
	 * @return
	 */
	DemandTable doGetDemandCatalogByID(Integer DemandTableID);

	/**
	 * 修改需求目录
	 * @param demandTable
	 */
	void doUpdateDemandCatalog(DemandTable demandTable);

	/**
	 * 删除需求目录
	 * @param demandTableID
	 */
	void doDelDemandCatalog(Integer demandTableID);

	/**
	 * 获取最新需求目录
	 * @return
	 */
	DemandTable getLatestDemand();

	/**
	 * 获取最新的前几个需求目录，返回map数组，其中key为需求目录ID，value为需求目录发布时间
	 * @param state 默认为1，表示查询的是需求目录
	 * @param qty 默认为3表示查询几条记录
	 * @return 返回map数组
	 */
	List<Map> doGetNewDemandCatalog(Integer state,Integer qty);
}
