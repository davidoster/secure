/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.secure.repositories;

import com.company.secure.models.CustomUser;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author George.Pasparakis
 */
public class MyUserPrincipal implements UserDetails {

    private CustomUser user;
    private Collection<MyGrantedAuthority> authorities;
    
    private class MyGrantedAuthority implements GrantedAuthority {
        
        @Override
        public String getAuthority() {
            return("ROLE_ADMIN");
        }
        
    }

    public MyUserPrincipal(CustomUser user) {
       this.user = user;
       authorities = new ArrayList<MyGrantedAuthority>();
       MyGrantedAuthority gA = new MyGrantedAuthority();
        System.out.println(gA.getAuthority());
       authorities.add(gA);
//       authorities = new ArrayList<>();
//       
//       switch(user.getUsername()) {
//           case "admin":
//               authorities.add("ROLE_ADMIN");
//               authorities.add("ROLE_USER");
//               break;
//           case "user":
//               authorities.add("ROLE_USER");
//               break;
//           case "root":
//               authorities.add("ROLE_ADMIN");
//               authorities.add("ROLE_USER");
//               break;
//       }
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(authorities);
        return(authorities);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPassword() {
       return(user.getPassword());
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUsername() {
        return(user.getUsername());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isAccountNonExpired() {
        return(user.isEnabled());
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isAccountNonLocked() {
        // create a new field that holds the lock status of the user
        return(user.isEnabled());
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return(user.isEnabled());
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEnabled() {
        return(user.isEnabled());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
