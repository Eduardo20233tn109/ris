package com.example.RISBONNY.ris.Controller;

import com.example.RISBONNY.ris.model.Doctor;
import com.example.RISBONNY.ris.model.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional(readOnly = true)
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }


    @Transactional(rollbackFor = {SQLException.class})
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

}


