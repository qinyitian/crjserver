package com.edu.fjnu.cjrserver.test;

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
public class NoticeServiceTest {

    @Resource
    NoticeService noticeService;
    @Test
    public void doGetDemandNotice() {
        System.out.println(noticeService.doGetDemandNotice("110"));
    }

}