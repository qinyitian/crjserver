package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.Company;
import com.edu.fjnu.cjrserver.model.ResultData;
import com.edu.fjnu.cjrserver.model.Sport;
import com.edu.fjnu.cjrserver.model.TableSplitResult;
import com.edu.fjnu.cjrserver.service.SportService;
import com.edu.fjnu.cjrserver.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 体育活动增删改查Controller
 * Created by Administrator on 2018/1/3 0003.
 */
@RestController
@RequestMapping("/SportService")
public class SportServicController {
    @Autowired
    SportService sportService;
    /**
     * 根据ID查询服务
     * @param ServiceID ID
     * @return 服务
     */
    @RequestMapping(value = "/getSportServiceId")
    public Sport doGetActivityServiceByID(@RequestParam(value = "ServiceId") Integer ServiceID){
        return sportService.doGetServiceByID(ServiceID);
    }
    /**
     * 按分页查询赛事服务
     * @param pageNumber 页号
     * @param pageSize 大小
     * @return 赛事服务
     */
    @RequestMapping(value = "/getSportServiceByPage")
    public TableSplitResult<List<Sport>> doGetSportServiceByPage(@RequestParam(value = "pageNumber",required = false)Integer pageNumber,
                                                                       @RequestParam(value = "pageSize",required = false)Integer pageSize)
    {
        if(pageNumber == null)
            pageNumber= 1;
        if(pageSize == null)
            pageSize = 10;
        if(pageNumber>0 && pageSize>0)
            return new TableSplitResult<List<Sport>>(pageNumber,pageSize,sportService.doGetTotalQty(),sportService.doGetSportServiceByPage(pageNumber,pageSize));
        else
            return null;

    }
    /**
     * 获得体育服务列表
     * @return 体育服务列表
     */
    @RequestMapping(value = "/getSportService")
    public List<Sport> doGetSportService()
    {
        return sportService.doGetSportService();
    }

    /**
     *  根据体育服务ID批量删除体育读物
     * @param SportServiceID 体育服务ID列表
     * @param request
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/delSportService")
    public ResultData<Object> delService(@RequestParam(value = "SportID") String[] SportServiceID,HttpServletRequest request) throws IOException{
        ResultData<Object> resultData=new ResultData<Object>();
        Integer [] ID = new Integer[SportServiceID.length];
        for(int i=0;i<ID.length;i++){
            ID[i] = Integer.parseInt(SportServiceID[i]);
        }
        FileUtils fileUtils = new FileUtils();
        for(int i=0;i<ID.length;i++){
            if(sportService.doGetServiceByID(ID[i])==null){
                resultData.setErrorResult(0,false,"没有找到相对应的体育赛事");
                return resultData;
            }else{
                String pastImgPath = sportService.doGetFilepathByID(ID[i]);
                fileUtils.DeleteFile(pastImgPath,request);
            }
        }
        sportService.doDelService(ID);
        return resultData;
    }

    /**
     *  添加体育服务
     * @param SportType 体育类型
     * @param SportName 体育服务类型
     * @param CompanyID 企业ID
     * @param file 介绍文件
     * @param request
     * @param response
     * @param session
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/addSportService")
    public ResultData<Object> addService(@RequestParam(value = "SportType") String SportType,
                                         @RequestParam(value = "SportName") String SportName,
                                         @RequestParam(value = "CompanyID" ,required = false) Integer CompanyID,
                                         @RequestParam(value = "IntroductFile",required=false) MultipartFile file,
                                         HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(SportType!=null && SportName!=null ) {
            Sport sportServer = new Sport();
            sportServer.setSportType(SportType);
            sportServer.setSportName(SportName);
            Company company = new Company();
            company.setCompanyID(CompanyID);
            sportServer.setCompany(company);
            FileUtils fileUtils = new FileUtils();
            String path = fileUtils.FileUpload(file,true,"SportServic",request,response,session);
            sportServer.setIntroductFile(path);
            sportService.doAddService(sportServer);
            resultData.setRightResult(sportServer.getSportName() + "添加成功！");
            System.out.println(sportServer.getSportName() + "添加成功！");
            return resultData;
        }
        else{
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }
    }

    /**
     *  修改体育服务
     * @param SportID 体育服务ID
     * @param SportType 体育类型
     * @param SportName 体育名称
     * @param file 介绍文件
     * @param request
     * @param response
     * @param session
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/updateSportService")
    public ResultData<Object> updateService( @RequestParam(value = "SportID")Integer SportID,
                                             @RequestParam(value = "SportType") String SportType,
                                             @RequestParam(value = "SportName") String SportName,
                                             @RequestParam(value = "IntroductFile",required=false) MultipartFile file,
                                             HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(sportService.doGetServiceByID(SportID)!=null) {
            if(SportType!=null && SportName!=null) {

                Sport sportServer = new Sport();
                sportServer.setSportType(SportType);
                sportServer.setSportName(SportName);
                sportServer.setSportID(SportID);
                if(file != null) {
                    String pastImgPath = sportService.doGetFilepathByID(SportID);
                    FileUtils fileUtils = new FileUtils();
                    String path = fileUtils.FileUpload(file,true,"SportServic",request,response,session);
                    if(path != null){
                        fileUtils.DeleteFile(pastImgPath,request);
                    }
                    sportServer.setIntroductFile(path);
                } else {
                    sportServer.setIntroductFile(sportService.doGetFilepathByID(SportID));
                }
                sportService.updateService(sportServer);
                return resultData;
            } else {
                resultData.setErrorResult(0, false, "填写信息缺少，修改失败");
                return resultData;
            }
        }
        else {
            resultData.setErrorResult(0,false,"没有找到相对应的体育服务信息");
            return resultData;
        }

    }

}
