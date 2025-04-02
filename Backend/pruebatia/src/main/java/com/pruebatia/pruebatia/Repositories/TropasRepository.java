package com.pruebatia.pruebatia.Repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pruebatia.pruebatia.Entities.Tropas;

public interface TropasRepository extends JpaRepository<Tropas, Long> {
    @Query(value = """
        SELECT 
            potencia,
            GROUP_CONCAT(DISTINCT frente ORDER BY frente SEPARATOR ',') AS frente,
            SUM(numero_tropas) AS totalTropas
        FROM tropas
        GROUP BY potencia
    """, nativeQuery = true)
    List<Map<String, Object>> obtenerTotalTropasPorPotenciaYFrente();
    
}
