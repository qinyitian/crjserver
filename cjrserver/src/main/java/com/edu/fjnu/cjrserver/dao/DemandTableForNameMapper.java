package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.DemandTable;
import com.edu.fjnu.cjrserver.model.Notice;

import java.util.List;

/**
 * Created by 朱仲策 on 2018/1/3 0003.
 */
public interface DemandTableForNameMapper {
    /**
     * 通过调查表名字寻找调查表
     * @return 调查表
     */
    DemandTable findDemandTableByName(String DemandTable_Name);

}
