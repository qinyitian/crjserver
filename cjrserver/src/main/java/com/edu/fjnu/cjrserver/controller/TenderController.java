package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.*;
import com.edu.fjnu.cjrserver.service.DemandService;
import com.edu.fjnu.cjrserver.service.TenderService;
import com.edu.fjnu.cjrserver.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2018/1/3 0003.
 */
@RestController
@RequestMapping("/TenderCompany")
public class TenderController {

    @Autowired
    TenderService tenderService;
    //根据招标计划ID查询投标公司信息
    @RequestMapping("/getCompanyInfoInTender")
    public List<CompanyInfo> getCompanyInfoList(
            @RequestParam(value = "TenderPlanID") Integer TenderPlanId){
        return tenderService.getTenderCompanyInfo(TenderPlanId,0);
    }
    //根据招标计划ID查询通过竞标公司信息
    @RequestMapping("/getCheckCompany")
    public List<CompanyInfo> getCheckCompany(
            @RequestParam(value = "TenderPlanID") Integer TenderPlanId){
        return tenderService.getTenderCompanyInfo(TenderPlanId,1);
    }
    //确定竞标公司
    @RequestMapping("/setPassedCompany")
    public ResultData<Object> setPassedCompany(@RequestParam(value = "TenderPlanID") Integer tenderPlanId,
                                 @RequestParam(value="CheckCompanyList") String[] checkCompanyList){
        ResultData<Object> resultData = new ResultData<Object>();
        Integer [] ID = new Integer[checkCompanyList.length];
        for(int i=0;i<ID.length;i++){
            ID[i] = Integer.parseInt(checkCompanyList[i]);
            if(tenderService.doGetCompanyByID(ID[i]) == null)
            {
                resultData.setErrorResult(400,false,"未查找到该企业");
            }
        }
        tenderService.setCompanyStatus(tenderPlanId,ID);
        return resultData;
    }
    //获取中标公司信息
    @RequestMapping("/getWinBidCompany")
    public WinBidCompany getWinBidCompany(@RequestParam(value = "TenderPlanID") Integer tenderPlanId){
        return tenderService.getWinBidCompany(tenderPlanId);
    }
    //确定中标公司
    @RequestMapping("/setWinBidCompany")
    public ResultData<Object> setWinBidCompany(@RequestParam(value = "TenderPlanID") Integer tenderPlanId,
                                               @RequestParam(value = "CompanyID") Integer companyId){
        ResultData<Object> resultData = new ResultData<Object>();
        String CompanyName = tenderService.doGetCompanyByID(companyId).getCompanyName();
        if(CompanyName != null && tenderService.doGetTenderPlanByID(tenderPlanId) != null)
        {
            tenderService.setWinBidCompany(tenderPlanId,CompanyName);
        }else{
            resultData.setErrorResult(400,false,"传输信息错误");
        }

        return resultData;
    }
    //发布招标计划
    @RequestMapping(value = "/AddTenderPlan")
    public  ResultData<Object> addTenderPlan(@RequestParam(value = "TenderPlanName") String TenderPlanName,
                                             @RequestParam(value = "TenderPlanStartTime") String TenderPlanStartTime,
                                             @RequestParam(value = "TenderPlanEndTime") String TenderPlanEndTime,
                                             @RequestParam(value = "VoteEndTime") String VoteEndTime,
                                             @RequestParam(value = "TenderPlanFile",required = false) MultipartFile file,
                                             HttpServletRequest request, HttpServletResponse response, HttpSession session)throws IOException

    {
        ResultData<Object> resultData = new ResultData<Object>();
        if (TenderPlanName != null && TenderPlanStartTime != null && TenderPlanEndTime != null && VoteEndTime != null){
            TenderPlan tenderPlan = new TenderPlan();
            tenderPlan.setTenderPlanName(TenderPlanName);
            tenderPlan.setTenderPlanStartTime(TenderPlanStartTime);
            tenderPlan.setTenderPlanEndTime(TenderPlanEndTime);
            tenderPlan.setVoteEndTime(VoteEndTime);
            FileUtils fileUtils = new FileUtils();
            String path =  fileUtils.FileUpload(file,true,"TenderPlan",request,response,session);
            tenderPlan.setTenderPlanFilePath(path);
            tenderService.doPostTenderPlan(tenderPlan);
        }else{
            resultData.setErrorResult(400,false,"填写信息不完整");
        }
        return resultData;
    }
    //显示招标计划表格
    @RequestMapping(value = "/ShowTenderPlan")
    public List<TenderPlan> showTenderPlan(){
        return tenderService.doGetAllTenderPlan();
    }
    //企业参加招标计划
    @RequestMapping(value = "/AttendTenderPlan")
    public ResultData<Object> attendTenderPlan(@RequestParam(value = "TenderPlanID") Integer TenderPlanID,
                                               @RequestParam(value = "CompanyID") Integer CompanyID){
        ResultData<Object> resultData = new ResultData<Object>();
        String CompanyName = tenderService.doGetCompanyByID(CompanyID).getCompanyName();
        if(CompanyName != null && tenderService.doGetTenderPlanByID(TenderPlanID) != null){
            tenderService.doPostTenderDetail(TenderPlanID,CompanyName);
        }else{
            resultData.setErrorResult(400,false,"传输信息错误");
        }
        return resultData;
    }

}
