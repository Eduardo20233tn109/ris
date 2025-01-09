package com.example.RISBONNY.Controller;

import com.example.RISBONNY.ris.model.Turno;
import com.example.RISBONNY.ris.model.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TurnoService {

    private final TurnoRepository turnoRepository;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    // Obtener todos los turnos
    @Transactional(readOnly = true)
    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }

    // Guardar un nuevo turno
    @Transactional
    public Turno save(Turno turno) {
        return turnoRepository.save(turno);
    }
}

