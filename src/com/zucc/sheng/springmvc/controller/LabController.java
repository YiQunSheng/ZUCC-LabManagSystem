package com.zucc.sheng.springmvc.controller;

import com.zucc.sheng.model.computer;
import com.zucc.sheng.model.lab;
import com.zucc.sheng.service.labService;
import com.zucc.sheng.service.computerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller("LabController")
@RequestMapping(value="/lab")
public class LabController {
    @Resource(name="labService")
    private labService  labService;
    @Resource(name = "computerService")
    private computerService computerService;

    @RequestMapping(value = "/")
    public ModelAndView indexCore(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new ModelAndView("/index.jsp");
        return mv;
    }
    @RequestMapping(value="/allLab")
    public ModelAndView getAllLab(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        List<lab> list=labService.getAlllab();

        String ml = "<table class='table'>" +
                "<thead>" +
                "<tr>" +
                "<th>实验室编号</th>" +
                "<th>位置</th>" +
                "<th>实验室容量</th>" +
                "<th>可用计算机数量</th>" +
                "<th>查看使用详情</th>" +
                "<th>修改</th>" +
                "<th>删除</th>" +
                "</tr>" +
                "</thead>";
        for(int i=0;i<list.size();i++){
            String labId=list.get(i).getLabId();
            String location=list.get(i).getLocation();
            int size=list.get(i).getSize();
            int amount = labService.getUsableComp(labId);
            int userAmount=size-list.get(i).getUserAmount();
           ml+="<tbody>" +
                   "<tr>" +
                   "<td class='labId'>"+labId+"</td>" +
                   "<td>"+location+"</td>" +
                   "<td>"+size+"</td>" +
                   "<td>"+amount+"</td>";
           ml+="<td> <a class='btn btn-primary lookbtn' type='button' href='/computer/allComputer?labId="+labId+"'>"+
                   "look</a></td>"+
                   "<td> <a class='btn btn-primary editbtn' type='button' href='/lab/editPage?labId="+labId+"'>"+
                   "edit</a></td>"+
                   "<td><button class='btn btn-primary deletebtn' type='button'>delete</button></td>";
           ml+="</tr></tbody>";
        }
        ml+="</table>";
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg",ml);
        mav.setViewName("/WEB-INF/jsp/lab.jsp");
        return mav;
    }
    @RequestMapping(value="/addLabInput")
    public ModelAndView addLabInput(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/addLab.jsp");
        return mav;
    }
    @RequestMapping(value="/addLab")
    public String addLab(HttpServletRequest request,HttpServletResponse response){
        String labId=request.getParameter("labId");
        String location=request.getParameter("location");
        int size=Integer.valueOf(request.getParameter("size"));

        lab labConfirm = labService.getLabById(labId);
        if(labConfirm!=null){
            request.setAttribute("msg","Lab Already exists");
            return "/WEB-INF/jsp/addLab.jsp";
        }
        lab lab=new lab();
        lab.setLabId(labId);
        lab.setLocation(location);
        lab.setSize(size);
        lab.setUserAmount(0);
        labService.addLab(lab);
        return "/lab/allLab";
    }
   @RequestMapping(value="/deleteLab",method = {RequestMethod.POST})
   @ResponseBody
   public String deleteLab(HttpServletRequest request,HttpServletResponse response){
        String labId=request.getParameter("id");
       List<computer> computers = computerService.getAllComputerByLabId(labId);
       if(computers!=null) return "This lab has Computers in it!";

        labService.deleteLab(labId);
        return "you delete"+labId;
    }
    @RequestMapping(value="/editPage")
    public ModelAndView editPage(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/editLab.jsp");
        return mav;
    }
    @RequestMapping(value="/editLab")
    public ModelAndView editLab(HttpServletRequest request,HttpServletResponse response){
        String labId=request.getParameter("labId");
        String location=request.getParameter("location");
        int size=Integer.valueOf(request.getParameter("size"));
        lab lab=new lab();
        lab.setLabId(labId);
        lab.setSize(size);
        lab.setLocation(location);
        lab.setUserAmount(0);
        labService.updateLab(lab);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/lab/allLab");
        return mav;
    }
}
