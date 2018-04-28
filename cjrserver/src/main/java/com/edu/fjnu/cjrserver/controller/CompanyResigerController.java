package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.Company;
import com.edu.fjnu.cjrserver.model.CompanyInfo;
import com.edu.fjnu.cjrserver.model.Notice;
import com.edu.fjnu.cjrserver.service.CompanyRegisterService;
import com.edu.fjnu.cjrserver.service.DemandDictionaryNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 朱仲 on 2018/3/24.
 */
@RestController
@RequestMapping("/company/register")
public class CompanyResigerController {

    @Autowired
    CompanyRegisterService companyRegisterService;
    /**
     * 手机号验证
     * @return "exit":"nonexit"
     */
    @RequestMapping("/judgephone")
    public String judgePhone(@RequestParam("phone") String phone){
        return companyRegisterService.exitPhone(phone)?"exit":"nonexit";
    }

    /**
     * 邀请码验证
     * @return
     */
    @RequestMapping("/judgeinvitecode")
    public String judgeInviteCode(@RequestParam("invitecode") String invitecode){
        return companyRegisterService.validInviteCode(invitecode)?"valid":"invalid";
    }
    /**
     * 营业执照验证
     * @return
     */
    @RequestMapping("/judgelicense")
    public String judgeLicense(@RequestParam("license") String license){
        return companyRegisterService.exitLicense(license)?"exit":"nonexit";
    }
    /**
     * 添加信息
     * @return
     */
    @RequestMapping("/postinfo")
    public String postInfo(@RequestParam("company_password") String company_password,@RequestParam("company_name") String company_name,
                           @RequestParam("company_inviteCode") String company_inviteCode,@RequestParam("business_license") String business_license,
                           @RequestParam("phone") String phone,@RequestParam("company_address") String company_address,
                           @RequestParam("company_email") String company_email,@RequestParam("company_businessscope") String company_businessscope){
        Company company = new Company();
        company.setState(0);
        company.setPhone(phone);
        company.setCompanyPassword(company_password);
        company.setCompanyName(company_name);
        company.setCompanyInviteCode(company_inviteCode);

        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyBusinessScope(company_businessscope);
        companyInfo.setCompanyAddress(company_address);
        companyInfo.setCompanyEmail(company_email);
        companyInfo.setCompanyName(company_name);
        companyInfo.setBusinessLicense(business_license);

        return companyRegisterService.companyRegister(company,companyInfo)?"success":"fail";
    }
}
