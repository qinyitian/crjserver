package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.InviteCodeMapper;
import com.edu.fjnu.cjrserver.dao.MediaRegisterMapper;
import com.edu.fjnu.cjrserver.model.Media;
import com.edu.fjnu.cjrserver.model.MediaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 朱仲策 on 2018/3/24.
 */
@Service("MeidaRegisterService")
public class MeidaRegisterServiceImpl implements MediaRegisterService {
    @Autowired
    MediaRegisterMapper mediaRegisterMapper;
    @Autowired
    InviteCodeMapper inviteCodeMapper;


    public Boolean exitPhone(String phone) {
        return mediaRegisterMapper.findMediaByPhone(phone)!=null?true:false;
    }

    public Boolean validInviteCode(String inviteCode) {
        if(inviteCodeMapper.findInviteCode(inviteCode)!=null){
            return inviteCodeMapper.findInviteCode(inviteCode).getState()==0?true:false;
        }
        else
            return false;
    }

    public Boolean meidaRegister(Media media, MediaInfo mediaInfo) {

        return mediaRegisterMapper.addNewMediaInfo(mediaInfo)!=0&&mediaRegisterMapper.addNewMedia(media)!=0
                &&inviteCodeMapper.setInviteCodeState(media.getInviteCode())==null?true:false;
    }
}
