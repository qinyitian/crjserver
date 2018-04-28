package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.CompanyBusinessScopeMapper;
import com.edu.fjnu.cjrserver.model.CompanyInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CompanyBusinessScopeService")
public class CompanyBusinessScopeServiceImpl implements CompanyBusinessScopeService{
    CompanyBusinessScopeMapper companyBusinessScopeMapper;
    public List<CompanyInfo> doGetCompanyInfoByScope(String Scope) {
        return companyBusinessScopeMapper.findCompanyInfoByScope(Scope);
    }
}
