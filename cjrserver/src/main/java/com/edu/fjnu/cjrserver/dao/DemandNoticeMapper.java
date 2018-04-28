package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.Activity;
import com.edu.fjnu.cjrserver.model.Notice;

import java.util.List;

/**
 * Created by 朱仲策 on 2018/1/3 0003.
 */
public interface DemandNoticeMapper {
    /**
     * 查询推送给残疾人的调查表填写通知
     * @return 信息列表
     */
    List<Notice> findNoticeForDisable();


}
