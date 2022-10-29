/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jm.HolaMundo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Manuel
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService user;
    
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(user).passwordEncoder(passwordEncoder());
    }
    //@Override
   /* protected void configure(AuthenticationManagerBuilder amb) throws Exception {
        amb.inMemoryAuthentication().withUser("jose")
                .password("{noop}123")
                .roles("ADMIN", "USER").and()
                .withUser("user")
                .password("{noop}456").roles("USER");
    }*/
    
    @Override
    protected void configure(HttpSecurity hs) throws Exception {
        hs.authorizeHttpRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                .hasRole("ADMIN").antMatchers("/")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin().loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errors/403");
                
    }
}
