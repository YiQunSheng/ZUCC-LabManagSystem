package com.zucc.sheng.springmvc.controller;

import com.zucc.sheng.model.User;
import com.zucc.sheng.service.UserService;
import org.hibernate.Session;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@org.springframework.stereotype.Controller("UserController")
@RequestMapping(value = "/user")
public class UserController {
    @Resource(name = "UserService")
    private UserService userService;


    @RequestMapping(value = "/")
    public ModelAndView indexCore(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("/login.jsp");
        return mv;
    }
    //û�õ�
    @RequestMapping(value = "/LoginController")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String name = httpServletRequest.getParameter("name");
        ModelAndView mv = new ModelAndView();
//        mv.addObject("msg","hello world! /hello @Annotation!  "+name);
        mv.setViewName("/WEB-INF/jsp/addUser.jsp");
        return mv;
    }
    //û�õ�
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
        String ml = "<table class='table'><tr><th>����</th><th>ID</th><th>�޸�</th><th>ɾ��</th></tr>";
        for (int i = 0; i < list.size(); i++) {
            String userid = list.get(i).getUserId();
            ml += "<tr id='" + userid + "'>";
            ml += "<td><a style='color:black' href='/user/infoPage?userId=" + userid + "'>" + list.get(i).getUserName() + "</a></td>";
            ml += "<td class ='id'>" + userid + "</td>" + "<td><a class='btn btn-primary editbtn' type='button' href='/user/editPage?userId=" + userid + "'>edit</a></td>" + "<td><button class='btn btn-primary submitbtn'  type='button'>delete</button></td>";
            ml += "</tr>";
        }
        ml += "</table>";
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", ml);
        mav.setViewName("/WEB-INF/jsp/first.jsp");
        return mav;
    }

    @RequestMapping(value = "/addUserInput")
    public ModelAndView addUserInput(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/addUser.jsp");
        return mav;
    }

    @RequestMapping(value = "/addUser")
    public String addUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String userId = httpServletRequest.getParameter("userId");
        String pwd = httpServletRequest.getParameter("pwd");
        String userName = httpServletRequest.getParameter("userName");
        String role = httpServletRequest.getParameter("role");
//        System.out.println(userId+"   "+pwd+"  "+userName+"   "+role);
        User user = new User();
        user.setUserName(userName);
        user.setPwd(pwd);
        user.setRole(role);
        user.setUserId(userId);
        userService.addUser(user);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("/user/addUser");
//        return mav;
        return "/user/allUser";
    }

    @RequestMapping(value = "/editUser")
    public ModelAndView editUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String userId = httpServletRequest.getParameter("userId");
        String pwd = httpServletRequest.getParameter("pwd");
        String userName = httpServletRequest.getParameter("userName");
        String role = httpServletRequest.getParameter("role");
        User user = new User();
        user.setUserName(userName);
        user.setPwd(pwd);
        user.setRole(role);
        user.setUserId(userId);
        userService.updateUser(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/allUser");
        System.out.println(httpServletRequest.getSession().getAttribute("useId"));
        return mav;
    }

    @RequestMapping(value = "/editPage")
    public ModelAndView editPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/editUser.jsp");
        return mav;
    }

    @RequestMapping(value = "/deleteUser", method = {RequestMethod.POST})
    @ResponseBody
    public String deleteUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String data = httpServletRequest.getParameter("id");
        userService.deleteUser(httpServletRequest.getParameter("id"));
        System.out.println(data);
        return "you delete " + data;
    }

    @RequestMapping(value = "/ajax", method = {RequestMethod.POST})
    public ModelAndView ajax(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/ajaxTest.jsp");
        return mav;
    }

    @RequestMapping(value = "/admin")
    public ModelAndView adminPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("userName", httpServletRequest.getSession().getAttribute("userName"));
        mav.setViewName("/WEB-INF/jsp/admin.jsp");
        return mav;
    }

    @RequestMapping(value = "/infoPage")
    public ModelAndView infoPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ModelAndView mav = new ModelAndView();
        String id = httpServletRequest.getParameter("userId");
        System.out.println(id);
        User user = userService.getUserById(id);
        mav.addObject("id", user.getUserId());
        mav.addObject("name", user.getUserName());
        mav.addObject("pwd", user.getPwd());
        mav.addObject("role", user.getRole());
        mav.setViewName("/WEB-INF/jsp/userInfo.jsp");
        return mav;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public String login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, HttpSession session) {
        String userId = httpServletRequest.getParameter("userId");
        String pwd = httpServletRequest.getParameter("pwd");
        User user = userService.login(userId, pwd);
        if (user == null) return "No User Exsists";
        else if (user.getRole().equals("error")) return "Error PassWord";
        else if (user.getRole().equals("admin")) {
            httpServletRequest.getSession().setAttribute("userId", user.getUserId());
            httpServletRequest.getSession().setAttribute("userName", user.getUserName());
            httpServletRequest.getSession().setAttribute("role", user.getRole());
            System.out.println(httpServletRequest.getSession().getAttribute("userId"));
            System.out.println(httpServletRequest.getSession().getAttribute("role"));
            return "admin";
        } else return user.getUserName() + "  " + user.getRole();
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ModelAndView mav = new ModelAndView();
        httpServletRequest.getSession().setAttribute("userId", "");
        httpServletRequest.getSession().setAttribute("userName", "");
        httpServletRequest.getSession().setAttribute("role", "");
        mav.setViewName("login.jsp");
        return mav;
    }
}


