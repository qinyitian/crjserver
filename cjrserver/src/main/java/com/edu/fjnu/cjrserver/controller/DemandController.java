package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.*;
import com.edu.fjnu.cjrserver.service.DemandService;
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
 * 查看需求调查表Controller
 * Created by Administrator on 2018/1/3 0003.
 */
@RestController
@RequestMapping("/DemandTable")
public class DemandController {

    @Autowired
    DemandService demandService;

    /**
     * 获取需求调查表列表
     * @return 需求调查表列表
     */
    @RequestMapping("/getDemandTableList")
    public List<DemandTable> getDemandTableList(){ return demandService.doGetDemandTable();}
    /**
     *  根据需求调查表ID获取活动服务列表
     * @param demandTableID 需求调查表ID
     * @return 活动服务列表
     */
    @RequestMapping("/getActivityDetail")
    public List<Activity> getActivityList(@RequestParam(value = "DemandTableID") Integer demandTableID){
        return demandService.getActivityDetail(demandTableID);
    }
    /**
     *  根据需求调查表ID获取人工服务列表
     * @param demandTableID 需求调查表ID
     * @return 人工服务列表
     */
    @RequestMapping("/getArtificialDetail")
    public List<Artificial> getArtificialList(@RequestParam(value = "DemandTableID") Integer demandTableID){
        return demandService.getArtificialDetail(demandTableID);
    }
    /**
     *  根据需求调查表ID获取体育器材列表
     * @param demandTableID 需求调查表ID
     * @return 体育器材列表
     */
    @RequestMapping("/getEquipmentContentDetail")
    public List<EquipmentContent> getEquipmentContentList(@RequestParam(value = "DemandTableID") Integer demandTableID){
        return demandService.getEquipmentContentDetail(demandTableID);
    }
    /**
     *  根据需求调查表ID获取场地服务列表
     * @param demandTableID 需求调查表ID
     * @return 场地服务列表
     */
    @RequestMapping("/getFieldServiceDetail")
    public List<FieldServer> getFieldServiceList(@RequestParam(value = "DemandTableID") Integer demandTableID){
        return demandService.getFieldServerDetail(demandTableID);
    }
    /**
     *  根据需求调查表ID获取体育服务列表
     * @param demandTableID 需求调查表ID
     * @return 体育服务列表
     */
    @RequestMapping("/getSportDetail")
    public List<Sport> getSportList(@RequestParam(value = "DemandTableID") Integer demandTableID){
        return demandService.getSportDetail(demandTableID);
    }
}
