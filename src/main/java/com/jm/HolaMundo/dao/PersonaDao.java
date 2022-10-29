/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jm.HolaMundo.dao;

import com.jm.HolaMundo.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Manuel
 */
public interface PersonaDao extends JpaRepository<Persona, Long> {

}
