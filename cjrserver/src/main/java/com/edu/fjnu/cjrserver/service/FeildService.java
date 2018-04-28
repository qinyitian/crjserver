package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.FieldServer;
import com.edu.fjnu.cjrserver.model.ResultData;

import java.util.List;

/**
 * 场地服务
 */
public interface FeildService {
    /**
     * 查询场地服务列表
     * @return 场地服务列表
     */
    List<FieldServer> doGetFieldService();

    /**
     * 按分页查询场地服务
     * @param pageNumber 页号
     * @param pageSize 大小
     * @return 场地服务
     */
    List<FieldServer> doGetFieldServiceByPage(Integer pageNumber, Integer pageSize);

//    List<FieldServer> doGetFieldServiceByName(Integer pageNumber, Integer pageSize,String FieldName);

    /**
     * 根据ID删除场地服务
     * @param FeildServiceID ID
     */
    void doDelService(Integer[] FeildServiceID);

    /**
     * 添加场地服务
     * @param fieldServer 场地服务
     */
    void doAddService(FieldServer fieldServer);

    /**
     * 根据ID查询场地服务
     * @param FiledID ID
     * @return 场地服务
     */
    FieldServer doGetServiceByID(Integer FiledID);

    /**
     * 修改场地服务
     * @param fieldServer 场地服务
     */
    void updateService(FieldServer fieldServer);

    /**
     *  根据ID查询图片路径
     * @param FiledID ID
     * @return 路径
     */
    String doGetImgPath(Integer FiledID);

    /**
     * 查询场地服务数量
     * @return 数量
     */
    Integer doGetTotalQty();

    /**
     * 根据名称查询场地服务数量
     * @param FieldName 名称
     * @return 数量
     */
    Integer doGetTotalQtyByName(String FieldName);

    /**
     * 根据三级级联城市查询场地服务
     * @param Province 省
     * @param City 市
     * @param County 县、区
     * @param pageNumber 页号
     * @param pageSize 页面大小
     * @return 查询结果
     */
    List<FieldServer> doGetFieldByAdd(String Province,String City,String County,Integer pageNumber,Integer pageSize);

    /**
     * 根据三级级联城市查询场地服务数量
     * @param Province 省
     * @param City 市
     * @param County 县，市
     * @return 数量
     */
    Integer goGetFieldByAddQty(String Province,String City,String County);
}
