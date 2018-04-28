package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.DemandTableForNameMapper;
import com.edu.fjnu.cjrserver.model.DemandTable;
import com.edu.fjnu.cjrserver.service.DemandNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 朱仲策 on 2018/3/24.
 */
@Service("DemandNoticeService")
public class DemandNoticeServiceImpl implements DemandNoticeService {
    @Autowired
    DemandTableForNameMapper demandTableMapper;

    public DemandTable findDemandTable(String demandtable_name) {
        return demandTableMapper.findDemandTableByName(demandtable_name);
    }
}
