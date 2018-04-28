package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.DemandMapper;
import com.edu.fjnu.cjrserver.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 朱仲 on 2018/2/19.
 */

@Service("DemandService")
public class DemandServiceImpl implements DemandService {
    @Autowired
    DemandMapper demandMapper;

    public List<Activity> getActivityDetail(Integer DemandTableID) {
        return demandMapper.findActivityByDemandTableID(DemandTableID);
    }

    public List<Artificial> getArtificialDetail(Integer DemandTableID) {
        return demandMapper.findArtificialByDemandTableID(DemandTableID);
    }

    public List<EquipmentContent> getEquipmentContentDetail(Integer DemandTableID) {
        return demandMapper.findEquipmentContentByDemandTableID(DemandTableID);
    }

    public List<FieldServer> getFieldServerDetail(Integer DemandTableID) {
        return demandMapper.findFieldServerByDemandTableID(DemandTableID);
    }

    public List<Sport> getSportDetail(Integer DemandTableID) {
        return demandMapper.findSportByDemandTableID(DemandTableID);
    }

    public List<DemandTable> doGetDemandTable() {
        return demandMapper.findDemandTable();
    }


}
