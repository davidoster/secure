/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.secure.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author George.Pasparakis
 */
@Configuration
public class SecurityConfiguration { //extends WebSecurityConfigurerAdapter {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/authenticated", true)
                .permitAll();
//                http.formLogin(form -> form
//			.loginPage("/login")
//			.permitAll());

//        http.logout().logoutUrl("/logout"); // default
//        http.rememberMe();
        http.sessionManagement().maximumSessions(1);
        http
                .authorizeHttpRequests((authz) -> authz
                .antMatchers("/profile").hasAnyRole("ADMIN", "USER")
                .antMatchers("/admin").hasAnyRole("ADMIN")
                .antMatchers("/customer").hasAnyRole("USER")
                .antMatchers("/public*").permitAll()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated())
                .httpBasic();
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User //.withDefaultPasswordEncoder()
//                .withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user1 = User //.withDefaultPasswordEncoder()
//                .withUsername("user")
//                .password(passwordEncoder().encode("user"))
//                .roles("USER")
//                .build();
//        UserDetails user2 = User //.withDefaultPasswordEncoder()
//                .withUsername("root")
//                .password(passwordEncoder().encode("root"))
//                .roles("USER", "ADMIN")
//                .build();
////        List<UserDetails> users = new ArrayList<>();
////        users.add(user);
////        users.add(user1);
//        InMemoryUserDetailsManager userService = new InMemoryUserDetailsManager(user, user1, user2);
//        return userService;
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
            throws Exception {
        AuthenticationManager authManager = authenticationConfiguration.getAuthenticationManager();
        
        return(authManager);
//        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    

// creates users in memory - AUTHENTICATION
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(new BCryptPasswordEncoder().encode("user1Pass")).roles("USER")
//                .and()
//                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//    }
    // AUTHORIZATION
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http
//      .csrf().disable()
//      .authorizeRequests()
//      .antMatchers("/admin/**").hasRole("ADMIN")
//      .antMatchers("/public*").anonymous()
//      .antMatchers("/login*").permitAll()
//      .anyRequest().authenticated();
//    }
}
