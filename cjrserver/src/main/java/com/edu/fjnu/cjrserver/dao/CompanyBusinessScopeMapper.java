package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.CompanyInfo;

import java.util.List;

public interface CompanyBusinessScopeMapper {
    /**
     * 根据经营范围查询企业信息
     * @param Scope 经营范围
     * @return 企业信息
     */
    public List<CompanyInfo> findCompanyInfoByScope(String Scope);
}
