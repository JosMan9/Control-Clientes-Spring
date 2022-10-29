/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jm.HolaMundo.servicio;

import com.jm.HolaMundo.domain.Persona;
import java.util.List;

/**
 *
 * @author Manuel
 */
public interface PersonaService {
    
    public List<Persona> listaPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona peronsa);
    
    public Persona encontrarPersona(Persona persona);
}
