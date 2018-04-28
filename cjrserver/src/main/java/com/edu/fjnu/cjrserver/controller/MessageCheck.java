package com.edu.fjnu.cjrserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.fjnu.cjrserver.utils.SendCode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.internal.cmm.SystemResourcePressureImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 朱仲策 on 2018/4/25.
 */
@RestController
@RequestMapping("/utils/register")
public class MessageCheck {

    @RequestMapping(value="/sendmessage")
    public String sendCode(@RequestParam("phone") String phone, HttpServletRequest httpServletRequest) {
        String result = null;
        int Random  = (int) ((Math.random()*9+1)*100000);//随机生成的6位数（验证码）
        System.out.println(" : "+Random);

        //调用封装的工具类SendCode  返回验证码
        SendCode s = new SendCode();
        try {
            result = s.send(phone, Random);
        }catch (Exception e){
            e.printStackTrace();
        }

       // result = "{'code':200}";
        JSONObject obj = JSONObject.parseObject(result);
        System.out.println(result);

        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("msgcode",obj.get("obj").toString());
        //五分钟有效
        httpSession.setMaxInactiveInterval(60*5);
        System.out.println(obj.get("obj").toString());
        if(obj.get("code").toString().contains("200")){
            return "success";
        }else {
            return "fail";
        }
//        return "success";
    }

    @RequestMapping(value="/judgemsgcode")
    public String judgeCode(@RequestParam("msgcode") String msgcode,HttpServletRequest request){
        HttpSession  session = request.getSession();//设置session
        String sessioncode = session.getAttribute("msgcode").toString();
        System.out.println("验证码: "+sessioncode);
        if(sessioncode.equals(msgcode)){
            return "right";
        }else {
            return "error";
        }
//        return "right";
    }
}

