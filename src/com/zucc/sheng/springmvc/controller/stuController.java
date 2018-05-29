package com.zucc.sheng.springmvc.controller;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zucc.sheng.model.computer;
import com.zucc.sheng.model.lab;
import com.zucc.sheng.model.userecord;
import com.zucc.sheng.service.UserService;
import com.zucc.sheng.service.computerService;
import com.zucc.sheng.service.labService;
import com.zucc.sheng.service.stuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller("stuControoller")
@RequestMapping(value="/stu")
public class stuController {
   @Resource(name="stuService")
    private stuService  stuService;
   @Resource(name="labService")
    private labService labService;
   @Resource(name="computerService")
    private computerService computerService;
  @Resource(name="UserService")
  private UserService userService;

   @RequestMapping(value="/getAllLab")
    public ModelAndView getAllLab(HttpServletRequest request, HttpServletResponse response){
       List<lab> list=this.labService.getAlllab();
       String ml="<table class='table'>"+
               "<thead>"+
               "<tr>"+
               "<th>实验室编号</th>"+
               "<th>点击进入</th>"+
               "</tr>"+
               "</thead>" +
               "<tbody>";
       for(int i=0;i<list.size();i++){
         String  labId=list.get(i).getLabId();
          ml+="<tr>"+
                  "<td class='labId'>"+labId+"</td>"+
                  "<td><a class='btn btn-primary editbtn' type='button' href='/stu/getAllComputer?labId="+labId+"'>join</a></td>"+
                  "</tr>";
       }
       ml+="</tbody>"+
               "</table>";
       System.out.println(ml);
       ModelAndView mav=new ModelAndView();
       mav.addObject("msg",ml);
       mav.setViewName("/WEB-INF/jsp/stu.jsp");
       return mav;
   }
   @RequestMapping(value="/getAllComputer")
    public ModelAndView getAllComputer(HttpServletRequest request,HttpServletResponse response){
       String labId=request.getParameter("labId");
       System.out.println("实验室编号为:"+labId);
       List<computer> list=this.computerService.getComputerByLabIdAndStatus(labId);
       String ml="<table class='table'>"+
               "<thead>"+
               "<tr>"+
               "<th>计算机编号</th>"+
               "<th>点击开始上机</th>"+
               "</tr>"+
               "</thead>" +
               "<tbody>";
       for(int i=0;i<list.size();i++){
          String computerId=list.get(i).getComputerId();
          ml+="<tr>"+
                  "<td class='computerId'>"+computerId+"</td>"+
                  "<td><a class='btn btn-primary editbutton' type='button' href='/stu/mainPage?computerId="+computerId+"&labId="+labId+"'>join</td>"+
                  "</tr>";
       }
       ml+="</tbody></table>";
       ModelAndView mav=new ModelAndView();
       mav.addObject("msg",ml);
       mav.setViewName("/WEB-INF/jsp/stuComputer.jsp");
       return mav;
   }
    @RequestMapping(value="/mainPage")
    public ModelAndView getMainPage(HttpServletRequest request, HttpServletResponse response,HttpSession session){
       //设置测试的session
//       request.getSession().setAttribute("userId","31501086");
       String computerId=request.getParameter("computerId");
       String labId=request.getParameter("labId");
       String userId=request.getSession().getAttribute("userId").toString();
       userecord userecord=new userecord();
       userecord.setUser(this.userService.getUserById(userId));
       userecord.setLab(this.labService.getLabById(labId));
       userecord.setComputer(this.computerService.getComputerById(computerId));
       userecord.setInTime(new Timestamp(System.currentTimeMillis()));
       userecord.setOutTime(null);
       this.stuService.addUseRecord(userecord);
       computer computer=this.computerService.getComputerByLadIdAndComputerId(labId,computerId);
       computer.setStatus(1);
      this.computerService.updateComputer(computer);
       ModelAndView mav =new ModelAndView();
       mav.addObject("useId",userecord);
       mav.setViewName("/WEB-INF/jsp/stuMainPage.jsp");
       return mav;
    }
    @RequestMapping(value="/logOut",method = {RequestMethod.POST})
    @ResponseBody
    public String logOut(HttpServletRequest request,HttpServletResponse response){
       String  userId=request.getSession().getAttribute("userId").toString();
       userecord userecord=new userecord();
       userecord.setOutTime(new Timestamp(System.currentTimeMillis()));
       this.stuService.updateUseRecord(userecord,userId);
       //更新计算机状态
        userecord userecord1=this.stuService.getcurrentUseRecordByUserId(userId);

        System.out.println(userecord1.getComputer().getComputerId());
        String computerId=userecord1.getComputer().getComputerId();
        String labId=userecord1.getLab().getLabId();
        computer computer=this.computerService.getComputerByLadIdAndComputerId(labId,computerId);
        computer.setStatus(0);
        this.computerService.updateComputer(computer);
       return "logOut";
    }
}


