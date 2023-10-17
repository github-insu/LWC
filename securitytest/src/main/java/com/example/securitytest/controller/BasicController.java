package com.example.securitytest.controller;

import com.example.securitytest.config.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping("/")
    public String index(){
        return "Welcome to my Main Page";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/main")
    public String main(Authentication authentication, ModelMap map){
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        map.addAttribute("user", securityUser)
        return "main";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

    @GetMapping("/member")
    public String member(){
        return "member";
    }
    @GetMapping("/manager")
    public String manager(){
        return "manager";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}
