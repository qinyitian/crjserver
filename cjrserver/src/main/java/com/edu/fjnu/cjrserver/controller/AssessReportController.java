package com.edu.fjnu.cjrserver.controller;


import com.edu.fjnu.cjrserver.model.AssessReport;
import com.edu.fjnu.cjrserver.model.EquipmentContent;
import com.edu.fjnu.cjrserver.model.FieldServer;
import com.edu.fjnu.cjrserver.model.Sport;
import com.edu.fjnu.cjrserver.service.ActivityService;
import com.edu.fjnu.cjrserver.service.ArtificialService;
import com.edu.fjnu.cjrserver.service.AssessReportService;
import com.edu.fjnu.cjrserver.service.DemandCatalogService;
import com.edu.fjnu.cjrserver.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 第三方评价机构管理评价报告Controller
 * Created by Administrator on 2018/2/18 0018.
 */
@RestController
@RequestMapping("/AssessReport")
public class AssessReportController {
    @Autowired
    AssessReportService assessReportService;

    /**
     * 根据评价文件ID批量删除评价报告
     * @param assessID 评价文件ID
     * @param request
     * @throws IOException
     */
    @RequestMapping(value = "/delAssessReport")
    public void delAssessReport(@RequestParam(value = "AssessID") String[] assessID,HttpServletRequest request)throws IOException{
        Integer [] ID = new Integer[assessID.length];
        for(int i=0;i<ID.length;i++){
            ID[i] = Integer.parseInt(assessID[i]);
        }
        FileUtils fileUtils = new FileUtils();
        for(int i=0;i<ID.length;i++){
            String pastFilePath = assessReportService.doGetReportPathByAssessID(ID[i]);
            fileUtils.DeleteFile(pastFilePath,request);
        }
        assessReportService.doDelAssessReport(ID);
    }

    /**
     * 修改评价报告
     * @param mediaID 第三方评价机构ID
     * @param reportType 报告类型
     * @param assessName 评价报告名称
     * @param file 文件
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping(value = "/uploadAssessReport")
    public void savePostAssessReport(@RequestParam(value = "MediaID") Integer mediaID,
                                @RequestParam(value = "ReportType") Integer reportType,
                                @RequestParam(value = "AssessName") String assessName,
                                @RequestParam(value = "AssessReport",required=false) MultipartFile file,
                                HttpServletRequest request, HttpServletResponse response, HttpSession session)throws IOException {
        AssessReport assessReport = new AssessReport();
        assessReport.setMediaID(mediaID);
        assessReport.setReportType(reportType);
        assessReport.setAssessName(assessName);
        FileUtils fileUtils = new FileUtils();
        String path = fileUtils.FileUpload(file,true,"AssessReport",request,response,session);
        assessReport.setPath(path);

        assessReportService.doPostAssessPath(assessReport);
    }

    /**
     * 根据第三方评价机构ID获得评价报告列表，评价机构使用
     * @param mediaID 评价机构ID
     * @return 返回评价报告列表
     */
    @RequestMapping(value = "/getAssessReportByID")
    public List<AssessReport> getAssessReportByID(@RequestParam(value = "MediaID") Integer mediaID){
        return assessReportService.doGetAssessReportByID(mediaID);
    }

    /**
     * 返回评价报告列表，后台使用
     * @return 评价报告列表
     */
    @RequestMapping(value = "/getAssessReport")
    public List<AssessReport> getAssessReport(){
        return assessReportService.doGetAssessReport();
    }

    /**
     * 修改评价报告
     * @param assessID 评价报告ID
     * @param mediaID 第三方评价机构ID
     * @param reportType 报告类别
     * @param assessName 报告名称
     * @param file 文件
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping(value = "/updateAssessReport")
    public void updateAssessReport(@RequestParam(value = "AssessID") Integer assessID,
                                   @RequestParam(value = "MediaID") Integer mediaID,
                                   @RequestParam(value = "ReportType") Integer reportType,
                                   @RequestParam(value = "AssessName") String assessName,
                                   @RequestParam(value = "AssessReport",required=false) MultipartFile file,
                                   HttpServletRequest request, HttpServletResponse response, HttpSession session)throws IOException{
        AssessReport assessReport = new AssessReport();
        assessReport.setAssessID(assessID);
        assessReport.setMediaID(mediaID);
        assessReport.setReportType(reportType);
        assessReport.setAssessName(assessName);
        if(file != null) {
            String pastFilePath = assessReportService.doGetReportPathByAssessID(assessID);
            FileUtils fileUtils = new FileUtils();
            String path = fileUtils.FileUpload(file,true,"AssessReport",request,response,session);
            if(path != null){
                fileUtils.DeleteFile(pastFilePath,request);
            }
            assessReport.setPath(pastFilePath);
        } else {
            assessReport.setPath(assessReportService.doGetReportPathByAssessID(assessID));
        }
        if(assessReport.getPath() != null){
            assessReportService.updateAssessReport(assessReport);
            System.out.println(assessReport.getAssessName() + "修改成功！");
        }
    }
}
