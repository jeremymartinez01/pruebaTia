package com.pruebatia.pruebatia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatia.pruebatia.Entities.Potencia;
import com.pruebatia.pruebatia.Repositories.PotenciaRepository;

@RestController
@RequestMapping("/enemigos")
public class PotenciaController {
    @Autowired
    private PotenciaRepository repo;

    @PostMapping
    public Potencia agregarPotencia(@RequestBody Potencia potencia) {
        return repo.save(potencia);
    }
}