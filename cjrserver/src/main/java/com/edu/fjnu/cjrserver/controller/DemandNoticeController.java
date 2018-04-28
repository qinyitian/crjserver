package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.Notice;
import com.edu.fjnu.cjrserver.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 朱仲 on 2018/3/24.
 */
@RestController
@RequestMapping("/demand")
public class DemandNoticeController {

    @Autowired
    NoticeService noticeService;

    /**
     * 返回残疾人用户的调查表填写通知，已在service层实现判断是否填写过
     * @param disabilityIdentity
     * @return
     */
    @RequestMapping(value = "/notice")
    public List<Notice> pushDemandTable(@RequestParam("disabilityIdentity") String disabilityIdentity){
        System.err.println("+++++++++++++++++++++++++++"+noticeService.doGetDemandNotice(disabilityIdentity));
        return noticeService.doGetDemandNotice(disabilityIdentity);
    }
}
