package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.Sport;

import java.util.List;

/**
 * 赛事服务
 * Created by Administrator on 2018/1/3 0003.
 */
public interface SportServiceMapper {
    /**
     *查询赛事服务列表
     * @return 赛事服务列表
     */
    List<Sport> findSportService();

    /**
     * 按分页查询赛事服务
     * @param star 开始
     * @param pageSize 大小
     * @return 赛事服务
     */
    List<Sport> findSportServiceByPage(Integer star, Integer pageSize);

    /**
     * 删除赛事服务
     * @param SportID 赛事服务ID
     */
    void delSportService(int SportID);

    /**
     *添加赛事服务
     * @param sportServer 赛事服务服务
     */
    void addSportService(Sport sportServer);

    /**
     * 根据ID获取赛事服务
     * @param SportID ID
     * @return 赛事服务
     */
    Sport getSportServiceByID(Integer SportID);

    /**
     * 修改赛事服务
     * @param sportServer 赛事服务
     */
    void updateSportService(Sport sportServer);

    /**
     * 查询赛事服务数量
     * @return 数量
     */
    Integer findTotalQty();

    /**
     *根据赛事服务名称查询数量
     * @param SportName 名称
     * @return 数量
     */
    Integer findTotalQtyByName(String SportName);

    /**
     *  根据ID查询赛事服务文件路径
     * @param ID ID
     * @return 路径
     */
    String fineFilepathByID(Integer ID);
}
