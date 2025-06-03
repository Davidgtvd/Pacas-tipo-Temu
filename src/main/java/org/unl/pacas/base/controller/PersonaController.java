package org.unl.pacas.base.controller;


import org.unl.pacas.base.models.Persona;
import org.unl.pacas.base.services.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getAll() {
        return personaService.findAll();
    }

    @PostMapping
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }
}