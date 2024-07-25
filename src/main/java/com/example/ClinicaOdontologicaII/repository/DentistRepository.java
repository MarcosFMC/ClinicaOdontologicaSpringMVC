package com.example.ClinicaOdontologicaII.repository;

import com.example.ClinicaOdontologicaII.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist,Integer> {

}
