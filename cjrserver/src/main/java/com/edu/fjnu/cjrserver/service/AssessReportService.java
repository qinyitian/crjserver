package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.Activity;
import com.edu.fjnu.cjrserver.model.AssessReport;

import java.util.List;

/**
 * 评价报告
 * @author lm
 *
 */
public interface AssessReportService {
	/**
	 * 添加评价报告
	 * @param assessReport 评价报告
 	 */
	void doPostAssessPath(AssessReport assessReport);

	/**
	 *  根据评价机构ID查询评价报告列表
	 * @param MediaID 评价机构ID
	 * @return 评价报告列表
	 */
	List<AssessReport> doGetAssessReportByID(Integer MediaID);

	/**
	 * 查询评价报告列表
	 * @return 评价报告列表
	 */
	List<AssessReport> doGetAssessReport();

	/**
	 * 修改评价报告
	 * @param assessReport 评价报告
	 */
	void updateAssessReport(AssessReport assessReport);

	/**
	 *  根据ID查询评价报告文件路径
	 * @param AssessID ID
	 * @return 路径
	 */
	String doGetReportPathByAssessID(Integer AssessID);

	/**
	 *  删除评价报告
	 * @param AssessID 评价报告ID
	 */
	void doDelAssessReport(Integer[] AssessID);
}
