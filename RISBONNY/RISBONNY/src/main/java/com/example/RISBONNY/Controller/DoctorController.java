package com.example.RISBONNY.Controller;

import com.example.RISBONNY.ris.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.findAll();
    }

    @PostMapping("/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

}

