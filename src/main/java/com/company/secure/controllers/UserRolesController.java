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
    
    // admin only page
    @GetMapping("/admin")
    public String adminPanel() {
        return("adminpanel");
    }
    
    // for admin and user roles
    @GetMapping("/profile")
    public String userDetailsPage() {
        return("userdetails");
    }
    
    // for user only
    @GetMapping("/customer")
    public String customerPage() {
        return("customer");
    }
}
