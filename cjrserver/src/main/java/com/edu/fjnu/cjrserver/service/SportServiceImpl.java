package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.SportServiceMapper;
import com.edu.fjnu.cjrserver.model.Sport;
import com.edu.fjnu.cjrserver.model.Sport;
import com.edu.fjnu.cjrserver.model.ResultData;
import com.edu.fjnu.cjrserver.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lm
 *
 */
@Service("SportService")
public class SportServiceImpl implements SportService {

	    @Autowired
	    SportServiceMapper sportServiceMapper;

	    public List<Sport> doGetSportService() {

			return sportServiceMapper.findSportService();
		} 
		public List<Sport> doGetSportServiceByPage(Integer pageNumber, Integer pageSize){
			return sportServiceMapper.findSportServiceByPage((pageNumber-1)*pageSize,pageSize);
		}

	    public void doDelService(Integer[] SportServiceID) {
	        for(Integer SportID:SportServiceID) {
	            sportServiceMapper.delSportService(SportID);
	        }
	    }

	    public void doAddService(Sport sportServer){
	        sportServiceMapper.addSportService(sportServer);
	    }

	    public Sport doGetServiceByID(Integer SportID){
	        return sportServiceMapper.getSportServiceByID(SportID);
	    }

	    public void updateService(Sport sportServer) {
	        sportServiceMapper.updateSportService(sportServer);
	    }

		public Integer doGetTotalQty(){
			return sportServiceMapper.findTotalQty();
		}

		public Integer doGetTotalQtyByName(String SportName){ 
			return sportServiceMapper.findTotalQtyByName(SportName);
		}

		public String doGetFilepathByID(Integer ID){
			return sportServiceMapper.fineFilepathByID(ID);
		}

}
