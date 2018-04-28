package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.*;
import com.sun.deploy.security.WinDeployNTLMAuthCallback;

import java.util.List;

/**
 * 招标计划
 * @author lm
 *
 */
public interface TenderService {
	/**
	 * 根据招标计划ID查询参与投标，竞标企业信息
	 * @param TenderPlanID 招标计划ID
	 * @param State 状态为0 表示参与投标，状态为1表示参与竞标
	 * @return
	 */
	List<CompanyInfo> getTenderCompanyInfo(Integer TenderPlanID,Integer State);

	/**
	 * 根据招标计划ID查询中标企业信息
	 * @param TenderPlanId 招标计划ID
	 * @return 中标企业信息
	 */
	WinBidCompany getWinBidCompany(Integer TenderPlanId);

	/**
	 * 设置投标成功企业状态，使企业能参与竞标
	 * @param tenderPlanId 招标计划ID
	 * @param CheckCompanyID 投标企业ID
	 */
	void setCompanyStatus(Integer tenderPlanId,Integer[] CheckCompanyID);

	/**
	 * 设置中标企业信息
	 * @param TenderPlan 招标计划ID
	 * @param CompanyName 中标企业名称
	 */
	void setWinBidCompany(Integer TenderPlan,String CompanyName);

	/**
	 * 添加新的招标计划
	 *
	 * @param tenderPlan        调查表类
	 */
	void doPostTenderPlan(TenderPlan tenderPlan);

	/**
	 * 显示所有招标文件信息
	 *
	 * @return          招标文件的List
	 */
	List<TenderPlan> doGetAllTenderPlan();

	/**
	 * 根据调查表ID,查询新增招标计划
	 *
	 * @param tenderPlanID          调查表ID
	 * @return          调查表类
	 */
	TenderPlan doGetTenderPlanByID(Integer tenderPlanID);

	/**
	 * 修改新增招标计划
	 *
	 * @param tenderPlan        调查表类
	 */
	void doPostUpdateTenderPlanByID(TenderPlan tenderPlan);

	/**
	 * 企业参与竞标，插入招标详表记录
	 *
	 * @param tenderPlanID          调查表ID
	 * @param companyName           公司名称
	 */
	void doPostTenderDetail(Integer tenderPlanID, String companyName);

	/**
	 * 根据ID查询企业
	 *
	 * @param CompanyID 企业ID
	 * @return 企业
	 */
	Company doGetCompanyByID(Integer CompanyID);
}
