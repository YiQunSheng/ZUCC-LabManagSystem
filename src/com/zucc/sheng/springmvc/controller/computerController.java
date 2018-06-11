package com.zucc.sheng.springmvc.controller;

import com.zucc.sheng.model.computer;
import com.zucc.sheng.model.lab;
import com.zucc.sheng.service.computerService;
import com.zucc.sheng.service.labService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("computerController")
@RequestMapping(value="/computer")
public class computerController {
    @Resource(name="computerService")
    private computerService computerService;
    @Resource(name="labService")
    private labService labService;

    public labService getLabService() {
        return labService;
    }

    public void setLabService(labService labService) {
        this.labService = labService;
    }

    public computerService getComputerService() {
        return computerService;
    }

    public void setComputerService(computerService computerService) {
        this.computerService = computerService;
    }

    @RequestMapping(value="/allComputer")
    public ModelAndView getAllComputer(HttpServletRequest request, HttpServletResponse response){
      String labId=request.getParameter("labId");
        ModelAndView mav=new ModelAndView();
      List<computer> list=computerService.getAllComputerByLabId(labId);
      if(list!=null){
      String ml="<table class='table'>"+
                "<thead>"+
                "<tr>"+
                "<th>计算机编号</th>"+
                "<th>IP地址</th>"+
                "<th>使用状况</th>"+
              "<th>修改</th>"+
              "<th>删除</th>"+
                "</tr>"+
                "</thead>";
      System.out.println(list.size());
      for(int i=0;i<list.size();i++){
          String computerId=list.get(i).getComputerId();
          String ipAddress=list.get(i).getIpAddress();
          int   status=list.get(i).getStatus();
          String actualStatus="";
          if(status==1){
              actualStatus="正在使用";
          }
          else if(status==0){
              actualStatus="未被使用";
          }
          ml+="<tbody>"+
              "<tr>"+
              "<td class='computerId'>"+computerId+"</td>"+
              "<td>"+ipAddress+"</td>"+
              "<td>"+actualStatus+"</td>";
          ml +="<td><a class='btn btn-primary editbtn' type='button' href='/computer/editPage?computerId="+computerId+"'>edit</a></td>"+"<td><button class='btn btn-primary deletebtn'  type='button'>delete</button></td>";
          ml+="</tr></tbody>";
      }
         ml+="</table>";

      mav.addObject("msg",ml);
      mav.addObject("labId",labId);
      }
      else {
          String noLab = "<h3>当前实验室没有计算机😯，请添加！</h3>";
          mav.addObject("msg",noLab);
      }
      mav.setViewName("/WEB-INF/jsp/computer.jsp");
      return mav;
    }
    @RequestMapping(value="/addComputerInput")
    public ModelAndView addUserInput(HttpServletRequest request,HttpServletResponse response){
       System.out.println(request.getParameter("computerId"));
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/addComputer.jsp");
        return mav;
    }
    @RequestMapping(value="/addComputer")
    public String addComputer(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        String labId=session.getAttribute("labId").toString();
        String computerId=request.getParameter("computerId");
        String ipAddress=request.getParameter("ipAddress");
        String status=request.getParameter("role");
        computer computerConfirm = computerService.getComputerById(computerId);
        if(computerConfirm!=null){
            request.setAttribute("msg","Computer Already exists");
            return "/WEB-INF/jsp/addComputer.jsp";
        }
        int  actualStatus=0;
        System.out.println("当前状态为:"+status);
        if(status.equals("未被使用")){
                actualStatus=0;
        }
        else if(status.equals("正在被使用")){
            actualStatus=1;
        } else{

        }
        computer computer=new computer();
        lab lab=labService.getLabById(labId);
        computer.setComputerId(computerId);
        computer.setIpAddress(ipAddress);
        computer.setLab(lab);
        computer.setStatus(actualStatus);
        computerService.addComputer(computer);
        return "/computer/allComputer?labId="+labId;
    }
    @RequestMapping(value="/deleteComputer",method = {RequestMethod.POST})
    @ResponseBody
    public String deleteComputer(HttpServletRequest request,HttpServletResponse response){
        String computerId=request.getParameter("id");
        computerService.deleteComputer(computerId);
        return "you delete"+computerId;
    }
    @RequestMapping(value="/editComputer")
    public ModelAndView editComputer(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        String labId=session.getAttribute("labId").toString();
        String computerId=request.getParameter("computerId");
        String ipAddress=request.getParameter("ipAddress");
        String status=request.getParameter("status");
        int  actualStatus=0;
        if(status.equals("未被使用")){
            actualStatus=0;
        }
        else if(status.equals("正在被使用")){
            actualStatus=1;
        } else{

        }

        computer computer=new computer();
        computer.setComputerId(computerId);
        computer.setIpAddress(ipAddress);
        computer.setStatus(actualStatus);
        computer.setLab(labService.getLabById(labId));
        computerService.updateComputer(computer);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/computer/allComputer?labId="+labId);
        return mav;
    }
    @RequestMapping(value="/editPage")
    public ModelAndView editPage(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/editComputer.jsp");
        return mav;
    }

}
