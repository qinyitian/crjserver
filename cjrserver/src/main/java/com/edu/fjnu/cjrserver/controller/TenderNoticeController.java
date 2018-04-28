package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.Notice;
import com.edu.fjnu.cjrserver.service.DemandDictionaryNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 朱仲 on 2018/3/24.
 */
@RestController
@RequestMapping("/demanddictionary")
public class TenderNoticeController {

    @Autowired
    DemandDictionaryNoticeService demandDictionaryNoticeService;
    /**
     * 发怒hi需求目录通知列表
     * @return
     */
    @RequestMapping("/notice")
    public List<Notice> pushDemandTable(){
        return demandDictionaryNoticeService.doGetDemandDictionaryNotice();
    }
}
