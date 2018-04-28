package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.Activity;
import com.edu.fjnu.cjrserver.model.Notice;

import java.util.List;

/**
 * 活动服务
 * @author 朱仲策
 *
 */
public interface NoticeService {
    /**
     * 返回给残疾人用过户的调查表信息列表
     * @return 通知列表
     */
	List<Notice> doGetDemandNotice(String disabilityIdentity);

}
