package com.example.ClinicaOdontologicaII.controller;

import com.example.ClinicaOdontologicaII.entities.Patient;
import com.example.ClinicaOdontologicaII.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/save")
    public Patient save(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @GetMapping("/all")
    public List<Patient> getAll(){
        return patientService.findAll();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Integer id){
        Optional<Patient> patientWanted = patientService.findById(id);
        if(patientWanted.isPresent()){
            return ResponseEntity.ok(patientWanted.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Patient> update(@RequestBody Patient patient){

        Optional<Patient> patientWanted = patientService.findById(patient.getId());
        if(patientWanted.isPresent()){
            patientService.update(patient);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Patient> optionalPatient = patientService.findById(id);
        if(optionalPatient.isPresent()){
            patientService.delete(id);
            return "Se elimino el paciente con el id: " + id;
        }
        else{
            return "No se encontro el paciente con el id: " + id;
        }
    }



}