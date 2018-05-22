package com.zucc.sheng.springmvc.controller;

import com.zucc.sheng.model.User;
import com.zucc.sheng.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller("UserController")
@RequestMapping(value = "/user")
public class UserController {
    @Resource(name = "UserService")
    private UserService userService;


    @RequestMapping(value = "/")
    public ModelAndView  indexCore(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView("/index.jsp");
        return mv;
    }

    @RequestMapping(value = "/LoginController")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String name = httpServletRequest.getParameter("name");
        ModelAndView mv = new ModelAndView();
//        mv.addObject("msg","hello world! /hello @Annotation!  "+name);
        mv.setViewName("/WEB-INF/jsp/login.jsp");
        return mv;
    }

    @RequestMapping(value = "/loginUser")
    public String loginUser(HttpServletRequest request) {
        String username = request.getParameter("userid");
        String pwd = request.getParameter("pwd");
        User user = new User();
        user.setUserId(pwd);
        user.setUserName(username);
//        UserDao userDao = new UserDaoImpl();
//        userDao.addUser(user);
        userService.addUser(user);

        System.out.println("Username is " + username);
        System.out.println("pwd is " + pwd);
        return "success";
    }

    @RequestMapping(value = "/allUser")
    public ModelAndView getAllUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<User> list = userService.getAllUser();
        String ml = "<table class='table'><tr><th>ÐÕÃû</th><th>ID</th><t/r>";
        for(int i=0;i<list.size();i++) {
            ml+="<tr>";
            ml +="<td>"+ list.get(i).getUserName()+"</td>";
            ml +="<td>"+ list.get(i).getUserId()+"</td>";
            ml+="</tr>";
        }
        ml += "</table>";
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", ml);
        mav.setViewName("/WEB-INF/jsp/first.jsp");
        return mav;
    }
}


