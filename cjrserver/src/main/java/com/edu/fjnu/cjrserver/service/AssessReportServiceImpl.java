package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.ActivityServiceMapper;
import com.edu.fjnu.cjrserver.dao.AssessReportMapper;
import com.edu.fjnu.cjrserver.model.Activity;
import com.edu.fjnu.cjrserver.model.AssessReport;
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
@Service("AssessReportService")
public class AssessReportServiceImpl implements AssessReportService {

	@Autowired
    AssessReportMapper assessReportMapper;


    public void doPostAssessPath(AssessReport assessReport) {
        assessReportMapper.insertAssessReport(assessReport);
    }


    public List<AssessReport> doGetAssessReportByID(Integer MediaID) {
        return assessReportMapper.findAssessReportByID(MediaID);
    }


    public List<AssessReport> doGetAssessReport() {
        return assessReportMapper.findAssessReport();
    }


    public void updateAssessReport(AssessReport assessReport) {
        assessReportMapper.updateAssessReport(assessReport);
    }


    public String doGetReportPathByAssessID(Integer AssessID) {
        return assessReportMapper.getReportPathByAssesID(AssessID);
    }

    public void doDelAssessReport(Integer[] ID) {
        for(Integer AssessID:ID){
            assessReportMapper.deleteAssessReport(AssessID);
        }
    }

}
