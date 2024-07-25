package com.example.ClinicaOdontologicaII.service;

import com.example.ClinicaOdontologicaII.entities.Patient;
import com.example.ClinicaOdontologicaII.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }
    public Optional<Patient> findById(Integer id){
        return patientRepository.findById(id);
    }
    public void update(Patient patient){
        patientRepository.save(patient);
    }
    public void delete(Integer id){
        patientRepository.deleteById(id);
    }
    public List<Patient> findAll(){
        return patientRepository.findAll();
    }
}
