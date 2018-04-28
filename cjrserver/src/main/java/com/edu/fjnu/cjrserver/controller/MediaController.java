package com.edu.fjnu.cjrserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/Media")
public class MediaController {
    /**
     *
     * @param act 主页：media_index,评价报告：submit_evaluation_report，
     * @return
     */
    @RequestMapping(value = "/View")
    public ModelAndView getCompanyView(@RequestParam(value = "act") String act){
        if (act.equals("index"))
            return new ModelAndView(new RedirectView("System_Media/media_index.html"));
        else if(act.equals("AssessReport"))
            return new ModelAndView(new RedirectView("System_Media/submit_evaluation_report.html"));
        else
            return new ModelAndView(new RedirectView("404.html"));
    }
}
