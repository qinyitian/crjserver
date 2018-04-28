package com.edu.fjnu.cjrserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/Company")
public class CompanyController {
    /**
     *
     * @param act 主页：company_index,参加招标计划：company_attend_plan，
     * @return
     */
    @RequestMapping(value = "/View")
    public ModelAndView getCompanyView(@RequestParam(value = "act") String act){
        if (act.equals("index"))
            return new ModelAndView(new RedirectView("System_Company/company_index.html"));
        else if(act.equals("AttendPlan"))
            return new ModelAndView(new RedirectView("System_Company/company_attend_plan.html"));
        else
            return new ModelAndView(new RedirectView("404.html"));
    }
}
