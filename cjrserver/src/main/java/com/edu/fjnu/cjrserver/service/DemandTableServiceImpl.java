package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.DemandTableMapper;
import com.edu.fjnu.cjrserver.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("DemandTableService")
public class DemandTableServiceImpl implements  DemandTableService{

    public List<EquipmentContent> doGetEquipmentContent(Integer DemandTableID) {
        return demandTableMapper.findDemandCatalogEquipmentContent(DemandTableID);
    }

    public List<ActivityService> doGetActivityService(Integer DemandTableID) {
        return demandTableMapper.findDemandCatalogActivityService(DemandTableID);
    }

    public List<ArtificialService> doGetArtificialService(Integer DemandTableID) {
        return demandTableMapper.findDemandCatalogArtificialService(DemandTableID);
    }

    public List<FieldServer> doGetFieldService(Integer DemandTableID) {
        return demandTableMapper.findDemandCatalogFieldService(DemandTableID);
    }

    public List<Sport> doGetSportService(Integer DemandTableID) {
        return demandTableMapper.findDemandCatalogSportService(DemandTableID);
    }

    public List<DemandTable> getDemandTableList() {
        return demandTableMapper.getDemandTableList();
    }

    @Autowired
    DemandTableMapper demandTableMapper;

    //开启事务
    @Transactional
    public  void doAddDemandTableAndDetail(DemandTable demandTable,Integer[] filed,Integer[] activity,Integer[] artificial,Integer[] equip,Integer[] sport){
        demandTableMapper.addDemandTable(demandTable);//插入DemandTable 表

        Integer maxId = demandTableMapper.getLastId();//获取DemandTable 表，刚刚插入的id
        DemandTable tmp = new DemandTable();
        tmp.setDemandTableID(maxId);//
        //插入场地服务
        for(Integer i:filed) {
            DemandFieldServiceDetail demandFieldServiceDetail = new DemandFieldServiceDetail();
            FieldServer fieldServer = new FieldServer();
            fieldServer.setFieldID(i);
            demandFieldServiceDetail.setDemandTable(tmp);
            demandFieldServiceDetail.setServiceID(fieldServer);
            demandTableMapper.addDemandFieldServiceDetail(demandFieldServiceDetail);
        }
      //插入活动服务表明细
        for(Integer i:activity){
            DemandActivityServiceDetail demandActivityServiceDetail = new DemandActivityServiceDetail();
            Activity activity1 = new Activity();
            activity1.setActivityID(i);
            demandActivityServiceDetail.setDemandTable(tmp);
            demandActivityServiceDetail.setServiceID(activity1);
            demandTableMapper.addDemandActivityServiceDetail(demandActivityServiceDetail);
        }
        //插入人工服务表明细
        for(Integer i:artificial){
            DemandArtificialServiceDetail demandArtificialServiceDetail = new DemandArtificialServiceDetail();
            Artificial artificial1 = new Artificial();
            artificial1.setArtificialID(i);
            demandArtificialServiceDetail.setDemandTable(tmp);
            demandArtificialServiceDetail.setServiceID(artificial1);
            demandTableMapper.addDemandArtificialServiceDetail(demandArtificialServiceDetail);
        }
        //插入运动服务表明细
        for (Integer i:sport){
            DemandSportServiceDetail demandSportServiceDetail = new DemandSportServiceDetail();
            Sport sport1=new Sport();
            sport1.setSportID(i);
            demandSportServiceDetail.setDemandTable(tmp);
            demandSportServiceDetail.setServiceID(sport1);
            demandTableMapper.addDemandSportServiceDetail(demandSportServiceDetail);
        }
        //插入器材明细
        for(Integer i:equip){
            DemandEquipmentContentDetail demandEquipmentContentDetail = new DemandEquipmentContentDetail();
            EquipmentContent equipmentContent = new EquipmentContent();
            equipmentContent.setDemandID(i);
            demandEquipmentContentDetail.setDemandTable(tmp);
            demandEquipmentContentDetail.setServiceID(equipmentContent);
            demandTableMapper.addDemandEquipmentContentDetail(demandEquipmentContentDetail);
        }

    }

    public void doDelDemandTable(Integer DemandTableID) {
        demandTableMapper.delDemandActivityServiceDetail(DemandTableID);
        demandTableMapper.delDemandArtificialServiceDetail(DemandTableID);
        demandTableMapper.delDemandEquipmentContentDetail(DemandTableID);
        demandTableMapper.delDemandFieldServiceDetail(DemandTableID);
        demandTableMapper.delDemandSportServiceDetail(DemandTableID);
        demandTableMapper.delDemandTable(DemandTableID);
    }

    public void doUpdateDemandTable(DemandTable demandTable) {
        demandTableMapper.updateDemandTable(demandTable);
    }


    public DemandTable doGetDemandTableByID(Integer DemandTableID) {
        return demandTableMapper.findDemandTableByID(DemandTableID);
    }

    public List<DemandTable> doGetAllDemandTable() {
        return demandTableMapper.getAllDemandTable();
    }
}
