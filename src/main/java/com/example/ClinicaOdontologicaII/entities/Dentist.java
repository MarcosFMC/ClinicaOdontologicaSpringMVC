package com.example.ClinicaOdontologicaII.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dentists")
public class Dentist {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private Integer registration;
        @Column(nullable = false)
        private String name;
        @Column(nullable = false)
        private String lastName;
        public Dentist() {
        }
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getRegistration() {
            return registration;
        }

        public void setRegistration(Integer registration) {
            this.registration = registration;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
}
