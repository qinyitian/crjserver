package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.*;
import com.edu.fjnu.cjrserver.service.ActivityService;
import com.edu.fjnu.cjrserver.service.ArtificialService;
import com.edu.fjnu.cjrserver.service.DemandTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 发布需求调查表用例Controller
 */
@RestController
@RequestMapping("/DemandTableService")
public class DemandTableController {
        @Autowired
        DemandTableService demandTableService;

    /**
     *  根据需求调查表ID获取体育器材列表
     * @param demandTableID 需求调查表ID
     * @return 体育器材列表
     */
    @RequestMapping(value = "/getEquipmentContent")
    public List<EquipmentContent> doGetEquipmentContent(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandTableService.doGetEquipmentContent(demandTableID);
    }
    /**
     *  根据需求调查表ID获取活动服务列表
     * @param demandTableID 需求调查表ID
     * @return 活动服务列表
     */
    @RequestMapping(value = "/getActivityService")
    public List<ActivityService> doGetActivityService(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandTableService.doGetActivityService(demandTableID);
    }
    /**
     *  根据需求调查表ID获取人工服务列表
     * @param demandTableID 需求调查表ID
     * @return 人工服务列表
     */
    @RequestMapping(value = "/getArtificialService")
    public List<ArtificialService> doGetArtificialService(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandTableService.doGetArtificialService(demandTableID);
    }
    /**
     *  根据需求调查表ID获取场地服务列表
     * @param demandTableID 需求调查表ID
     * @return 场地服务列表
     */
    @RequestMapping(value = "/getFieldService")
    public List<FieldServer> doGetFieldService(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandTableService.doGetFieldService(demandTableID);
    }
    /**
     *  根据需求调查表ID获取体育服务列表
     * @param demandTableID 需求调查表ID
     * @return 体育服务列表
     */
    @RequestMapping(value = "/getSportService")
    public List<Sport> doGetSportService(@RequestParam(value = "DemandTableId") Integer demandTableID){
        return demandTableService.doGetSportService(demandTableID);
    }



    /**
     * 发布需求调查表
     * @param name 需求调查表名称
     * @param startTime 投票开始时间
     * @param endTime 投票结束时间
     * @param equipMentService 器材服务ID列表
     * @param fieldService 场地服务ID列表
     * @param activityService 活动服务ID列表
     * @param artificialService 人工服务ID列表
     * @param sportService 体育服务ID列表
     * @return 返回操作结果
     */
        @RequestMapping(value = "/AddDemandTable")
        public ResultData<Object> saveDemandTableAndDetail(@RequestParam(value = "DemandTableName")  String name,
                                                            @RequestParam(value = "StartTime") String startTime,
                                                            @RequestParam(value = "EndTime") String endTime,
                                                            @RequestParam(value = "EquipmentService",required=false) String [] equipMentService,
                                                            @RequestParam(value = "FieldService",required=false) String [] fieldService,
                                                            @RequestParam(value = "ActivityService",required=false) String [] activityService,
                                                            @RequestParam(value = "ArtificialService",required=false) String [] artificialService,
                                                            @RequestParam(value = "SportService",required=false) String [] sportService

                                                           )  {
            ResultData<Object> resultData=new ResultData<Object>();

            Integer [] equip = new Integer[equipMentService.length];
            for(int i=0;i<equip.length;i++){
                equip[i] = Integer.parseInt(equipMentService[i]);
            }
            Integer [] field = new Integer[fieldService.length];
            for(int i=0;i<field.length;i++){
                field[i] = Integer.parseInt(fieldService[i]);
            }
            Integer [] activity = new Integer[activityService.length];
            for(int i=0;i<activity.length;i++){
                activity[i] = Integer.parseInt(activityService[i]);
            }
            Integer [] artificial= new Integer[artificialService.length];
            for(int i=0;i<artificial.length;i++){
                artificial[i] = Integer.parseInt(artificialService[i]);
            }
            Integer [] sport = new Integer[sportService.length];
            for(int i=0;i<sport.length;i++){
                sport[i] = Integer.parseInt(sportService[i]);
            }
            DemandTable demandTable = new DemandTable();
            demandTable.setDemandTableName(name);
            demandTable.setDemandTableStartTime(startTime);
            demandTable.setDemandTableEndTime(endTime);
            demandTable.setDemandTableState(1);//状态 1表示可以投票，0不可以投票，
            demandTable.setTag(0);  // 0表示调查表
            demandTableService.doAddDemandTableAndDetail(demandTable,field,activity,artificial,equip,sport);
            return resultData;
        }

    /**
     * 删除需求调查表
     * @param DemandTableID 需求调查表ID
     * @return 返回操作结果
     */
    @RequestMapping(value = "/delDemandTableID")
        public ResultData<Object> delDemandTable(@RequestParam(value = "DemandTableID") Integer  DemandTableID){
        ResultData<Object> resultData=new ResultData<Object>();
        demandTableService.doDelDemandTable(DemandTableID);
        return  resultData;
        }


    /**
     * 修改需求调查表
     *
     */
    @RequestMapping(value = "/updateDemandTableByID")
    public ResultData<Object> updateDemandTable(@RequestParam(value = "DemandTableID") Integer demandTableID,
                                                @RequestParam(value = "DemandTableName")  String name,
                                                @RequestParam(value = "StartTime") String startTime,
                                                @RequestParam(value = "EndTime") String endTime,
                                                @RequestParam(value = "State") String  state
                                                ) {


        DemandTable demandTable = demandTableService.doGetDemandTableByID(demandTableID);
        demandTable.setDemandTableName(name);
        demandTable.setDemandTableStartTime(startTime);
        demandTable.setDemandTableEndTime(endTime);
        demandTable.setDemandTableState(Integer.parseInt(state));//状态 1表示可以投票，0不可以投票，

        demandTableService.doUpdateDemandTable(demandTable);//更新

        ResultData<Object> resultData = new ResultData<Object>();
        resultData.setMsg("修改成功!");
        return  resultData;
    }

    /**
     * 获取所有需求调查表,不包括已删除的
     *
     * tag   0 表示 进行中，1 表示 已发布
     *
     * 完整路径： ../DemandTableService/getAllDemandTable
     *
     */
    @RequestMapping(value = "/getAllDemandTable")
    public List<DemandTable> getAllDemandTable(){
        return  demandTableService.doGetAllDemandTable();
    }


    /**
     *  查看所有的调查表
     *
     *  tag   0 表示 进行中，1 表示 已发布  2 表示 已删除
     *
     *  完整路径： ../DemandTableService/getDemandTableList
     *
     * @return
     */
    @RequestMapping(value="/getDemandTableList")
    public List<DemandTable> getDemandTableList(){
         return demandTableService.getDemandTableList();
    }

    /**
     * 根据获取需求调查表
     * @return
     */
    @RequestMapping(value = "/getDemandTableByID")
    public DemandTable getDemandTableByID(@RequestParam(value = "DemandTableID") String DemandTableID ){
        return  demandTableService.doGetDemandTableByID(Integer.parseInt(DemandTableID));
    }



}
