package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.EquipmentContent;

import java.util.List;

/**
 * 体育器材
 */
public interface EquipmentContentService {
    /**
     * 按分页查询器材服务
     * @param pageNumber 页号
     * @param pageSize 大小
     * @return 器材服务
     */
    List<EquipmentContent> doGetEquipmentContentByPage(Integer pageNumber, Integer pageSize);

    /**
     * 获取体育器材列表
     * @return 体育器材列表
     */
    List<EquipmentContent> doGetEquipmentContent();

//    List<EquipmentContent> doGetEquipmentContentByName(Integer pageNumber, Integer pageSize, String DemandName);

    /**
     * 获取体育器材数量
     * @return 数量
     */
    Integer doGetTotalQty();

    /**
     * 根据名称查询体育器材数量
     * @param DemandName 名称
     * @return 数量
     */
    Integer doGetTotalQtyByName(String DemandName);

    /**
     * 删除体育器材服务
     * @param DemandID 服务ID
     */
    void doDelService(Integer[] DemandID);

    /**
     *  添加体育器材
     * @param equipmentContent 体育器材
     */
    void doAddService(EquipmentContent equipmentContent);

    /**
     *  根据ID查询体育器材
     * @param DemandID ID
     * @return 体育器材
     */
    EquipmentContent doGetServiceByID(Integer DemandID);

    /**
     * 修改体育器材
     * @param equipmentContent 体育器材
     */
    void updateService(EquipmentContent equipmentContent);

    /**
     * 根据ID查询图片路径
     * @param DemandID ID
     * @return 路径
     */
    String doGetImgPath(Integer DemandID);
}
