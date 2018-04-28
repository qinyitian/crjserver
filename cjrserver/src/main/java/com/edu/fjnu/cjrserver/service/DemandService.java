package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.*;

import java.util.List;

/**
 * @author lm
 *
 */
public interface DemandService {
	/**
	 * 根据需求调查表ID查询活动服务列表
	 * @param DemandTableID 需求调查表ID
	 * @return 活动服务列表
	 */
	List<Activity> getActivityDetail(Integer DemandTableID);
	/**
	 * 根据需求调查表ID查询人工服务列表
	 * @param DemandTableID 需求调查表ID
	 * @return 人工服务列表
	 */
	List<Artificial> getArtificialDetail(Integer DemandTableID);
	/**
	 * 根据需求调查表ID查询体育器材列表
	 * @param DemandTableID 需求调查表ID
	 * @return 体育器材列表
	 */
	List<EquipmentContent> getEquipmentContentDetail(Integer DemandTableID);
	/**
	 * 根据需求调查表ID查询场地服务列表
	 * @param DemandTableID 需求调查表ID
	 * @return 场地服务列表
	 */
	List<FieldServer> getFieldServerDetail(Integer DemandTableID);
	/**
	 * 根据需求调查表ID查询体育服务列表
	 * @param DemandTableID 需求调查表ID
	 * @return 体育服务列表
	 */
	List<Sport> getSportDetail(Integer DemandTableID);

	/**
	 * 获取需求调查表列表
	 * @return 需求调查表ID
	 */
	List<DemandTable> doGetDemandTable();
//    List<Activity> doGetActivityServiceByName(Integer pageNumber, Integer pageSize, String ActivityName);


}
