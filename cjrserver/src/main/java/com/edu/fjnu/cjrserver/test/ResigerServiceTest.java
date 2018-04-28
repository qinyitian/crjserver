package com.edu.fjnu.cjrserver.test;

import com.edu.fjnu.cjrserver.dao.InviteCodeMapper;
import com.edu.fjnu.cjrserver.dao.MediaRegisterMapper;
import com.edu.fjnu.cjrserver.model.Company;
import com.edu.fjnu.cjrserver.model.CompanyInfo;
import com.edu.fjnu.cjrserver.model.Media;
import com.edu.fjnu.cjrserver.model.MediaInfo;
import com.edu.fjnu.cjrserver.service.CompanyRegisterService;
import com.edu.fjnu.cjrserver.service.MediaRegisterService;
import com.edu.fjnu.cjrserver.service.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 朱仲策 on 2018/3/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-*.xml")
public class ResigerServiceTest {

    @Resource
    CompanyRegisterService companyRegisterService;
    @Resource
    MediaRegisterService mediaRegisterService;
    @Resource
    InviteCodeMapper inviteCodeMapper;

    /**
     * 测试电话验证  企业 & 媒体
     */
    @Test
    public void testPhone() {
        System.out.println(companyRegisterService.exitPhone("1"));
        System.out.println(companyRegisterService.exitPhone("0"));
        System.out.println(mediaRegisterService.exitPhone("1"));
        System.out.println(mediaRegisterService.exitPhone("0"));
    }

    /**
     * 测试营业执照  企业
     */
    @Test
    public void testLicense(){
        System.out.println(companyRegisterService.exitLicense("1"));
        System.out.println(companyRegisterService.exitLicense("0"));
    }

    /**
     * 测试录入
     */
    @Test
    public void testAddCompany(){
        Company company = new Company();
        company.setCompanyInviteCode("1100110011");
        company.setCompanyName("王友山公司");
        company.setCompanyPassword("100");
        company.setPhone("101");
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setBusinessLicense("111");
        companyInfo.setCompanyName("王友山公司");
        companyInfo.setCompanyEmail("244004@qq.com");
        companyInfo.setCompanyAddress("南京泰妮菲路11号");
        companyInfo.setCompanyBusinessScope("器材活动");
        System.out.println(companyRegisterService.companyRegister(company,companyInfo));

    }
    @Test
    public void testAddMedia(){
        Media media = new Media();
        media.setInviteCode("1000100010");
        media.setMediaName("大众");
        media.setPassword("666");
        media.setPhone("3521");
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.setAddress("海南汪裕泰路999号");
        mediaInfo.setEmail("2300393@qq.com");
        mediaInfo.setMediaName("大众");
        mediaInfo.setIntroduction("6666666");
        System.out.println(mediaRegisterService.meidaRegister(media,mediaInfo));

    }
//    @Test
//    public void testInviteCodeUpdate(){
//        System.out.println(inviteCodeMapper.setInviteCodeState("z"));
//    }

}