package com.zucc.sheng.springmvc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@org.springframework.stereotype.Controller
public class testController{
    @RequestMapping("/firstCon")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "<h1>Hello World</h1>");
        mav.setViewName("WEB-INF/jsp/first.jsp");
        return mav;
    }
}
