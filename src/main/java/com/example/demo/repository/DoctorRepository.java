package com.example.demo.repository;

import com.example.demo.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    Doctor findDoctorById(Integer id);

    List<Doctor> findAllBy();

    Doctor findDoctorByPosition(int position);

    @Modifying
    @Query(value = "COPY forjava.public.doctor TO 'C:\\tmp\\doctors.csv'" +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void saveDoctors();
}
