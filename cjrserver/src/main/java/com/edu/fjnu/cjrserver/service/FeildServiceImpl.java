package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.FieldServiceMapper;
import com.edu.fjnu.cjrserver.model.FieldServer;
import com.edu.fjnu.cjrserver.model.ResultData;
import com.edu.fjnu.cjrserver.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("FeildService")
public class FeildServiceImpl implements FeildService {

    @Autowired
    FieldServiceMapper fieldServiceMapper;

    public List<FieldServer> doGetFieldService() {

        return fieldServiceMapper.findFieldService();
    }

    public List<FieldServer> doGetFieldServiceByPage(Integer pageNumber, Integer pageSize) {

        return fieldServiceMapper.findFieldServiceByPage((pageNumber-1)*pageSize,pageSize);
    }

//    public List<FieldServer> doGetFieldServiceByName(Integer pageNumber, Integer pageSize,String FieldName){
//        return fieldServiceMapper.findFieldServiceByName((pageNumber-1)*pageSize,pageSize,FieldName);
//    }

    public void doDelService(Integer[] FeildServiceID) {
        for(Integer FieldID:FeildServiceID) {
            fieldServiceMapper.delFieldService(FieldID);
        }
    }

    public void doAddService(FieldServer fieldServer){
        fieldServiceMapper.addFieldService(fieldServer);
    }

    public FieldServer doGetServiceByID(Integer FiledID){
        return fieldServiceMapper.getFiledServiceByID(FiledID);
    }

    public void updateService(FieldServer fieldServer) {
        fieldServiceMapper.updateFieldService(fieldServer);
    }

    public String doGetImgPath(Integer FiledID){
        return fieldServiceMapper.findImgPath(FiledID);
    }

    public Integer doGetTotalQty(){
        return fieldServiceMapper.findTotalQty();
    }

    public Integer doGetTotalQtyByName(String FieldName){ return fieldServiceMapper.findTotalQtyByName(FieldName); }

    public List<FieldServer> doGetFieldByAdd(String Province, String City, String County,Integer pageNumber,Integer pageSize) {
        if(Province.length()<=0 && City.length()<=0 && County.length()<=0)
            return null;
        else if (Province != null && City == null || County.length()<=0)
            return fieldServiceMapper.findFieldByProvince(Province,(pageNumber-1)*pageSize,pageSize);
        else if(Province != null && City != null && County.length()<=0)
            return fieldServiceMapper.findFieldByPC(Province, City,(pageNumber-1)*pageSize,pageSize);
        else if(Province != null && City != null && County != null)
            return fieldServiceMapper.findFieldByAdd(Province, City, County,(pageNumber-1)*pageSize,pageSize);
        else
            return null;
    }

    public Integer goGetFieldByAddQty(String Province, String City, String County) {
        if(County.length()<=0)
            System.out.println("xuanzhong");
        if(Province.length()<=0 && City.length()<=0 && County.length()<=0)
            return null;
        else if (Province != null && City == null || County.length()<=0)
            return fieldServiceMapper.findFieldByProvinceQty(Province);
        else if(Province != null && City != null && County.length()<=0)
            return fieldServiceMapper.findFieldByPCQty(Province, City);
        else if(Province != null && City != null && County != null)
            return fieldServiceMapper.findFieldByAddQty(Province, City, County);
        else
            return null;
    }
}
