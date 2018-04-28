package com.edu.fjnu.cjrserver.controller;


import com.edu.fjnu.cjrserver.model.Artificial;
import com.edu.fjnu.cjrserver.model.Company;
import com.edu.fjnu.cjrserver.model.ResultData;
import com.edu.fjnu.cjrserver.model.TableSplitResult;
import com.edu.fjnu.cjrserver.service.ArtificialService;
import com.edu.fjnu.cjrserver.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 人工服务增删改查功能Controller
 */
@RestController
@RequestMapping("/ArtificialService")
public class ArtificialServiceController {

    @Autowired
    ArtificialService artificialService;
    /**
     * 根据ID查询服务
     * @param ServiceID ID
     * @return 服务
     */
    @RequestMapping(value = "/getArtificialServiceId")
    public Artificial doGetActivityServiceByID(@RequestParam(value = "ServiceId") Integer ServiceID){
        return artificialService.doGetServiceByID(ServiceID);
    }
    /**
     * 返回人工服务列表
     * @return 人工服务列表
     */
    @RequestMapping(value = "/getArtificialService")
    public List<Artificial>doGetArtificialService(){
        return artificialService.doGetArtificialService();
    }

    /**
     * 按分页查询人工服务
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getArtificialServiceByPage")
    public TableSplitResult<List<Artificial>> doGetArtificialService(
            @RequestParam(value = "pageNumber",required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",required = false)Integer pageSize
    )
    {
        if(pageNumber == null)
            pageNumber= 1;
        if(pageSize == null)
            pageSize = 10;
        if(pageNumber>0 && pageSize>0)
            return new TableSplitResult<List<Artificial>>(pageNumber,pageSize,artificialService.doGetTotalQty(),artificialService.doGetArtificialService(pageNumber,pageSize));
        else
            return null;
    }
//    @RequestMapping(value = "/getArtificialServiceByName")
//    public TableSplitResult<List<Artificial>> doGetArtificialService(
//            @RequestParam(value = "pageNumber")Integer pageNumber,
//            @RequestParam(value = "pageSize")Integer pageSize,
//            @RequestParam(value = "ArtificialName") String ArtificialName
//    )
//    {
//        return new TableSplitResult<List<Artificial>>(pageNumber,pageSize,artificialService.doGetTotalQty(),artificialService.doGetArtificialServiceByName(pageNumber,pageSize,ArtificialName));
//    }

    /**
     * 批量删除人工服务
     * @param artificialID 人工服务列表
     * @param request
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/delArtificialService")
    public  ResultData<Object> delService(@RequestParam(value = "ArtificialID") String[] artificialID, HttpServletRequest request)throws IOException{
        ResultData<Object> resultData=new ResultData<Object>();
        Integer [] ID = new Integer[artificialID.length];
        for(int i=0;i<ID.length;i++){
            ID[i] = Integer.parseInt(artificialID[i]);
        }
        FileUtils fileUtils = new FileUtils();
        for(int i=0;i<ID.length;i++){
            if(artificialService.doGetServiceByID(ID[i])==null){
                resultData.setErrorResult(0,false,"没有找到相对应的人工服务");
                return resultData;
            }else{
                String pastImgPath = artificialService.doGetFilePath(ID[i]);
                fileUtils.DeleteFile(pastImgPath,request);
            }
        }
        artificialService.doDelService(ID);
        return resultData;
    }

    /**
     * 添加人工服务
     * @param artificialName 人工服务名称
     * @param file 介绍文件
     * @param request
     * @param response
     * @param session
     * @param phone 联系电话
     * @param price 价格
     * @param suitableCrowd 适用人群
     * @param companyID 企业ID
     * @param artificialState 审核状态
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/addArtificialService")
    public ResultData<Object> addService(@RequestParam(value = "ArtificialName") String artificialName,
                                         @RequestParam(value = "ArtificialFile",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session,
                                         @RequestParam(value = "Phone",required=false) String phone,
                                         @RequestParam(value = "Price",required=false) String price,
                                         @RequestParam(value = "SuitableCrowd") String  suitableCrowd,
                                         @RequestParam(value = "CompanyID" ,required = false) Integer companyID,
                                         @RequestParam(value = "ArtificialState") int artificialState
                                         )throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(artificialName!=null && suitableCrowd!=null ) {
            Artificial artificial = new Artificial();
            artificial.setArtificialName(artificialName);
            artificial.setSuitableCrowd(suitableCrowd);
            artificial.setArtificialState(artificialState);
            artificial.setPhone(phone);
            artificial.setPrice(price);
            Company company = new Company();
            company.setCompanyID(companyID);
            artificial.setCompany(company);
            FileUtils fileUtils = new FileUtils();
            String path = fileUtils.FileUpload(file,true,"ArtificialService",request,response,session);
            artificial.setArtificialFile(path);
            artificialService.doAddService(artificial);
            resultData.setRightResult(artificial.getArtificialName() + "添加成功");
            System.out.println(artificial.getArtificialName() + "添加成功");
            return resultData;
        }else{
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }

    }

    /**
     * 根据人工服务ID查找人工服务并返回结果
     * @param ArtificialID 人工服务ID
     * @return 人工服务
     */
    @RequestMapping(value = "/getArtificialByID")
    public Artificial getArtificialServiceByID(@RequestParam(value = "ArtificialID") Integer ArtificialID){
        return artificialService.doGetServiceByID(ArtificialID);
    }

    /**
     * 修改人工服务
     * @param artificialID 人工服务ID
     * @param artificialName 人工服务名称
     * @param file 介绍文件
     * @param request
     * @param response
     * @param session
     * @param phone 联系电话
     * @param price 价格
     * @param suitableCrowd 适用人群
     * @param artificialState 审核状态
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/updateArtificialService")
    public ResultData<Object> updateService(@RequestParam(value = "ArtificialID") Integer artificialID,
                                            @RequestParam(value = "ArtificialName") String artificialName,
                                            @RequestParam(value = "ArtificialFile",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session,
                                            @RequestParam(value = "Phone",required=false) String phone,
                                            @RequestParam(value = "Price",required=false) String price,
                                            @RequestParam(value = "SuitableCrowd") String  suitableCrowd,
                                            @RequestParam(value = "ArtificialState") int artificialState
                                            ) throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(artificialService.doGetServiceByID(artificialID)!=null){
            if(artificialName!=null && suitableCrowd!=null ) {
                Artificial artificial = new Artificial();
                artificial.setArtificialName(artificialName);
                artificial.setArtificialID(artificialID);
                artificial.setArtificialState(artificialState);
                artificial.setPhone(phone);
                artificial.setPrice(price);
                artificial.setSuitableCrowd(suitableCrowd);
                if(file != null) {
                    String pastImgPath = artificialService.doGetFilePath(artificialID);
                    FileUtils fileUtils = new FileUtils();
                    String path = fileUtils.FileUpload(file,true,"ArtificialService",request,response,session);
                    if(path != null){
                        fileUtils.DeleteFile(pastImgPath,request);
                    }
                    artificial.setArtificialFile(path);
                } else {
                    artificial.setArtificialFile(artificialService.doGetFilePath(artificialID));
                }
                artificialService.updateService(artificial);
                return resultData;
            } else {
                resultData.setErrorResult(0, false, "填写信息缺少，修改失败");
                return resultData;
            }
        }else {
            resultData.setErrorResult(0,false,"没有找到相对应的场地服务");
            return resultData;
        }
    }

}
