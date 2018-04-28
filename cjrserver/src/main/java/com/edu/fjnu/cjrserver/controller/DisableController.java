package com.edu.fjnu.cjrserver.controller;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/Disable")
public class DisableController {
    /**
     *
     * @param act 主页：Disabled_index,企业投票：disabled_voting，服务调查表：disabled_comment_service，调查表查看：disabled_checking
     * @return
     */
    @RequestMapping(value = "/View")
    public ModelAndView getDisableView(@RequestParam(value = "act") String act){
        if(act.equals("index"))
            return new ModelAndView(new RedirectView("../System_Disable/Disabled_index.html"));
        else if(act.equals("TenderVots"))
            return new ModelAndView(new RedirectView("../System_Disable/disabled_voting.html"));
        else if(act.equals("Assess"))
            return new ModelAndView(new RedirectView("../System_Disable/disabled_comment_service.html"));
//        else if(act.equals("ShowDemand"))
//            return new ModelAndView(new RedirectView("/System_Disable/disabled_checking.html"));
        else
            return new ModelAndView(new RedirectView("404.html"));
    }
}
