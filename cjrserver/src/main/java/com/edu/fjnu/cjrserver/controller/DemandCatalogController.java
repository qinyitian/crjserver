package com.edu.fjnu.cjrserver.controller;


import com.edu.fjnu.cjrserver.model.*;
import com.edu.fjnu.cjrserver.service.ActivityService;
import com.edu.fjnu.cjrserver.service.ArtificialService;
import com.edu.fjnu.cjrserver.service.DemandCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 发布需求目录用例Controller
 * Created by Administrator on 2018/2/18 0018.
 */
@RestController
@RequestMapping("/DemandCatalog")
public class DemandCatalogController {
    @Autowired
    DemandCatalogService demandCatalogService;

    /**
     *  根据需求调查表ID获取体育器材列表
     * @param demandTableID 需求调查表ID
     * @return 体育器材列表
     */
    @RequestMapping(value = "/getEquipmentContent")
    public List<EquipmentContent> doGetEquipmentContent(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandCatalogService.doGetEquipmentContent(demandTableID);
    }
    /**
     *  根据需求调查表ID获取活动服务列表
     * @param demandTableID 需求调查表ID
     * @return 活动服务列表
     */
    @RequestMapping(value = "/getActivityService")
    public List<ActivityService> doGetActivityService(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandCatalogService.doGetActivityService(demandTableID);
    }
    /**
     *  根据需求调查表ID获取人工服务列表
     * @param demandTableID 需求调查表ID
     * @return 人工服务列表
     */
    @RequestMapping(value = "/getArtificialService")
    public List<ArtificialService> doGetArtificialService(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandCatalogService.doGetArtificialService(demandTableID);
    }
    /**
     *  根据需求调查表ID获取场地服务列表
     * @param demandTableID 需求调查表ID
     * @return 场地服务列表
     */
    @RequestMapping(value = "/getFieldService")
    public List<FieldServer> doGetFieldService(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandCatalogService.doGetFieldService(demandTableID);
    }
    /**
     *  根据需求调查表ID获取体育服务列表
     * @param demandTableID 需求调查表ID
     * @return 体育服务列表
     */
    @RequestMapping(value = "/getSportService")
    public List<Sport> doGetSportService(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandCatalogService.doGetSportService(demandTableID);
    }
    //发布需求目录，主要是将原本需求调查表里面未选择的删除
    @RequestMapping(value = "/ReleaseEquipmentContent")
    public void doPostEquipmentContent(@RequestParam(value = "DemandTableID") Integer DemandTableID,
                                       @RequestParam(value = "EquipmentContent",required = false) String[] EquipmentContentID){
        if(EquipmentContentID != null){
            demandCatalogService.doPostEquipmentContentDetail(DemandTableID,demandCatalogService.doGetEquipmentContentByDemandTableID(DemandTableID),EquipmentContentID);
        }
    }
    @RequestMapping(value = "/ReleaseActivityService")
    public void doPostActivityService(@RequestParam(value = "DemandTableID") Integer DemandTableID,
                                      @RequestParam(value = "ActivityService",required = false) String[] ActivityServiceID){
        if(ActivityServiceID != null){
            demandCatalogService.doPostActivityServiceDetail(DemandTableID,demandCatalogService.doGetActivityServiceByDemandTableID(DemandTableID),ActivityServiceID);
        }
    }
    @RequestMapping(value = "/ReleaseArtificialService")
    public void doPostArtificialService(@RequestParam(value = "DemandTableID") Integer DemandTableID,
                                       @RequestParam(value = "ArtificialService",required = false) String[] ArtificialServiceID){
        if(ArtificialServiceID != null){
            demandCatalogService.doPostArtificialServiceDetail(DemandTableID,demandCatalogService.doGetArtificialServiceByDemandTableID(DemandTableID),ArtificialServiceID);
        }
    }
    @RequestMapping(value = "/ReleaseFieldService")
    public void doPostFieldService(@RequestParam(value = "DemandTableID") Integer DemandTableID,
                                      @RequestParam(value = "FieldService",required = false) String[] FieldServiceID){
        if(FieldServiceID != null){
            demandCatalogService.doPostFieldServiceDetail(DemandTableID,demandCatalogService.doGetFieldServiceByDemandTableID(DemandTableID),FieldServiceID);
        }
    }
    @RequestMapping(value = "/ReleaseSportService")
    public void doPostSportService(@RequestParam(value = "DemandTableID") Integer DemandTableID,
                                      @RequestParam(value = "SportService",required = false) String[] SportServiceID){
        if(SportServiceID != null){
            demandCatalogService.doPostSportServiceDetail(DemandTableID,demandCatalogService.doGetSportServiceByDemandTableID(DemandTableID),SportServiceID);
        }
    }

    /**
     * 转化成需求目录
     * @param DemandTableID             需求调查表ID
     * @param DemandTableMame           需求目录名称
     */
    @RequestMapping(value = "/ChangeToDemandDirectory")
    public void changeToDemandDirectory(@RequestParam(value = "DemandTableID") Integer DemandTableID,
                                        @RequestParam(value = "DemandTableMame") String DemandTableMame) {
        if (DemandTableID != null && DemandTableMame != null) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
            String currentday=sdf.format(new Date());
            demandCatalogService.changeToDemandDirectory(DemandTableID,DemandTableMame,currentday);
        }
    }


    /**
     * 修改需求目录
     * 前端参数
     * DemandTableID     id
     * AliasName    需求目录名
     * StartTime    开始时间
     * EndTime  结束时间
     * CatalogState， 1已截止， 0进行中
     * 完整访问 路径   ../DemandCatalog/updateDemandCatalogByID
     *
     */
    @RequestMapping(value = "/updateDemandCatalogByID")
    public ResultData<Object> updateDemandTable(@RequestParam(value = "DemandTableID") Integer demandTableID,
                                                @RequestParam(value = "AliasName")  String name,
                                                @RequestParam(value = "StartTime") String startTime,
                                                @RequestParam(value = "EndTime") String endTime,
                                                @RequestParam(value = "CatalogState") Integer catalogState
    ) {
        DemandTable demandTable = demandCatalogService.doGetDemandCatalogByID(demandTableID);
        demandTable.setAliasName(name); // 设置需求目录名
        demandTable.setDemandTableStartTime(startTime);
        demandTable.setDemandTableEndTime(endTime);
        demandTable.setCatalogState(catalogState);
         demandCatalogService.doUpdateDemandCatalog(demandTable);//更新
        ResultData<Object> resultData = new ResultData<Object>();
        resultData.setMsg("修改成功!");
        return  resultData;
    }

    /**
     * 获取所有需求目录，不包括已删除的
     *
     * 祖根要求加的一列 状态对应属性为  tag    1表示 已发布
     * CatalogState， 1已截止， 0进行中
     * 前端根据 tag 的值去判断就可以了
     *
     * 完整路径： ../DemandCatalog/getAllDemandCatalog
     * @return
     */
    @RequestMapping(value = "/getAllDemandCatalog")
    public List<DemandTable> getAllDemandCatalog(){
        return  demandCatalogService.doGetAllDemandCatalog();
    }


    /**
     *  查看所有的需求目录,包括已删除的
     *
     *  tag   1 表示 正常  2 表示 已删除
     *
     *  完整路径： ../DemandCatalog/getDemandTableList
     *
     * @return
     */
    @RequestMapping(value="/getDemandTableList")
    public List<DemandTable> getDemandTableList(){
        return demandCatalogService.getDemandTableList();
    }

    /**
     *
     * 获取最新需求目录
     *
     *
     *
     * @return
     */
    @RequestMapping(value="/getLatestDemandCatalog")
    public  DemandTable getLatestDemandTable(){
        return  demandCatalogService.getLatestDemand();
    }

    /**
     * 根据ID获取需求目录
     * @return
     */
    @RequestMapping(value = "/getDemandCatalogByID")
    public DemandTable getDemandTableByID(@RequestParam(value = "DemandTableID") Integer DemandTableID ){
        return  demandCatalogService.doGetDemandCatalogByID(DemandTableID);
    }


    /**
     * 删除需求目录,假删除    表demand_table 中，tag字段目前 0 表示调查表， 1表示需求目录，
     *
     * @param DemandTableID
     * @return
     */
    @RequestMapping(value = "/delDemandCatalog")
    public  ResultData<Object> delDemandCatalog(@RequestParam(value = "DemandTableID") Integer DemandTableID){
        ResultData<Object> resultData=new ResultData<Object>();
        demandCatalogService.doDelDemandCatalog(DemandTableID);
        return  resultData;
    }

    /**
     * 获取最新的前几个需求目录，返回map数组，其中key为需求目录ID，value为需求目录发布时间
     * @param state 默认为1，表示查询的是需求目录
     * @param qty 默认为3表示查询几条记录
     * @return 返回map数组
     */
    @RequestMapping(value = "/newDemandCatalog")
    public List<Map> findNewDemandCatalog(@RequestParam(value = "state") Integer state,
                                      @RequestParam(value = "qty",required = false) Integer qty){
        if (qty==null)
            qty = 3;
        return demandCatalogService.doGetNewDemandCatalog(state, qty);
    }
}
