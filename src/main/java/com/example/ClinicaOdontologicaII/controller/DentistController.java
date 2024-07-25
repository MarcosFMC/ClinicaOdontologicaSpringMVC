package com.example.ClinicaOdontologicaII.controller;

import com.example.ClinicaOdontologicaII.entities.Dentist;
import com.example.ClinicaOdontologicaII.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @PostMapping("/save")
    public Dentist save(@RequestBody Dentist dentist){
        return dentistService.save(dentist);
    }

    @GetMapping("/all")
    public List<Dentist> getAll(){
        return dentistService.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Dentist> findById(@PathVariable Integer id){
        Optional<Dentist> dentistWanted = dentistService.findById(id);
        if(dentistWanted.isPresent()){
            return ResponseEntity.ok(dentistWanted.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Dentist> update(@RequestBody Dentist dentist){

        Optional<Dentist> dentistWanted = dentistService.findById(dentist.getId());
        if(dentistWanted.isPresent()){
            dentistService.update(dentist);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Dentist> optionalDentist = dentistService.findById(id);
        if(optionalDentist.isPresent()){
            dentistService.delete(id);
            return "Se elimino el odontologo con el id: " + id;
        }
        else{
            return "No se encontro el odontologo con el id: " + id;
        }
    }
}
