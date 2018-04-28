package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.Company;
import com.edu.fjnu.cjrserver.model.CompanyInfo;
import com.edu.fjnu.cjrserver.model.Media;
import com.edu.fjnu.cjrserver.model.MediaInfo;
import com.edu.fjnu.cjrserver.service.CompanyRegisterService;
import com.edu.fjnu.cjrserver.service.MediaRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 朱仲 on 2018/3/24.
 */
@RestController
@RequestMapping("/media/register")
public class MediaResigerController {

    @Autowired
    MediaRegisterService mediaRegisterService;
    /**
     * 手机号验证
     * @return "exit":"nonexit"
     */
    @RequestMapping("/judgephone")
    public String judgePhone(@RequestParam("phone") String phone){
        return mediaRegisterService.exitPhone(phone)?"exit":"nonexit";
    }

    /**
     * 邀请码验证
     * @return
     */
    @RequestMapping("/judgeinvitecode")
    public String judgeInviteCode(@RequestParam("invitecode") String invitecode){
        return mediaRegisterService.validInviteCode(invitecode)?"valid":"invalid";
    }

    /**
     * 添加信息
     * @return
     */
    @RequestMapping("/postinfo")
    public String postInfo(@RequestParam("phone") String phone,@RequestParam("password") String password,
                           @RequestParam("invite_code") String invite_code,@RequestParam("media_name") String media_name,
                           @RequestParam("address") String address,@RequestParam("email") String email,
                           @RequestParam("introduction") String introduction){
        Media media = new Media();
        media.setPhone(phone);
        media.setPassword(password);
        media.setMediaName(media_name);
        media.setInviteCode(invite_code);

        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.setIntroduction(introduction);
        mediaInfo.setMediaName(media_name);
        mediaInfo.setEmail(email);
        mediaInfo.setAddress(address);
        return mediaRegisterService.meidaRegister(media,mediaInfo)?"success":"fail";
    }
}
