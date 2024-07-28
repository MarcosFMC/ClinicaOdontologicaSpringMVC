package com.example.ClinicaOdontologicaII.repository;

import com.example.ClinicaOdontologicaII.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
