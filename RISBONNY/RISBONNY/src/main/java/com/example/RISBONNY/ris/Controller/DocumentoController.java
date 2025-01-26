package com.example.RISBONNY.ris.Controller;

import com.example.RISBONNY.ris.model.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    private final DocumentoService documentoService;

    @Autowired
    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    // Obtener todos los documentos
    @GetMapping("/all")
    public List<Documento> getAllDocumentos() {
        return documentoService.findAll();
    }

    // Crear un nuevo documento
    @PostMapping("/save")
    public Documento saveDocumento(@RequestBody Documento documento) {
        return documentoService.save(documento);
    }

    // Actualizar un documento existente
    @PutMapping("/update")
    public Documento updateDocumento(@RequestBody Documento documento) {
        return documentoService.update(documento);
    }

    // Eliminar un documento por su ID
    @DeleteMapping("/{id}")
    public boolean deleteDocumento(@PathVariable Long id) {
        return documentoService.deleteById(id);
    }
}
