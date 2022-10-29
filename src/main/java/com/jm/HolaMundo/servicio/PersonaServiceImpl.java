/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jm.HolaMundo.servicio;

import com.jm.HolaMundo.dao.PersonaDao;
import com.jm.HolaMundo.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Manuel
 */
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listaPersonas() {
        return (List<Persona>) this.personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona peronsa) {
        personaDao.delete(peronsa);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(persona);
    }

}
