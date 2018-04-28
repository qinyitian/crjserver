package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.CompanyRegisterMapper;
import com.edu.fjnu.cjrserver.dao.DemandTableForNameMapper;
import com.edu.fjnu.cjrserver.dao.InviteCodeMapper;
import com.edu.fjnu.cjrserver.model.Company;
import com.edu.fjnu.cjrserver.model.CompanyInfo;
import com.edu.fjnu.cjrserver.model.DemandTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 朱仲策 on 2018/3/24.
 */
@Service("CompanyRegisterService")
public class CompanyRegisterServiceImpl implements CompanyRegisterService {
    @Autowired
    CompanyRegisterMapper companyRegisterMapper;
    @Autowired
    InviteCodeMapper inviteCodeMapper;


    public Boolean exitPhone(String phone) {
        return companyRegisterMapper.findComapanyByPhone(phone)!=null?true:false;
    }

    public Boolean exitLicense(String license) {
        return companyRegisterMapper.findComapanyByLicense(license)!=null?true:false;
    }

    public Boolean validInviteCode(String inviteCode) {
        if(inviteCodeMapper.findInviteCode(inviteCode)!=null){
            return inviteCodeMapper.findInviteCode(inviteCode).getState()==0?true:false;
        }
        else
            return false;
    }

    public Boolean companyRegister(Company company, CompanyInfo companyInfo) {

        return companyRegisterMapper.addNewCompanyInfo(companyInfo)!=0 && companyRegisterMapper.addNewCompany(company)!=0
                && inviteCodeMapper.setInviteCodeState(company.getCompanyInviteCode())==null?true:false;
    }
}
