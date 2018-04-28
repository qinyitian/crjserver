package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.Artificial;
import java.util.List;
public interface ArtificialServiceMapper {


    /**
     * 根据ID删除人工服务
     * @param ArtificialID ID
     */
    void delArtificialService(Integer ArtificialID);

    /**
     *  添加人工服务信息
     * @param artificialService 人工服务
     */
    void addArtificialService(Artificial artificialService);

    /**
     *  根据ID查询人工服务
     * @param ArtificialID ID
     * @return 人工服务
     */
    Artificial getArtificialServiceByID(Integer ArtificialID);

    /**
     *  修改人工服务
     * @param artificialService 人工服务
     */
    void updateArtificialService(Artificial artificialService);

    /**
     *  根据ID查询文件路径
     * @param ArtificialID ID
     * @return 路径
     */
    String findFilePath(Integer ArtificialID);

    /**
     * 查询人工服务数量
     * @return 数量
     */
    Integer findTotalQty(); //查找总条数

    /**
     * 根据名称查询人工服务数量
     * @param ArtificialName 名称
     * @return 数量
     */
    Integer findTotalQtyByName(String ArtificialName); //根据名称查找总条数

    /**
     * 分页获取人工服务
     * @param star 开头
     * @param pageSize 数量
     * @return
     */
    List<Artificial> findArtificialServiceByPage(Integer star, Integer pageSize);

    /**
     * 查询人工服务列表
     * @return 人工服务列表
     */
    List<Artificial> findArtificialService();

//    /**
//     * 分页获取人工服务
//     * @param star 开头
//     * @param pageSize 数量
//     * @param ArtificialName 名称
//     * @return
//     */
//    List<Artificial> findArtificialServiceByName(Integer star, Integer pageSize, String ArtificialName);

}
