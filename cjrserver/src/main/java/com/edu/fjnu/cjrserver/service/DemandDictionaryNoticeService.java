package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.Notice;

import java.util.List;

/**
 * 活动服务
 * @author 朱仲策
 *
 */
public interface DemandDictionaryNoticeService {
    /**
     * 返回需求目录通知列表
     * @return 通知列表
     */
	List<Notice> doGetDemandDictionaryNotice();

}
