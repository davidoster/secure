/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.secure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author George.Pasparakis
 */
@Controller
public class HomeController {
    
    @GetMapping({"/", "/home"})
    public String index() {
        
        
        return("index");
    }
    
    @GetMapping("/public")
    public String allowAll() {
        
        
        return("all");
    }
    
}
