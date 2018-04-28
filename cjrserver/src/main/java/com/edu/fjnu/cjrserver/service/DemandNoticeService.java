package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.DemandTable;
import com.edu.fjnu.cjrserver.model.Notice;

import java.util.List;

/**
 * 活动服务
 * @author 朱仲策
 *
 */
public interface DemandNoticeService {
    /**
     * 通过名字查询调查表
     * @return 调查表
     */
	DemandTable findDemandTable(String demandtable_name);

}
