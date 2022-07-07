/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.secure.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author George.Pasparakis
 */
@Controller
public class UserRolesController {
    
    @GetMapping("/admin")
    public String adminPanel() {
        return("adminpanel");
    }
    
    @GetMapping("/profile")
    public String userDetailsPage() {
        return("userdetails");
    }
}
