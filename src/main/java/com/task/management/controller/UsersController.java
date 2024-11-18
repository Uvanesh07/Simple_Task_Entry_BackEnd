package com.task.management.controller;

import com.task.management.entity.TaskEntity;
import com.task.management.entity.UsersEntity;
import com.task.management.service.TaskService;
import com.task.management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    TaskService taskService;

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UsersEntity());
        return "login_page";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UsersEntity());
        return "register_page";
    }

    @GetMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("submitRequest", new TaskEntity());
        return "home_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsersEntity usersEntity){
        System.out.println("Register request: " + usersEntity);
        usersService.registerUser(usersEntity.getName(),usersEntity.getEmail(),usersEntity.getCourse(),usersEntity.getCollege(),usersEntity.getPhoneNo(),usersEntity.getAddress(),usersEntity.getCity(), usersEntity.getPassword());
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersEntity usersEntity, Model model){
        System.out.println("Login request: " + usersEntity);
        UsersEntity authenticated = usersService.authenticate(usersEntity.getEmail(), usersEntity.getPassword());
        if(authenticated != null){
            model.addAttribute("userLogin", authenticated.getEmail());
            return "home_page";
        }else{
            return "error_page";
        }
    }

    @PostMapping("/home")
    public String task(@ModelAttribute TaskEntity taskEntity){
        System.out.println("Task request: " + taskEntity);
        taskService.taskSubmit(taskEntity.getTask());
        return "home_page";
    }



}
