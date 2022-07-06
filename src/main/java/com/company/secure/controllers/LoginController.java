/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.secure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author George.Pasparakis
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    String login() {
        return "login";
    }
    
    @PostMapping("/login")
    String login(@RequestParam String username, @RequestParam String password) {
        if(username.equals("admin") && password.equals("admin")) {
            return("authenticated");
        }
        else {
            return("login");
        }
    }
}
