package org.unl.pacas.base.services;

import org.springframework.stereotype.Service;
import org.unl.pacas.base.services.PersonaService;
import org.unl.pacas.base.dao.PersonaRepository;
import org.unl.pacas.base.models.Persona;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }
}