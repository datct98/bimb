package com.example.demo.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/bimb")
public class WebController {
    @GetMapping(path = "/")
    public String index() {
        return "index";
    }

    @GetMapping(path = "/index")
    public String index1() {
        return "index";
    }

    @GetMapping("/welcome")
    public String getLogin(){
        if(SecurityContextHolder.getContext().getAuthentication() instanceof UsernamePasswordAuthenticationToken){
            return "redirect:/bimb/";
        }
        return "login";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "index";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    //Oerveride for Whitelabel Error Page status 404 page not found
    @GetMapping("/error")
    public String error() {
        return "access-error";
    }
}
