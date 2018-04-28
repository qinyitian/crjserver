package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.ArtificialServiceMapper;
import com.edu.fjnu.cjrserver.model.Artificial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ArtificialService")
public class ArtificialServiceImpl implements ArtificialService {
    @Autowired
    ArtificialServiceMapper artificialServiceMapper;

    public List<Artificial> doGetArtificialService(Integer pageNumber, Integer pageSize) {
        return artificialServiceMapper.findArtificialServiceByPage(pageNumber,pageSize);
    }
    public List<Artificial> doGetArtificialService() {
        return artificialServiceMapper.findArtificialService();
    }
//    public List<Artificial> doGetArtificialServiceByName(Integer pageNumber, Integer pageSize, String ArtificialName) {
//        return artificialServiceMapper.findArtificialServiceByName(pageNumber,pageSize,ArtificialName);
//    }

    public Integer doGetTotalQty() {
        return artificialServiceMapper.findTotalQty();
    }

    public Integer doGetTotalQtyByName(String ArtificialName) {
        return artificialServiceMapper.findTotalQtyByName(ArtificialName);
    }

    public  void doDelService(Integer[] ArtificialID){
        for(Integer id:ArtificialID)
            artificialServiceMapper.delArtificialService(id);
    }

    public void doAddService(Artificial Artificial){
        artificialServiceMapper.addArtificialService(Artificial);
    }

    public Artificial doGetServiceByID(Integer ArtificialID){
        return artificialServiceMapper.getArtificialServiceByID(ArtificialID);
    }

    public void updateService(Artificial Artificial){
        artificialServiceMapper.updateArtificialService(Artificial);
    }

    public String doGetFilePath(Integer ArtificialID) {return  artificialServiceMapper.findFilePath(ArtificialID);}
}
