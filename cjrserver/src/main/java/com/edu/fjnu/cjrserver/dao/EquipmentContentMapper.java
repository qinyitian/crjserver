package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.EquipmentContent;

import java.util.List;

/**
 * 器材服务
 */
public interface EquipmentContentMapper {

    /**
     * 删除器材服务
     * @param DemandID ID
     */
    void delEquipmentContent(Integer DemandID);

    /**
     * 添加器材服务
     * @param equipmentContent 器材服务
     */
    void addEquipmentContent(EquipmentContent equipmentContent);

    /**
     * 根据ID获取器材服务
     * @param DemandID
     * @return
     */
    EquipmentContent getEquipmentContentById(Integer DemandID);

    /**
     * 修改器材服务
     * @param equipmentContent 器材服务
     */
    void updateEquipmentContent(EquipmentContent equipmentContent);

    /**
     * 根据器材服务ID查询图片路径
     * @param DemandID ID
     * @return 路径
     */
    String findImgPath(Integer DemandID);

    /**
     * 查询器材服务数量
     * @return 数量
     */
    Integer findTotalQty(); //查找总条数

    /**
     * 根据名称查询器材服务数量
     * @param DemandName 名称
     * @return 数量
     */
    Integer findTotalQtyByName(String DemandName);//根据名称查找总条数

    /**
     * 按分页查询器材服务
     * @param star 开头
     * @param pageSize 大小
     * @return 器材服务
     */
    List<EquipmentContent> findEquipmentContentServiceByPage(Integer star, Integer pageSize);

    /**
     * 查询器材服务列表
     * @return 器材服务列表
     */
    List<EquipmentContent> findEquipmentContentService();

//    List<EquipmentContent> findEquipmentContentServiceByName(Integer star, Integer pageSize, String DemandName);
}
