package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.TenderMapper;
import com.edu.fjnu.cjrserver.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 朱仲 on 2018/2/22.
 */
@Service("TenderService")
public class TenderServiceImpl implements TenderService {
    @Autowired
    TenderMapper tenderMapper;

    public List<CompanyInfo> getTenderCompanyInfo(Integer TenderPlanID,Integer State) {
        return tenderMapper.findCompanyInfoInTender(TenderPlanID,State);
    }

    public WinBidCompany getWinBidCompany(Integer TenderPlanId) {
        return tenderMapper.findWinBidCompany(TenderPlanId);
    }

    public void setCompanyStatus(Integer tenderPlanId,Integer[] CheckCompanyID){
        for(Integer i :CheckCompanyID){
            tenderMapper.setPassedCompany(tenderPlanId,i);
        }
    }


    public void setWinBidCompany(Integer TenderPlan, String CompanyName) {
        tenderMapper.insertWinBidCompany(TenderPlan,CompanyName);
    }


    /**
     * 添加的Service实现
     *
     * @version 	2018-03-05
     */
    /**
     * 添加新的招标计划
     *
     * @param tenderPlan        调查表类
     */
    public void doPostTenderPlan(TenderPlan tenderPlan) {
        tenderMapper.insertTenderPlan(tenderPlan);
    }

    /**
     * 显示所有招标文件信息
     *
     * @return          招标文件的List
     */
    public List<TenderPlan> doGetAllTenderPlan() {
        return tenderMapper.findAllTenderPlan();
    }

    /**
     * 根据调查表ID,查询新增招标计划
     *
     * @param tenderPlanID          调查表ID
     * @return          调查表类
     */
    public TenderPlan doGetTenderPlanByID(Integer tenderPlanID) {
        return tenderMapper.findTenderPlanByID(tenderPlanID);
    }

    /**
     * 修改新增招标计划
     *
     * @param tenderPlan        调查表类
     */
    public void doPostUpdateTenderPlanByID(TenderPlan tenderPlan) {
        tenderMapper.updateTenderPlanByID(tenderPlan);
    }

    /**
     * 企业参与竞标，插入招标详表记录
     *
     * @param tenderPlanID          调查表ID
     * @param companyName           公司名称
     */
    public void doPostTenderDetail(Integer tenderPlanID, String companyName) {
        tenderMapper.insertTenderDetail(tenderPlanID,companyName);
    }


    public Company doGetCompanyByID(Integer CompanyID) {
        return tenderMapper.findCompanyByID(CompanyID);
    }
}
