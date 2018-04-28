package com.edu.fjnu.cjrserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    /**
     *
     * @return 主页：Admin_Index
     */
    @RequestMapping(value = "/View")
    public ModelAndView getAdminView(){
            return new ModelAndView(new RedirectView("/Admin_Index.html"));
    }
    /**
     *
     * @param act 活动：activity_service，人工：artificial_service，场地：field_service，器材：equipment_service，体育赛事：sport_service
     * @return
     */
    @RequestMapping(value = "/Service")
    public ModelAndView getAdminServiceView(@RequestParam(value = "act") String act){
        if(act.equals("activity"))
            return new ModelAndView(new RedirectView("System_Service/activity_service.html"));
        else if(act.equals("artificial"))
            return new ModelAndView(new RedirectView("System_Service/artificial_service.html"));
        else if(act.equals("field_service"))
            return new ModelAndView(new RedirectView("System_Service/field_service.html"));
        else if(act.equals("equipmentContent"))
            return new ModelAndView(new RedirectView("System_Service/equipment_service.html"));
        else if(act.equals("sport"))
            return new ModelAndView(new RedirectView("System_Service/sport_service.html"));
        else
            return new ModelAndView(new RedirectView("System_Service/404.html"));
    }
    /**
     *
     * @param act 发布需求调查表：demand_table_input，查看需求调查表：demand_table_list
     * @return
     */
    @RequestMapping(value = "/Demand")
    public ModelAndView getAdminDemandView(@RequestParam(value = "act") String act){
        if(act.equals("releaseDemandTable"))
            return new ModelAndView(new RedirectView("System_Demand/activity_service.html"));
        else if(act.equals("showDemandTable"))
            return new ModelAndView(new RedirectView("System_Demand/artificial_service.html"));
        else
            return new ModelAndView(new RedirectView("404.html"));
    }
    /**
     *
     * @param act 发布招标计划：publish_tender_plan，公布招标结果：tender_form，查看招标结果：BidingResult，
     * @return
     */
    @RequestMapping(value = "/Tender")
    public ModelAndView getAdminTenderView(@RequestParam(value = "act") String act){
        if(act.equals("publishTender"))
            return new ModelAndView(new RedirectView("System_TenderPlan/publish_tender_plan.html"));
        else if(act.equals("tenderFrom"))
            return new ModelAndView(new RedirectView("System_TenderPlan/tender_form.html"));
        else if(act.equals("bidingResult"))
            return new ModelAndView(new RedirectView("System_TenderPlan/BidingResult.html"));
        else
            return new ModelAndView(new RedirectView("404.html"));
    }
}
