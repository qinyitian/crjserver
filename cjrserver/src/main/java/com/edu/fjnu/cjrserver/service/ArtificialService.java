package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.Artificial;

import java.util.List;

/**
 * 人工服务
 */
public interface ArtificialService {
    /**
     * 按分页获取人工服务表
     * @param pageNumber 页号
     * @param pageSize 数量
     * @return 人工服务列表
     */
    List<Artificial> doGetArtificialService(Integer pageNumber, Integer pageSize);

    /**
     * 获取人工服务列表
     * @return 人工服务列表
     */
    List<Artificial> doGetArtificialService();

//    List<Artificial> doGetArtificialServiceByName(Integer pageNumber, Integer pageSize, String ArtificialName);

    /**
     * 获取人工服务数量
     * @return 数量
     */
    Integer doGetTotalQty();

    /**
     * 根据名称查询人工服务数量
     * @param ArtificialName 名称
     * @return 数量
     */
    Integer doGetTotalQtyByName(String ArtificialName);

   // List<Artificial> doGetArtificialService();

    /**
     * 根据ID删除人工服务
     * @param ArtificialID 人工服务ID
     */
    void doDelService(Integer[] ArtificialID);

    /**
     * 添加人工服务
     * @param artificial 人工服务
     */
    void doAddService(Artificial artificial);

    /**
     * 根据ID查询人工服务
     * @param ArtificialID ID
     * @return 人工服务
     */
    Artificial doGetServiceByID(Integer ArtificialID);

    /**
     * 修改人工服务
     * @param Artificial 人工服务
     */
    void updateService(Artificial Artificial);

    /**
     *  根据ID查询路径
     * @param ArtificialID ID
     * @return 路径
     */
   String doGetFilePath(Integer ArtificialID);

}
