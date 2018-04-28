package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.Activity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3 0003.
 */
public interface ActivityServiceMapper {
    /**
     * 查询活动服务列表
     * @return 活动服务列表
     */
    List<Activity> findActivityService();

    /**
     * 按分页查询活动服务
     * @param star 开始
     * @param pageSize 大小
     * @return 活动服务
     */
    List<Activity> findActivityServiceByPage(Integer star, Integer pageSize);

    /**
     * 删除活动服务
     * @param ActivityID 活动服务ID
     */
    void delActivityService(int ActivityID);

    /**
     * 添加活动服务
     * @param activityServer 活动服务
     */
    void addActivityService(Activity activityServer);

    /**
     *  根据ID查询活动服务
     * @param ActivityID ID
     * @return 活动服务
     */
    Activity getActivityServiceByID(Integer ActivityID);

    /**
     * 修改活动服务
     * @param activityServer 活动服务
     */
    void updateActivityService(Activity activityServer);

    /**
     * 根据ID查询文件路径
     * @param ID ID
     * @return 路径
     */
    String findFilepathByID(Integer ID);

    /**
     * 获取活动服务数量
     * @return 数量
     */
    Integer findTotalQty();

    /**
     * 根据名称获取活动服务数量
     * @param ActivityName 名称
     * @return 数量
     */
    Integer findTotalQtyByName(String ActivityName);
    /**
     * 根据三级级联城市查询活动服务
     * @param Province 省
     * @param star 开始位置
     * @param pageSize 页面大小
     * @return 查询结果
     */
    List<Activity> findActivityByProvince(String Province,Integer star, Integer pageSize);

    /**
     * 根据三级级联城市查询活动服务
     * @param Province 省
     * @param City 市
     * @param star 开始位置
     * @param pageSize 页面大小
     * @return 查询结果
     */
    List<Activity> findActivityByPC(String Province,String City,Integer star, Integer pageSize);

    /**
     * 根据三级级联城市查询活动服务
     * @param Province 省
     * @param City 市
     * @param County 县，区
     * @param star 开始位置
     * @param pageSize 页面大小
     * @return 查询结果
     */
    List<Activity> findActivityByAdd(String Province,String City,String County,Integer star, Integer pageSize);

    /**
     * 根据三级级联城市查询活动服务数量
     * @param Province 省
     * @param City 市
     * @param County 县，区
     * @return 数量
     */
    Integer findActivityByAddQty(String Province,String City,String County);

    /**
     * 根据三级级联城市查询活动服务数量
     * @param Province 省
     * @return 数量
     */
    Integer findActivityByProvinceQty(String Province);

    /**
     * 根据三级级联城市查询活动服务数量
     * @param Province 省
     * @param City 市
     * @return 数量
     */
    Integer findActivityByPCQty(String Province,String City);
}
