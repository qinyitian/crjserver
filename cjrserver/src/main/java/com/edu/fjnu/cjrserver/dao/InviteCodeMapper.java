package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.InviteCode;

/**
 * Created by 朱仲策 on 2018/1/3 0003.
 */
public interface InviteCodeMapper {
    /**
     * 邀请码信息
     * @return 信息列表
     */
    //设置状态
    Integer setInviteCodeState(String inviteCode);

    //查看是否存在，已用
    InviteCode findInviteCode(String inviteCode);

}
