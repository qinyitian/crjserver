package com.edu.fjnu.cjrserver.controller;


import com.edu.fjnu.cjrserver.model.CompanyInfo;
import com.edu.fjnu.cjrserver.service.CompanyBusinessScopeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/CompanyScope")
public class CompanyBusinessScopeController {
    CompanyBusinessScopeService companyBusinessScopeService;
    /**
     * 根据经营范围查询企业信息
     * @param BusinessScope 经营范围，以逗号分隔
     * @return 企业信息表
     */
    @RequestMapping(value = "/findCompanyInfo")
    public List<CompanyInfo> searchCompanyByScope(@RequestParam(value = "BusinessScope") String BusinessScope){
        String[] Scopes = BusinessScope.split(",");
        List<CompanyInfo> result = new ArrayList<CompanyInfo>();
        for (int i=0;i<Scopes.length;i++){
            result.addAll(companyBusinessScopeService.doGetCompanyInfoByScope(Scopes[i]));
        }
        return result;
    }
}
