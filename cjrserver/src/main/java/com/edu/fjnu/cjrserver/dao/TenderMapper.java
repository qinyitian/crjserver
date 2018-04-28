package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.*;

import java.util.List;

/**
 * 招标计划
 * Created by Administrator on 2018/1/3 0003.
 */
public interface TenderMapper {
    /**
     * 根据招标计划ID查询投标，竞标企业信息
     * @param TenderPlanID 招标计划ID
     * @param State 状态0位投标企业，状态1为竞标企业
     * @return 企业信息
     */
    List<CompanyInfo> findCompanyInfoInTender(Integer TenderPlanID,Integer State);

    /**
     * 查询中标企业信息
     * @param TenderPlanId 招标计划ID
     * @return 企业信息
     */
    WinBidCompany findWinBidCompany(Integer TenderPlanId);

    /**
     *  设置投标企业为竞标企业
     * @param tenderPlanId 招标计划ID
     * @param CheckCompanyID 投标企业ID
     */
    void setPassedCompany(Integer tenderPlanId,Integer CheckCompanyID);

    /**
     * 设置中标企业信息
     * @param tenderPlan 招标计划ID
     * @param companyName 企业名称
     */
    void insertWinBidCompany(Integer tenderPlan,String companyName);
    /**
     * 添加新的招标计划
     *
     * @param tenderPlan        调查表类
     */
    void insertTenderPlan(TenderPlan tenderPlan);

    /**
     * 显示所有招标文件信息
     *
     * @return          招标文件的List
     */
    List<TenderPlan> findAllTenderPlan();

    /**
     * 根据调查表ID,查询新增招标计划
     *
     * @param tenderPlanID          调查表ID
     * @return          调查表类
     */
    TenderPlan findTenderPlanByID(Integer tenderPlanID);

    /**
     * 修改新增招标计划
     *
     * @param tenderPlan        调查表类
     */
    void updateTenderPlanByID(TenderPlan tenderPlan);

    /**
     * 企业参与竞标，插入招标详表记录
     *
     * @param tenderPlanID          调查表ID
     * @param companyName           公司名称
     */
    void insertTenderDetail(Integer tenderPlanID, String companyName);

    /**
     * 根据企业ID查询企业信息
     *
     * @param CompanyID
     * @return
     */
    Company findCompanyByID(Integer CompanyID);

}
