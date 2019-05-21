package edu.sjsu.ieptracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }


    @RequestMapping("/addStudent")
    public String test(){
        return "addStudent";
    }

    @RequestMapping("/studentsview")
    public String studentsview(){
        return "studentsview";
    }

    @RequestMapping("/addGoal")
    public String addGoal(){
        return "addGoal";
    }

    @RequestMapping("/details")
    public String details(){
        return "details";
    }

    @RequestMapping("/goalDetail")
    public String goalDetail(){
        return "goalDetail";
    }

    @RequestMapping("/addTask")
    public String addTask(){
        return "addTask";
    }

    @RequestMapping("/addEvaluation")
    public String addEvaluation(){
        return "addEvaluation";
    }

    @RequestMapping("/taskDetails")
    public String taskDetails(){
        return "taskDetails";
    }
}
