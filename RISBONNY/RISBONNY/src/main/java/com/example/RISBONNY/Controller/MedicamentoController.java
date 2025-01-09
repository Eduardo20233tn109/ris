package com.example.RISBONNY.Controller;

import com.example.RISBONNY.ris.model.Medicamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamento")


public class MedicamentoController {
    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoService.registrarMedicamento(medicamento);
    }

    @GetMapping("consultar")
    public ResponseEntity<List<Medicamento>> consultarMedicamento() {
        return medicamentoService.consultarMedicamentos();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamentoActualizado) {
        return medicamentoService.editarMedicamento(id, medicamentoActualizado);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarMedicamento(@PathVariable Long id) {
        return medicamentoService.eliminarMedicamento(id);
    }
}
