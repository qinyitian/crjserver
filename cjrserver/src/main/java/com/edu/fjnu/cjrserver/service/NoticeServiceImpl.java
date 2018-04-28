package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.DemandNoticeMapper;
import com.edu.fjnu.cjrserver.model.Notice;
import com.edu.fjnu.cjrserver.service.VoteDemandService;
import com.edu.fjnu.cjrserver.service.DemandNoticeService;
import com.edu.fjnu.cjrserver.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱仲策 on 2018/3/24.
 */
@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    DemandNoticeMapper demandNoticeMapper;
    @Autowired
    VoteDemandService voteDemandService;
    @Autowired
    DemandNoticeService demandTableService;

    public List<Notice> doGetDemandNotice(String disabilityIdentity) {
        List<Notice> noticelist = demandNoticeMapper.findNoticeForDisable();
        List<Notice> unPushNoticeList = new ArrayList<Notice>();
        for(int i = 0;i<noticelist.size();i++){
            if( !voteDemandService.JudgeExitMsg(
                    disabilityIdentity,demandTableService.findDemandTable(
                            noticelist.get(i).getNoticeTitle()).getDemandTableID())){
                unPushNoticeList.add(noticelist.get(i));
            }
        }
        return unPushNoticeList;
    }
}
