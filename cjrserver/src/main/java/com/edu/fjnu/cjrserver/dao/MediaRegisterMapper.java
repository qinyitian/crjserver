package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.*;

/**
 * Created by 朱仲策 on 2018/1/3 0003.
 */
public interface MediaRegisterMapper {
    /**
     * 媒体注册信息判断
     * @return 信息列表
     */
    Media findMediaByPhone(String phone);


    /**
     * 注册信息录入
     * @return 0，1
     */
    int addNewMedia(Media media);
    int addNewMediaInfo(MediaInfo mediaInfo);
}
