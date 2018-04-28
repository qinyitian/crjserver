package com.edu.fjnu.cjrserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/Main")
public class MainViewController {
    /**
     *
     * @return 主页：index
     */
    @RequestMapping(value = "/View")
    public ModelAndView getMainView(@RequestParam(value = "type")String act){
            if (act.equals("A"))
                return new ModelAndView(new RedirectView("index.html?type=A"));
            else if(act.equals("B"))
                return new ModelAndView(new RedirectView("index.html?type=B"));
            else if (act.equals("C"))
                return new ModelAndView(new RedirectView("index.html?type=C"));
            else
                return new ModelAndView(new RedirectView("404.html"));
    }
    @RequestMapping(value = "/Login")
    public ModelAndView getLoginView(){
        return new ModelAndView(new RedirectView("System_management/Login.html"));
    }
}
