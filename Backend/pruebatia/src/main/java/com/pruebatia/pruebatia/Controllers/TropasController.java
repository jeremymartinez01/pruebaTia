package com.pruebatia.pruebatia.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatia.pruebatia.Entities.Tropas;
import com.pruebatia.pruebatia.Repositories.TropasRepository;

@RestController
@RequestMapping("/tropas")
public class TropasController {
    @Autowired
    private TropasRepository repo;

    @PostMapping
    public Tropas agregarTropas(@RequestBody Tropas tropas) {
        return repo.save(tropas);
    }

    @GetMapping("/resumen")
    public List<Map<String, Object>> resumenTropas() {
        return repo.obtenerTotalTropasPorPotenciaYFrente();
    }
}
