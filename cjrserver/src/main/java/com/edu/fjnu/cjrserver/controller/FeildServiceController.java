package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.Company;
import com.edu.fjnu.cjrserver.model.FieldServer;
import com.edu.fjnu.cjrserver.model.ResultData;
import com.edu.fjnu.cjrserver.model.TableSplitResult;
import com.edu.fjnu.cjrserver.service.FeildService;
import com.edu.fjnu.cjrserver.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 场地服务增删改查Controller
 */
@RestController
@RequestMapping("/FieldService")
public class FeildServiceController {

    @Autowired
    FeildService feildService;

//    @RequestMapping(value = "/getFieldServiceByName")
//    public TableSplitResult<List<FieldServer>> getFieldServiceByName(@RequestParam(value = "pageNumber")Integer pageNumber,
//                                                                     @RequestParam(value = "pageSize")Integer pageSize,
//                                                                     @RequestParam(value = "FieldName") String FieldName){
//
//        TableSplitResult<List<FieldServer>> tableSplitResult = new TableSplitResult<List<FieldServer>>(pageNumber,pageSize,feildService.doGetTotalQtyByName(FieldName),feildService.doGetFieldServiceByName(pageNumber,pageSize,FieldName));
//        return tableSplitResult;
//    }
    /**
     * 根据ID查询服务
     * @param ServiceID ID
     * @return 服务
     */
    @RequestMapping(value = "/getFieldServiceId")
    public FieldServer doGetActivityServiceByID(@RequestParam(value = "ServiceId") Integer ServiceID){
        return feildService.doGetServiceByID(ServiceID);
    }
    /**
     * 获得场地服务列表
     * @return 返回场地服务列表
     */
    @RequestMapping(value = "/getFieldService")
    public List<FieldServer> doGetFieldService(){
        return feildService.doGetFieldService();
    }

    /**
     * 按分页查询场地服务
     * @param pageNumber 页号
     * @param pageSize 大小
     * @return 场地服务
     */
    @RequestMapping(value = "/getFieldServiceByPage")
    public TableSplitResult<List<FieldServer>> doGetFieldServiceByPage(@RequestParam(value = "pageNumber",required = false)Integer pageNumber,
                                                                 @RequestParam(value = "pageSize",required = false)Integer pageSize)
    {
        if(pageNumber == null)
            pageNumber= 1;
        if(pageSize == null)
            pageSize = 10;
        if(pageNumber>0 && pageSize>0)
            return new TableSplitResult<List<FieldServer>>(pageNumber,pageSize,feildService.doGetTotalQty(),feildService.doGetFieldServiceByPage(pageNumber,pageSize));
        else
            return null;
    }

    /**
     * 根据场地服务ID批量删除场地服务
     * @param FieldServiceID 场地服务ID列表
     * @param request
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/delFieldService")
    public ResultData<Object> delService(@RequestParam(value = "FieldID") String[] FieldServiceID, HttpServletRequest request)throws IOException{
        ResultData<Object> resultData=new ResultData<Object>();
        Integer [] ID = new Integer[FieldServiceID.length];
        for(int i=0;i<ID.length;i++){
            ID[i] = Integer.parseInt(FieldServiceID[i]);
        }
        FileUtils fileUtils = new FileUtils();
        for(int i=0;i<ID.length;i++){
            if(feildService.doGetServiceByID(ID[i])==null){
                resultData.setErrorResult(0,false,"没有找到相对应的场地服务");
                return resultData;
            }else{
                String pastImgPath = feildService.doGetImgPath(ID[i]);
                fileUtils.DeleteFile(pastImgPath,request);
            }
        }
        feildService.doDelService(ID);
        return resultData;
    }

    /**
     * 添加场地服务
     * @param FieldName 场地服务名称
     * @param Province 省
     * @param City 市
     * @param County 县
     * @param FieldAddress 详细地址
     * @param Price 价格
     * @param BusinessTime 营业时间
     * @param DetailIntroduct 详细介绍
     * @param Phone 联系电话
     * @param lon 经度
     * @param lat 纬度
     * @param FieldState 审核状态
     * @param CompanyID 企业ID
     * @param file 图片
     * @param request
     * @param response
     * @param session
     * @return 操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/addFieldService")
    public ResultData<Object> addService(@RequestParam(value = "FieldName") String FieldName,
                                         @RequestParam(value = "Province") String Province,
                                         @RequestParam(value = "City") String City,
                                         @RequestParam(value = "County") String County,
                                         @RequestParam(value = "FieldAddress") String  FieldAddress,
                                         @RequestParam(value = "Price",required=false) double Price,
                                         @RequestParam(value = "BusinessTime",required=false) String BusinessTime,
                                         @RequestParam(value = "DetailIntroduct",required=false) String DetailIntroduct,
                                         @RequestParam(value = "Phone",required=false) String Phone,
                                         @RequestParam(value = "lon") double lon,
                                         @RequestParam(value = "lat") double lat,
                                         @RequestParam(value = "FieldState") Integer FieldState,
                                         @RequestParam(value = "CompanyID" ,required = false) Integer CompanyID,
                                         @RequestParam(value = "FieldImg",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(FieldName!=null && Province!=null && City!=null && County!= null && FieldAddress!=null) {
            FieldServer fieldServer = new FieldServer();
            fieldServer.setFieldName(FieldName);
            fieldServer.setProvince(Province);
            fieldServer.setCity(City);
            fieldServer.setCounty(County);
            fieldServer.setFieldAddress(FieldAddress);
            fieldServer.setPrice(Price);
            fieldServer.setBusinessTime(BusinessTime);
            fieldServer.setDetailIntroduct(DetailIntroduct);
            fieldServer.setPhone(Phone);
            fieldServer.setLon(lon);
            fieldServer.setLat(lat);
            fieldServer.setFieldState(FieldState);
            Company company = new Company();
            company.setCompanyID(CompanyID);
            fieldServer.setCompany(company);
            FileUtils fileUtils = new FileUtils();
            String path = fileUtils.FileUpload(file,false,"FeildService",request,response,session);
            fieldServer.setFieldImg(path);
            feildService.doAddService(fieldServer);
            resultData.setRightResult(fieldServer.getFieldName() + "添加成功！");
            System.out.println(fieldServer.getFieldName() + "添加成功！");
            return resultData;
        }else{
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }

    }

//    @RequestMapping(value = "/getFieldServiceByID")
//    public FieldServer getFieldServiceByID(@RequestParam(value = "FieldID") Integer FieldID){
//        return feildService.doGetServiceByID(FieldID);
//    }

    /**
     * 修改场地服务
     * @param FieldName 场地服务名称
     * @param FieldID 场地服务ID
     * @param Province 省
     * @param City 市
     * @param County 县
     * @param FieldAddress 详细地址
     * @param Price 价格
     * @param BusinessTime 营业时间
     * @param DetailIntroduct 详细介绍
     * @param Phone 联系电话
     * @param lon 经度
     * @param lat 纬度
     * @param FieldState 审核状态
     * @param file 图片
     * @param request
     * @param response
     * @param session
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/updateFieldService")
    public ResultData<Object> updateService(@RequestParam(value = "FieldName") String FieldName,
                                            @RequestParam(value = "FieldID") Integer FieldID,
                                            @RequestParam(value = "Province") String Province,
                                            @RequestParam(value = "City") String City,
                                            @RequestParam(value = "County") String County,
                                            @RequestParam(value = "FieldAddress") String  FieldAddress,
                                            @RequestParam(value = "Price",required=false) double Price,
                                            @RequestParam(value = "BusinessTime",required=false) String BusinessTime,
                                            @RequestParam(value = "DetailIntroduct",required=false) String DetailIntroduct,
                                            @RequestParam(value = "Phone") String Phone,
                                            @RequestParam(value = "lon") double lon,
                                            @RequestParam(value = "lat") double lat,
                                            @RequestParam(value = "FieldState") Integer FieldState,
                                            @RequestParam(value = "FieldImg",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(feildService.doGetServiceByID(FieldID)!=null) {
            if (FieldName != null && Province != null && City != null && County != null && FieldAddress != null) {
                FieldServer fieldServer = new FieldServer();
                fieldServer.setFieldName(FieldName);
                fieldServer.setProvince(Province);
                fieldServer.setCity(City);
                fieldServer.setCounty(County);
                fieldServer.setFieldAddress(FieldAddress);
                fieldServer.setPrice(Price);
                fieldServer.setBusinessTime(BusinessTime);
                fieldServer.setDetailIntroduct(DetailIntroduct);
                fieldServer.setPhone(Phone);
                fieldServer.setLon(lon);
                fieldServer.setLat(lat);
                fieldServer.setFieldState(FieldState);
                fieldServer.setFieldID(FieldID);
                // 自定义的文件名称
                if(file != null) {
                    String pastImgPath = feildService.doGetImgPath(FieldID);
                    FileUtils fileUtils = new FileUtils();
                    String path = fileUtils.FileUpload(file,false,"FeildService",request,response,session);
                    if(path != null){
                        fileUtils.DeleteFile(pastImgPath,request);
                    }
                    fieldServer.setFieldImg(path);
                } else {
                    fieldServer.setFieldImg(feildService.doGetImgPath(FieldID));
                    System.out.println(fieldServer.getFieldImg());
                }
                feildService.updateService(fieldServer);
                return resultData;
            } else {
                resultData.setErrorResult(0, false, "填写信息缺少，修改失败");
                System.out.println("填写信息缺少，修改失败");
                return resultData;
            }
        }else {
            resultData.setErrorResult(0,false,"没有找到相对应的场地服务");
            System.out.println("没有找到相对应的场地服务！");
            return resultData;
        }
    }

    /**
     * 根据三级级联城市查询场地服务
     * @param Province 省
     * @param City 市
     * @param County 县、区
     * @return 查询结果
     */
    @RequestMapping(value = "/findFieldByAdd")
    public TableSplitResult<List<FieldServer>> SearchFieldByAdd(@RequestParam(value = "Province",required=false) String Province,
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
            return new TableSplitResult<List<FieldServer>>(pageNumber,pageSize,feildService.goGetFieldByAddQty(Province,City,County),feildService.doGetFieldByAdd(Province,City,County,pageNumber,pageSize));
        else
            return null;
    }
}
