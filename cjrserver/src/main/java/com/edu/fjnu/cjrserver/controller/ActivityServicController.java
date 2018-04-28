package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.*;
import com.edu.fjnu.cjrserver.service.ActivityService;
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
 * 活动服务增删改查功能Controller
 * Created by Administrator on 2018/1/3 0003.
 */
@RestController
@RequestMapping("/ActivityService")
public class ActivityServicController {
    @Autowired
    ActivityService activityService;

    /**
     * 根据ID查询服务
     * @param ServiceID ID
     * @return 服务
     */
    @RequestMapping(value = "/getActivityServiceById")
    public Activity doGetActivityServiceByID(@RequestParam(value = "ServiceId") Integer ServiceID){
        return activityService.doGetServiceByID(ServiceID);
    }
    /**
     * 按分页查询人工服务
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getActivityServiceByPage")
    public TableSplitResult<List<Activity>> doGetActivityService(
            @RequestParam(value = "pageNumber",required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",required = false)Integer pageSize
    )
    {
        if(pageNumber == null)
            pageNumber= 1;
        if(pageSize == null)
            pageSize = 10;
        if(pageNumber>0 && pageSize>0)
            return new TableSplitResult<List<Activity>>(pageNumber,pageSize,activityService.doGetTotalQty(),activityService.doGetActivityServiceByPage(pageNumber,pageSize));
        else
            return null;
    }
    /**
     * 返回活动服务列表
     * @return 活动服务列表
     */
    @RequestMapping(value = "/getActivityService")
    public List<Activity> doGetActivityService()
    {
        return activityService.doGetActivityService();
    }

    /**
     * 根据活动服务ID批量删除活动服务
     * @param activityID 活动服务ID列表
     * @param request
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/delActivityService")
    public ResultData<Object> delService(@RequestParam(value = "ActivityID") String[] activityID,HttpServletRequest request)throws IOException{
        ResultData<Object> resultData=new ResultData<Object>();
        Integer [] ID = new Integer[activityID.length];
        for(int i=0;i<ID.length;i++){
            ID[i] = Integer.parseInt(activityID[i]);
        }
        FileUtils fileUtils = new FileUtils();
        for(int i=0;i<ID.length;i++){
            if(activityService.doGetServiceByID(ID[i])==null){
                resultData.setErrorResult(0,false,"没有找到相对应的活动服务");
                return resultData;
            }else{
                String pastImgPath = activityService.doGetFilePathByID(ID[i]);
                fileUtils.DeleteFile(pastImgPath,request);
            }
        }
        activityService.doDelService(ID);
        return resultData;
    }

    /**
     *  添加活动服务
     * @param activityName 活动服务名称
     * @param activityAddress 活动服务详细地址
     * @param province 省
     * @param city 市
     * @param county 县
     * @param lon 经度
     * @param lat 纬度
     * @param linkman 联系人
     * @param linkmanTelephone 联系电话
     * @param companyID 企业ID
     * @param file 介绍文件
     * @param request
     * @param response
     * @param session
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/addActivityService")
    public ResultData<Object> addService(@RequestParam(value = "ActivityName") String activityName,
                                         @RequestParam(value = "ActivityAddress") String  activityAddress,
                                         @RequestParam(value = "Province") String province,
                                         @RequestParam(value = "City") String city,
                                         @RequestParam(value = "County") String county,
                                         @RequestParam(value = "lon") double lon,
                                         @RequestParam(value = "lat") double lat,
                                         @RequestParam(value = "Linkman") String  linkman,
                                         @RequestParam(value = "LinkmanTelephone") String  linkmanTelephone,
                                         @RequestParam(value = "CompanyID" ,required = false) Integer companyID,
                                         @RequestParam(value = "DetaileFile",required=false) MultipartFile file,
                                         HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(activityName!=null && activityAddress!=null) {
            Activity activityServer = new Activity();
            activityServer.setActivityName(activityName);
            activityServer.setActivityAddress(activityAddress);
            activityServer.setProvince(province);
            activityServer.setCity(city);
            activityServer.setCounty(county);
            activityServer.setLon(lon);
            activityServer.setLat(lat);
            activityServer.setLinkman(linkman);
            activityServer.setLinkmanTelephone(linkmanTelephone);
            Company company = new Company();
            company.setCompanyID(companyID);
            activityServer.setCompany(company);
            FileUtils fileUtils = new FileUtils();
            String path = fileUtils.FileUpload(file,true,"ActivityService",request,response,session);
            activityServer.setDetailFile(path);
            activityService.doAddService(activityServer);
            resultData.setRightResult(activityServer.getActivityName() + "添加成功！");
            System.out.println(activityServer.getActivityName() + "添加成功！");
            return resultData;
        }
        else{
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }
    }

    /**
     * 修改活动服务
     * @param activityID 活动服务ID
     * @param activityName 活动服务名称
     * @param activityAddress 活动服务地址
     * @param province 省
     * @param city 市
     * @param county 县
     * @param lon 经度
     * @param lat 纬度
     * @param linkman 联系人
     * @param linkmanTelephone 联系电话
     * @param companyID 企业ID
     * @param file 介绍文件
     * @param request
     * @param response
     * @param session
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/updateActivityService")
    public ResultData<Object> updateService(@RequestParam(value = "ActivityID") Integer activityID,
                                            @RequestParam(value = "ActivityName") String activityName,
                                            @RequestParam(value = "ActivityAddress") String  activityAddress,
                                            @RequestParam(value = "Province") String province,
                                            @RequestParam(value = "City") String city,
                                            @RequestParam(value = "County") String county,
                                            @RequestParam(value = "lon") double lon,
                                            @RequestParam(value = "lat") double lat,
                                            @RequestParam(value = "Linkman") String  linkman,
                                            @RequestParam(value = "LinkmanTelephone") String  linkmanTelephone,
                                            @RequestParam(value = "CompanyID" ,required = false) Integer companyID,
                                            @RequestParam(value = "DetaileFile",required=false) MultipartFile file,
                                            HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(activityService.doGetServiceByID(activityID)!=null) {
            if(activityName!=null &&  activityAddress!=null) {

                Activity activityServer = new Activity();
                activityServer.setActivityID(activityID);
                activityServer.setActivityName(activityName);
                activityServer.setActivityAddress(activityAddress);
                activityServer.setProvince(province);
                activityServer.setCity(city);
                activityServer.setCounty(county);
                activityServer.setLon(lon);
                activityServer.setLat(lat);
                activityServer.setLinkman(linkman);
                activityServer.setLinkmanTelephone(linkmanTelephone);
                Company company = new Company();
                company.setCompanyID(companyID);
                activityServer.setCompany(company);
                if(file != null) {
                    String pastImgPath = activityService.doGetFilePathByID(activityID);
                    FileUtils fileUtils = new FileUtils();
                    String path = fileUtils.FileUpload(file,true,"ActivityService",request,response,session);
                    if(path != null){
                        fileUtils.DeleteFile(pastImgPath,request);
                    }
                    activityServer.setDetailFile(path);
                } else {
                    activityServer.setDetailFile(activityService.doGetFilePathByID(activityID));
                }
                activityService.updateService(activityServer);
                return resultData;
            } else {
                resultData.setErrorResult(0, false, "填写信息缺少，修改失败");
                return resultData;
            }
        }
        else {
            resultData.setErrorResult(0,false,"没有找到相对应的活动信息服务");
            return resultData;
        }
    }
    /**
     * 根据三级级联城市查询活动服务
     * @param Province 省
     * @param City 市
     * @param County 县、区
     * @return 查询结果
     */
    @RequestMapping(value = "/findActivityByAdd")
    public TableSplitResult<List<Activity>> SearchActivityByAdd(@RequestParam(value = "Province",required=false) String Province,
                                                                @RequestParam(value = "City",required=false) String City,
                                                                @RequestParam(value = "County",required=false) String County,
                                                                @RequestParam(value = "pageNumber",required = false)Integer pageNumber,
                                                                @RequestParam(value = "pageSize",required = false)Integer pageSize){
        ResultData<Object> resultData=new ResultData<Object>();
        if(pageNumber == null)
            pageNumber= 1;
        if(pageSize == null)
            pageSize = 10;
        if(pageNumber>0 && pageSize>0)
            return new TableSplitResult<List<Activity>>(pageNumber,pageSize,activityService.goGetActivityByAddQty(Province,City,County),activityService.doGetActivityByAdd(Province,City,County,pageNumber,pageSize));
        else
            return null;
    }
}
