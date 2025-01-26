package com.example.RISBONNY.ris.Controller;

import com.example.RISBONNY.ris.model.Documento;
import com.example.RISBONNY.ris.model.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    @Autowired
    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Transactional(readOnly = true)
    public List<Documento> findAll() {
        return documentoRepository.findAll();
    }

    @Transactional
    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }

    @Transactional
    public Documento update(Documento documento) {
        Optional<Documento> existingDocumento = documentoRepository.findById(documento.getId());
        if (existingDocumento.isPresent()) {
            Documento updatedDocumento = existingDocumento.get();
            updatedDocumento.setNombrePaciente(documento.getNombrePaciente());
            updatedDocumento.setMount(documento.getMount());
            updatedDocumento.setDoctor(documento.getDoctor());
            return documentoRepository.save(updatedDocumento);
        }
        return null;
    }

    @Transactional
    public boolean deleteById(Long id) {
        if (documentoRepository.existsById(id)) {
            documentoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

