package com.edu.fjnu.cjrserver.service;


import com.edu.fjnu.cjrserver.model.Media;
import com.edu.fjnu.cjrserver.model.MediaInfo;


/**
 * 媒体注册
 * @author 朱仲策
 *
 */
public interface MediaRegisterService {
    /**
     * 企业注册
     * @return success or fail
     */

    //验证电话
	Boolean exitPhone(String phone);
	//验证邀请码
	Boolean validInviteCode(String inviteCode);
	//添加新媒体用户
    Boolean meidaRegister(Media media, MediaInfo mediaInfo);


}
