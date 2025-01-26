package com.example.RISBONNY.ris.Controller;

import com.example.RISBONNY.ris.model.Medicamento;
import com.example.RISBONNY.ris.model.MedicamentoRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }


    public ResponseEntity<?> registrarMedicamento(Medicamento medicamento) {
        Map<String, Object> response = new HashMap<>();
        Medicamento m = medicamentoRepository.save(medicamento);
        response.put("medicamento", m);
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<List<Medicamento>> consultarMedicamentos() {
        return ResponseEntity.ok(medicamentoRepository.findAll());
    }

    public ResponseEntity<?> editarMedicamento(long id, Medicamento medicamentoActualizar) {
        Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(id);
        if (medicamentoOptional.isPresent()) {
            Medicamento medicamento = medicamentoOptional.get();
            medicamento.setNombre(medicamentoActualizar.getNombre()); // Actualizar otros campos
            medicamento.setStock(medicamentoActualizar.getStock());
            medicamentoRepository.save(medicamento);
            return ResponseEntity.ok(medicamento);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> eliminarMedicamento(Long id) {
        Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(id);
        if (medicamentoOptional.isPresent()) {
            medicamentoRepository.deleteById(id);
            return ResponseEntity.ok("Medicamento eliminado exitosamente.");
        }
        return ResponseEntity.notFound().build();
    }
}
