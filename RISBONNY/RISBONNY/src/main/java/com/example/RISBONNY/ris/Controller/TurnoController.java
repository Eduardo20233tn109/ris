package com.example.RISBONNY.ris.Controller;

import com.example.RISBONNY.ris.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    // Obtener todos los turnos
    @GetMapping("/all")
    public List<Turno> getAllTurnos() {
        return turnoService.findAll();
    }

    // Crear un nuevo turno
    @PostMapping("/save")
    public Turno saveTurno(@RequestBody Turno turno) {
        return turnoService.save(turno);
    }
}


