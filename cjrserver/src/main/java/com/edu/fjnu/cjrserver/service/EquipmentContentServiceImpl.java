package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.EquipmentContentMapper;
import com.edu.fjnu.cjrserver.model.EquipmentContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EquipmentContent")
public class EquipmentContentServiceImpl implements EquipmentContentService {
    @Autowired
    EquipmentContentMapper equipmentContentMapper;

    public List<EquipmentContent> doGetEquipmentContent() {
        return equipmentContentMapper.findEquipmentContentService();
    }
    public List<EquipmentContent> doGetEquipmentContentByPage(Integer pageNumber, Integer pageSize) {
        return equipmentContentMapper.findEquipmentContentServiceByPage(pageNumber,pageSize);
    }

//    public List<EquipmentContent> doGetEquipmentContentByName(Integer pageNumber, Integer pageSize, String DemandName) {
//        return equipmentContentMapper.findEquipmentContentServiceByName(pageNumber,pageSize,DemandName);
//    }

    public Integer doGetTotalQty() {
        return equipmentContentMapper.findTotalQty();
    }

    public Integer doGetTotalQtyByName(String DemandName) {
        return equipmentContentMapper.findTotalQtyByName(DemandName);
    }


    public void doDelService(Integer[] DemandID) {
        for(Integer id:DemandID){
            equipmentContentMapper.delEquipmentContent(id);
        }
    }


    public void doAddService(EquipmentContent equipmentContent) {
        equipmentContentMapper.addEquipmentContent(equipmentContent);
    }


    public EquipmentContent doGetServiceByID(Integer DemandID) {
        return equipmentContentMapper.getEquipmentContentById(DemandID);
    }


    public void updateService(EquipmentContent equipmentContent) {
        equipmentContentMapper.updateEquipmentContent(equipmentContent);
    }


    public String doGetImgPath(Integer DemandID) {
        return equipmentContentMapper.findImgPath(DemandID);
    }
}
