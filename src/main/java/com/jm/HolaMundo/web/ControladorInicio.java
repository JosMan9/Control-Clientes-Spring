/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jm.HolaMundo.web;

import com.jm.HolaMundo.dao.PersonaDao;
import com.jm.HolaMundo.domain.Persona;
import com.jm.HolaMundo.servicio.PersonaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Manuel
 */
@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var personas = personaService.listaPersonas();
        //var personas = new ArrayList();
        log.info("Ejeecutando el controlador Spring MVC");
        log.info("usuario que hizo login: " + user);

        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for( var p: personas) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errors) {
        if (errors.hasErrors()) {
            return "modificar";
        } else {
            personaService.guardar(persona);
            return "redirect:/";
        }

    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model m) {
        persona = personaService.encontrarPersona(persona);
        m.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona p) {
        personaService.eliminar(p);
        return "redirect:/";
    }

}
