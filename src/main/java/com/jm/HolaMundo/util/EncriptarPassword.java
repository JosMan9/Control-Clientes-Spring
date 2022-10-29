/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jm.HolaMundo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Manuel
 */
public class EncriptarPassword {
    public static void main(String[] args) {
        var password = "456";
        System.out.println(password);
        System.out.println("encriptado: " + encriptarPassword(password));
        
    }
    
    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
           return bCryptPasswordEncoder.encode(password);
    }
    
}
