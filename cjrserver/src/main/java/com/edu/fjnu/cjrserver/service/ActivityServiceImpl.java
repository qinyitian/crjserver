package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.ActivityServiceMapper;
import com.edu.fjnu.cjrserver.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 */

/**
 * @author lm
 *
 */
@Service("ActivityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
    ActivityServiceMapper activityServiceMapper;

    public List<Activity> doGetActivityService() {

        return activityServiceMapper.findActivityService();
    }
    public List<Activity> doGetActivityServiceByPage(Integer pageNumber, Integer pageSize){
        return activityServiceMapper.findActivityServiceByPage((pageNumber-1)*pageSize,pageSize);
    }

	public void doDelService(Integer[] ActivityServiceID) {
		for(Integer ActivityID:ActivityServiceID) {
            activityServiceMapper.delActivityService(ActivityID);
        }
	}


	public void doAddService(Activity activityServer) {
		activityServiceMapper.addActivityService(activityServer);
	}


	public Activity doGetServiceByID(Integer ActivityID) {
		return  activityServiceMapper.getActivityServiceByID(ActivityID);
	}


	public void updateService(Activity activityServer) {
        activityServiceMapper.updateActivityService(activityServer);

	}

    public  String doGetFilePathByID(Integer ID){
        return activityServiceMapper.findFilepathByID(ID);
    }

    public Integer doGetTotalQty(){
        return activityServiceMapper.findTotalQty();
    }

    public Integer doGetTotalQtyByName(String ActivityName){ return activityServiceMapper.findTotalQtyByName(ActivityName); }
    public List<Activity> doGetActivityByAdd(String Province, String City, String County,Integer pageNumber,Integer pageSize) {
        if(Province.length()<=0 && City.length()<=0 && County.length()<=0)
            return null;
        else if (Province != null && City == null || County.length()<=0)
            return activityServiceMapper.findActivityByProvince(Province,(pageNumber-1)*pageSize,pageSize);
        else if(Province != null && City != null && County.length()<=0)
            return activityServiceMapper.findActivityByPC(Province, City,(pageNumber-1)*pageSize,pageSize);
        else if(Province != null && City != null && County != null)
            return activityServiceMapper.findActivityByAdd(Province, City, County,(pageNumber-1)*pageSize,pageSize);
        else
            return null;
    }

    public Integer goGetActivityByAddQty(String Province, String City, String County) {
        if(County.length()<=0)
            System.out.println("xuanzhong");
        if(Province.length()<=0 && City.length()<=0 && County.length()<=0)
            return null;
        else if (Province != null && City == null || County.length()<=0)
            return activityServiceMapper.findActivityByProvinceQty(Province);
        else if(Province != null && City != null && County.length()<=0)
            return activityServiceMapper.findActivityByPCQty(Province, City);
        else if(Province != null && City != null && County != null)
            return activityServiceMapper.findActivityByAddQty(Province, City, County);
        else
            return null;
    }
}
