package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.CompanyInfo;

import java.util.List;

public interface CompanyBusinessScopeService {
    /**
     * 根据经营范围查询企业信息
     * @param Scope 经营范围
     * @return 企业信息
     */
    public List<CompanyInfo> doGetCompanyInfoByScope(String Scope);
}
