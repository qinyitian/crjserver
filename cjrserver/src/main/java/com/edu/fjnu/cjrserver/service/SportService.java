package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.Sport;
import com.edu.fjnu.cjrserver.model.Sport;
import com.edu.fjnu.cjrserver.model.ResultData;

import java.util.List;

/**
 * 体育服务
 * @author lm
 *
 */
public interface SportService {
    /**
     * 查询体育服务列表
     * @return 体育服务列表
     */
	List<Sport> doGetSportService();

    /**
     * 按分页查询赛事服务
     * @param pageNumber 页号
     * @param pageSize 大小
     * @return 赛事服务
     */
    List<Sport> doGetSportServiceByPage(Integer pageNumber, Integer pageSize);

    /**
     * 根据ID删除体育服务
     * @param SportServiceID ID
     */
	void doDelService(Integer[] SportServiceID);

    /**
     * 添加体育服务
     * @param sportServer 体育服务
     */
    void doAddService(Sport sportServer);

    /**
     * 根据ID查询体育服务
     * @param SportID ID
     * @return 体育服务
     */
    Sport doGetServiceByID(Integer SportID);

    /**
     *  修改体育服务
     * @param SportServer 体育服务
     */
    void updateService(Sport SportServer);

    /**
     * 根据ID查询文件路径
     * @param ID ID
     * @return 路径
     */
    String doGetFilepathByID(Integer ID);

    /**
     * 查询体育服务数量
     * @return 数量
     */
	Integer doGetTotalQty();

    /**
     * 根据名称查询体育服务数量
     * @param SportName 名称
     * @return 数量
     */
	Integer doGetTotalQtyByName(String SportName);
	
}
