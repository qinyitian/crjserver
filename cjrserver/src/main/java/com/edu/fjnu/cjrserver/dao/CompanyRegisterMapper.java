package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.Company;
import com.edu.fjnu.cjrserver.model.CompanyInfo;


import java.util.List;

/**
 * Created by 朱仲策 on 2018/1/3 0003.
 */
public interface CompanyRegisterMapper {
    /**
     * 企业注册信息判断
     * @return 信息列表
     */
    Company findComapanyByPhone(String phone);
    CompanyInfo findComapanyByLicense(String license);

    /**
     * 注册信息录入
     * @return 0，1
     */
    int addNewCompany(Company company);
    int addNewCompanyInfo(CompanyInfo companyInfo);
}
