package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.FieldServer;
import com.edu.fjnu.cjrserver.utils.FileUtils;

import java.util.List;

/**
 *场地服务
 */
public interface FieldServiceMapper {
    /**
     * 按分页查询场地服务
     * @param star 开头
     * @param pageSize 大小
     * @return 场地服务
     */
    List<FieldServer> findFieldServiceByPage(Integer star, Integer pageSize);

    /**
     * 查询场地服务列表
     * @return 场地服务列表
     */
    List<FieldServer> findFieldService();

//    List<FieldServer> findFieldServiceByName(Integer star, Integer pageSize,String FieldName);

    /**
     * 删除场地服务
     * @param FieldID 场地服务ID
     */
    void delFieldService(int FieldID);

    /**
     * 添加场地服务
     * @param fieldServer 场地服务
     */
    void addFieldService(FieldServer fieldServer);

    /**
     * 根据ID查询场地服务
     * @param FiledID ID
     * @return 场地服务
     */
    FieldServer getFiledServiceByID(Integer FiledID);

    /**
     * 修改场地服务
     * @param fieldServer 场地服务
     */
    void updateFieldService(FieldServer fieldServer);

    /**
     * 根据ID查询图片路径
     * @param FiledID ID
     * @return 路径
     */
    String findImgPath(Integer FiledID);

    /**
     * 查询场地服务数量
     * @return 数量
     */
    Integer findTotalQty();

    /**
     * 根据名称查询场地服务数量
     * @param FieldName 名称
     * @return 数量
     */
    Integer findTotalQtyByName(String FieldName);

    /**
     * 根据三级级联城市查询场地服务
     * @param Province 省
     * @param star 开始位置
     * @param pageSize 页面大小
     * @return 查询结果
     */
    List<FieldServer> findFieldByProvince(String Province,Integer star, Integer pageSize);

    /**
     * 根据三级级联城市查询场地服务
     * @param Province 省
     * @param City 市
     * @param star 开始位置
     * @param pageSize 页面大小
     * @return 查询结果
     */
    List<FieldServer> findFieldByPC(String Province,String City,Integer star, Integer pageSize);

    /**
     * 根据三级级联城市查询场地服务
     * @param Province 省
     * @param City 市
     * @param County 县，区
     * @param star 开始位置
     * @param pageSize 页面大小
     * @return 查询结果
     */
    List<FieldServer> findFieldByAdd(String Province,String City,String County,Integer star, Integer pageSize);

    /**
     * 根据三级级联城市查询场地服务数量
     * @param Province 省
     * @param City 市
     * @param County 县，区
     * @return 数量
     */
    Integer findFieldByAddQty(String Province,String City,String County);

    /**
     * 根据三级级联城市查询场地服务数量
     * @param Province 省
     * @return 数量
     */
    Integer findFieldByProvinceQty(String Province);

    /**
     * 根据三级级联城市查询场地服务数量
     * @param Province 省
     * @param City 市
     * @return 数量
     */
    Integer findFieldByPCQty(String Province,String City);
}
