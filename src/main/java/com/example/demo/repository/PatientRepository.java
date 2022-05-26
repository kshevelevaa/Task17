package com.example.demo.repository;

import com.example.demo.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findPatientById(Integer id);

    List<Patient> findAllBy();

    Patient findPatientByAddress(String address);

    @Modifying
    @Query(value = "COPY forjava.public.patient TO 'C:\\tmp\\patients.csv'" +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void savePatients();
}
