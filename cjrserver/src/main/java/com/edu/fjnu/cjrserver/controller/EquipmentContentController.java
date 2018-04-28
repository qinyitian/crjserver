package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.EquipmentContent;
import com.edu.fjnu.cjrserver.model.ResultData;
import com.edu.fjnu.cjrserver.model.TableSplitResult;
import com.edu.fjnu.cjrserver.service.EquipmentContentService;
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
 * 体育器材增删改查Controller
 */
@RestController
@RequestMapping("/EquipmentContent")
public class EquipmentContentController {

    @Autowired
    EquipmentContentService equipmentContentService;
    /**
     * 根据ID查询服务
     * @param ServiceID ID
     * @return 服务
     */
    @RequestMapping(value = "/getEquipmentContentId")
    public EquipmentContent doGetActivityServiceByID(@RequestParam(value = "ServiceId") Integer ServiceID){
        return equipmentContentService.doGetServiceByID(ServiceID);
    }
    /**
     * 返回体育器材列表
     * @return 体育器材列表
     */
    @RequestMapping(value = "/getEquipmentContent")
    public List<EquipmentContent> doGetEquipmentContent(){
        return equipmentContentService.doGetEquipmentContent();
    }

    /**
     * 按分页查询器材服务
     * @param pageNumber 页号
     * @param pageSize 大小
     * @return 器材服务
     */
    @RequestMapping(value = "/getEquipmentContentByPage")
    public TableSplitResult<List<EquipmentContent>> doGetEquipmentContent(
            @RequestParam(value = "pageNumber",required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",required = false)Integer pageSize
    )
    {
        if(pageNumber == null)
            pageNumber= 1;
        if(pageSize == null)
            pageSize = 10;
        if(pageNumber>0 && pageSize>0)
            return new TableSplitResult<List<EquipmentContent>>(pageNumber,pageSize,equipmentContentService.doGetTotalQty(),equipmentContentService.doGetEquipmentContentByPage(pageNumber,pageSize));
        else
            return null;


    }

//    @RequestMapping(value = "/getEquipmentContentByName")
//    public TableSplitResult<List<EquipmentContent>> doGetEquipmentContent(@RequestParam(value = "pageNumber")Integer pageNumber,
//                                                                          @RequestParam(value = "pageSize")Integer pageSize,
//                                                                          @RequestParam(value = "DemandName") String DemandName
//    )
//    {
//        TableSplitResult<List<EquipmentContent>> tableSplitResult = new TableSplitResult<List<EquipmentContent>>(pageNumber,pageSize,equipmentContentService.doGetTotalQty(),equipmentContentService.doGetEquipmentContentByName(pageNumber,pageSize,DemandName));
//        return tableSplitResult;
//
//    }

    /**
     * 根据ID批量删除体育器材
     * @param DemandID 器材ID列表
     * @param request
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/delEquipmentContent")
    public ResultData<Object> delService(@RequestParam(value = "EquipmentContentID") String[] DemandID, HttpServletRequest request)throws IOException{
        ResultData<Object> resultData=new ResultData<Object>();

        Integer [] ID = new Integer[DemandID.length];
        for(int i=0;i<ID.length;i++){
            ID[i] = Integer.parseInt(DemandID[i]);
        }
        FileUtils fileUtils = new FileUtils();
        for(int i=0;i<ID.length;i++){
            if(equipmentContentService.doGetServiceByID(ID[i])==null){
                resultData.setErrorResult(0,false,"没有找到相对应的器材");
                return resultData;
            }else{
                String pastImgPath = equipmentContentService.doGetImgPath(ID[i]);
                fileUtils.DeleteFile(pastImgPath,request);
            }
        }
        equipmentContentService.doDelService(ID);
        return resultData;
    }

//    @RequestMapping(value = "/getEquipmentContentByID")
//    public EquipmentContent getFieldServiceByID(@RequestParam(value = "DemandID") Integer DemandID){
//        return equipmentContentService.doGetServiceByID(DemandID);
//    }

    /**
     * 添加体育器材
     * @param DemandName 体育器材名称
     * @param DemandCategory 器材类别
     * @param DemandRemarks 使用介绍
     * @param DemandState 审核状态
     * @param file 器材图片
     * @param request
     * @param response
     * @param session
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/addEquipmentContent")
    public ResultData<Object> addService(@RequestParam(value = "DemandName") String DemandName,
                                         @RequestParam(value = "DemandCategory") String DemandCategory,
                                         @RequestParam(value = "DemandRemarks",required=false) String DemandRemarks,
                                         @RequestParam(value = "DemandState") Integer DemandState,
                                         @RequestParam(value = "DemandModel",required=false) String DemandModel,
                                         @RequestParam(value = "Image",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(DemandName!=null && DemandCategory!=null) {

            EquipmentContent equipmentContent = new EquipmentContent();
            equipmentContent.setDemandName(DemandName);
            equipmentContent.setDemandCategory(DemandCategory);
            equipmentContent.setDemandRemarks(DemandRemarks);
            equipmentContent.setDemandState(DemandState);
            equipmentContent.setDemandModel(DemandModel);
            FileUtils fileUtils = new FileUtils();
            String path = fileUtils.FileUpload(file,false,"EquipmentContent",request,response,session);
            equipmentContentService.doAddService(equipmentContent);
            resultData.setRightResult(equipmentContent.getDemandName() + "添加成功！");
            System.out.println(equipmentContent.getDemandName() + "添加成功！");
            return resultData;
        }else{
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }

    }

    /**
     * 修改体育器材
     * @param DemandID 体育器材ID
     * @param DemandName 体育器材名称
     * @param DemandCategory 器材类别
     * @param DemandRemarks 使用介绍
     * @param DemandState 审核状态
     * @param file 图片
     * @param request
     * @param response
     * @param session
     * @return 返回操作结果
     * @throws IOException
     */
    @RequestMapping(value = "/updateEquipmentContent")
    public ResultData<Object> updateService(@RequestParam(value = "DemandID") Integer DemandID,
                                            @RequestParam(value = "DemandName") String DemandName,
                                            @RequestParam(value = "DemandCategory") String DemandCategory,
                                            @RequestParam(value = "DemandRemarks",required=false) String DemandRemarks,
                                            @RequestParam(value = "DemandState") Integer DemandState,
                                            @RequestParam(value = "Image",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ResultData<Object> resultData=new ResultData<Object>();
        if(equipmentContentService.doGetServiceByID(DemandID)!=null){
            if (DemandName != null && DemandCategory!= null) {

                EquipmentContent equipmentContent = new EquipmentContent();
                equipmentContent.setDemandName(DemandName);
                equipmentContent.setDemandCategory(DemandCategory);
                equipmentContent.setDemandRemarks(DemandRemarks);
                equipmentContent.setDemandID(DemandID);
                equipmentContent.setDemandState(DemandState);
                if(file != null) {
                    String pastImgPath = equipmentContentService.doGetImgPath(DemandID);
                    FileUtils fileUtils = new FileUtils();
                    String path = fileUtils.FileUpload(file,false,"EquipmentContent",request,response,session);
                    if(path != null){
                        fileUtils.DeleteFile(pastImgPath,request);
                    }
                    equipmentContent.setImage(path);
                } else {
                    equipmentContent.setImage(equipmentContentService.doGetImgPath(DemandID));
                }
                equipmentContentService.updateService(equipmentContent);
                System.out.println(equipmentContent.getDemandName() + "修改成功！");
                return resultData;
            } else {
                resultData.setErrorResult(0, false, "填写信息缺少，修改失败");
                return resultData;
            }
        }else {
            resultData.setErrorResult(0,false,"没有找到相对应的器材");
            return resultData;
        }
    }

}
