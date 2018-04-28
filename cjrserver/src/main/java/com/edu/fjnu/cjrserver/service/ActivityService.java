package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.Activity;

import java.util.List;

/**
 * 活动服务
 * @author lm
 *
 */
public interface ActivityService {
    /**
     * 返回活动服务列表
     * @return 活动服务列表
     */
	List<Activity> doGetActivityService();

    /**
     * 按分页查询活动服务
     * @param pageNumber 页号
     * @param pageSize 大小
     * @return 活动服务
     */
    List<Activity> doGetActivityServiceByPage(Integer pageNumber, Integer pageSize);

    /**
     *  根据ID删除活动服务
     * @param ActivityServiceID 活动服务ID
     */
    void doDelService(Integer[] ActivityServiceID);

    /**
     * 添加活动服务
     * @param activityServer 活动服务类
     */
    void doAddService(Activity activityServer);

    /**
     * 根据ID查询活动服务
     * @param ActivityID 活动服务ID
     * @return 活动服务
     */
    Activity doGetServiceByID(Integer ActivityID);

    /**
     * 修改活动服务
     * @param ActivityServer 活动服务类
     */
    void updateService(Activity ActivityServer);

    /**
     * 根据ID获取文件路径
     * @param ID 服务ID
     * @return 路径名
     */
    String doGetFilePathByID(Integer ID);

    /**
     * 获取活动服务数量
     * @return 数量
     */
    Integer doGetTotalQty();

    /**
     *  根据服务名称查询活动服务数量
     * @param ActivityName 活动服务名称
     * @return 数量
     */
    Integer doGetTotalQtyByName(String ActivityName);

    /**
     * 根据三级级联城市查询活动服务
     * @param Province 省
     * @param City 市
     * @param County 县、区
     * @param pageNumber 页号
     * @param pageSize 页面大小
     * @return 查询结果
     */
    List<Activity> doGetActivityByAdd(String Province,String City,String County,Integer pageNumber,Integer pageSize);

    /**
     * 根据三级级联城市查询活动服务数量
     * @param Province 省
     * @param City 市
     * @param County 县，市
     * @return 数量
     */
    Integer goGetActivityByAddQty(String Province,String City,String County);
}
