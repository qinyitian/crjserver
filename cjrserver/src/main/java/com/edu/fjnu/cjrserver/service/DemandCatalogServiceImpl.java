package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.ActivityServiceMapper;
import com.edu.fjnu.cjrserver.dao.DemandCatalogMapper;
import com.edu.fjnu.cjrserver.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("DemandCatalogService")
public class DemandCatalogServiceImpl implements DemandCatalogService {
    @Autowired
    DemandCatalogMapper demandCatalogMapper;
    public DemandTable getLatestDemand() {
        return  demandCatalogMapper.getLatestDemand();
    }

    public List<Map> doGetNewDemandCatalog(Integer state, Integer qty) {
        return demandCatalogMapper.getNewDemandCatalog(state,qty);
    }



    public void doUpdateDemandCatalog(DemandTable demandTable) {
        demandCatalogMapper.updateDemandCatalog(demandTable);
    }

    public void doDelDemandCatalog(Integer demandTableID) {
            demandCatalogMapper.delDemandCatalog(demandTableID);
    }

    public List<DemandTable> doGetAllDemandCatalog() {
        return demandCatalogMapper.getAllDemandCatalog();
    }

    public DemandTable doGetDemandCatalogByID(Integer DemandTableID) {
        return demandCatalogMapper.getDemandCatalogByID(DemandTableID);
    }

    public List<EquipmentContent> doGetEquipmentContent(Integer DemandTableID) {
        return demandCatalogMapper.findDemandCatalogEquipmentContent(DemandTableID);
    }


    public List<ActivityService> doGetActivityService(Integer DemandTableID) {
        return demandCatalogMapper.findDemandCatalogActivityService(DemandTableID);
    }
    public List<ArtificialService> doGetArtificialService(Integer DemandTableID) {
        return demandCatalogMapper.findDemandCatalogArtificialService(DemandTableID);
    }


    public List<FieldServer> doGetFieldService(Integer DemandTableID) {
        return demandCatalogMapper.findDemandCatalogFieldService(DemandTableID);
    }


    public List<Sport> doGetSportService(Integer DemandTableID) {
        return demandCatalogMapper.findDemandCatalogSportService(DemandTableID);
    }


    public Integer[] doGetEquipmentContentByDemandTableID(Integer DemandTableID) {
        return demandCatalogMapper.findEquipmentContentByDemandTableID(DemandTableID);
    }


    public Integer[] doGetActivityServiceByDemandTableID(Integer DemandTableID) {
        return demandCatalogMapper.findActivityServiceByDemandTableID(DemandTableID);
    }


    public Integer[] doGetArtificialServiceByDemandTableID(Integer DemandTableID) {
        return demandCatalogMapper.findArtificialServiceByDemandTableID(DemandTableID);
    }


    public Integer[] doGetFieldServiceByDemandTableID(Integer DemandTableID) {
        return demandCatalogMapper.findFieldServiceByDemandTableID(DemandTableID);
    }


    public Integer[] doGetSportServiceByDemandTableID(Integer DemandTableID) {
        return demandCatalogMapper.findSportServiceByDemandTableID(DemandTableID);
    }


    public void doPostEquipmentContentDetail(Integer DemandTableID,Integer[] allID, String[] ID) {
        Integer[] needID = new Integer[ID.length];
        needID = tranStringToInt(ID);
//        int size = allID.length-needID.length;
//        if (size >= 0) {
//            Integer[] result = new Integer[size];
//            result = delExitInAllID(allID, needID);
//            for (int i = 0; i < result.length; i++) {
//                demandCatalogMapper.delEquipmentContentByServerID(DemandTableID, result[i]);
//            }
//        }
        demandCatalogMapper.delEquipmentContentByServerID(DemandTableID, needID);
    }


    public void doPostActivityServiceDetail(Integer DemandTableID,Integer[] allID, String[] ID) {
        Integer[] needID = new Integer[ID.length];
        needID = tranStringToInt(ID);
//        int size = allID.length-needID.length;
//        if (size >= 0) {
//            Integer[] result = new Integer[size];
//            result = delExitInAllID(allID, needID);
//            for (int i = 0; i < result.length; i++) {
//                demandCatalogMapper.delActivityServiceByServerID(DemandTableID, result[i]);
//            }
//        }
        demandCatalogMapper.delActivityServiceByServerID(DemandTableID, needID);
    }


    public void doPostArtificialServiceDetail(Integer DemandTableID,Integer[] allID, String[] ID) {
        Integer[] needID = new Integer[ID.length];
        needID = tranStringToInt(ID);
//        int size = allID.length-needID.length;
//        if (size >= 0) {
//            Integer[] result = new Integer[size];
//            result = delExitInAllID(allID, needID);
//            for (int i = 0; i < result.length; i++) {
//                demandCatalogMapper.delArtificialServiceByServerID(DemandTableID, result[i]);
//            }
//        }
        demandCatalogMapper.delArtificialServiceByServerID(DemandTableID,needID);
    }


    public void doPostFieldServiceDetail(Integer DemandTableID,Integer[] allID, String[] ID) {
        Integer[] needID = new Integer[ID.length];
        needID = tranStringToInt(ID);
//        int size = allID.length-needID.length;
////        if (size >= 0) {
////            Integer[] result = new Integer[size];
////            result = delExitInAllID(allID, needID);
////            for (int i = 0; i < result.length; i++) {
////                demandCatalogMapper.delFieldServiceByServerID(DemandTableID, result[i]);
////            }
////        }
        demandCatalogMapper.delFieldServiceByServerID(DemandTableID, needID);
    }


    public void doPostSportServiceDetail(Integer DemandTableID,Integer[] allID, String[] ID) {
        Integer[] needID = new Integer[ID.length];
        needID = tranStringToInt(ID);
//        int size = allID.length-needID.length;
//        if (size >= 0) {
//            Integer[] result = new Integer[size];
//            result = delExitInAllID(allID, needID);
//            for (int i = 0; i < result.length; i++) {
//                demandCatalogMapper.delSportServiceByServerID(DemandTableID, result[i]);
//            }
//        }
        demandCatalogMapper.delSportServiceByServerID(DemandTableID, needID);

    }

    public List<DemandTable> getDemandTableList() {
        return  demandCatalogMapper.getDemandTableList();
    }

    public void changeToDemandDirectory(Integer DemandTableID, String DemandTableMame,String currentTime) {
        demandCatalogMapper.changeToDemandDirectory(DemandTableID,DemandTableMame,currentTime);
    }

    private Integer[] delExitInAllID(Integer[] allID,Integer[] needID){
        Integer[] result = new Integer[allID.length-needID.length];
        int index = 0;
        for (int i = 0;i<allID.length;i++){
            int flag = 1;
            for (int j = 0;j<needID.length;j++){
                if(allID[i] == needID[j]){
                    flag = 0;
                }
            }
            if (flag == 1){
                result[index] = allID[i];
                index++;
            }
        }
        return result;
    }
    private Integer[] tranStringToInt(String[] s){
        Integer [] ID = new Integer[s.length];
        for(int i=0;i<ID.length;i++){
            ID[i] = Integer.parseInt(s[i]);
        }
        return ID;
    }
}
