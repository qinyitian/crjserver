package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.model.Company;
import com.edu.fjnu.cjrserver.model.CompanyInfo;
import com.edu.fjnu.cjrserver.model.DemandTable;

/**
 * 活动服务
 * @author 朱仲策
 *
 */
public interface CompanyRegisterService {
    /**
     * 企业注册
     * @return success or fail
     */

	Boolean exitPhone(String phone);
	Boolean exitLicense(String license);
	Boolean validInviteCode(String inviteCode);

    Boolean companyRegister(Company company, CompanyInfo companyInfo);

}
