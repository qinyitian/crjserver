package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.DemandDictionaryMapper;
import com.edu.fjnu.cjrserver.model.Notice;
import com.edu.fjnu.cjrserver.service.DemandDictionaryNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service("DemandDictionaryNoticeService")
public class DemandDictionaryNoticeServiceImpl implements DemandDictionaryNoticeService {

    @Autowired
    DemandDictionaryMapper demandDictionaryMapper;

    public List<Notice> doGetDemandDictionaryNotice() {
        return demandDictionaryMapper.findDemandDictionaryNotice();
    }
}
