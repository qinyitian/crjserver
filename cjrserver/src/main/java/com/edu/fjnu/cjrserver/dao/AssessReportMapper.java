package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.AssessReport;
import com.edu.fjnu.cjrserver.model.EquipmentContent;
import com.edu.fjnu.cjrserver.model.FieldServer;
import com.edu.fjnu.cjrserver.model.Sport;
import com.edu.fjnu.cjrserver.service.ActivityService;
import com.edu.fjnu.cjrserver.service.ArtificialService;

import java.util.List;

/**
 * 评价报告
 * Created by Administrator on 2018/1/3 0003.
 */
public interface AssessReportMapper {
    /**
     * 添加评价报告
     * @param assessReport  评价报告
     */
    void insertAssessReport(AssessReport assessReport);

    /**
     *根据评价机构ID查询评价报告
     * @param MediaID ID
     * @return 评价报告列表
     */
    List<AssessReport> findAssessReportByID(Integer MediaID);

    /**
     * 查询评价报告
     * @return 评价报告列表
     */
    List<AssessReport> findAssessReport();

    /**
     * 修改评价报告
     * @param assessReport 评价报告
     */
    void updateAssessReport(AssessReport assessReport);

    /**
     * 根据评价报告ID查询评价文件路径
     * @param AssessID ID
     * @return 路径
     */
    String getReportPathByAssesID(Integer AssessID);

    /**
     * 删除评价报告
     * @param AssessID 评价报告ID
     */
    void deleteAssessReport(Integer AssessID);
}
