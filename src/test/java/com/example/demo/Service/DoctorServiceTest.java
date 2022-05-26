package com.example.demo.Service;

import com.example.demo.Model.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DoctorServiceTest {

    @Autowired
    DoctorService doctorService;

    @Test
    void addDoctor() {
        Doctor doctor = new Doctor("testFirstName407", "testLastName", 407);
        boolean isDoctorCreated=doctorService.addDoctor(doctor);
        //boolean isDepartureCreated=departureService.addDeparture("Testcity","flight","18.03.2022")!=null;
        Assertions.assertTrue(isDoctorCreated);
    }

    @Test
    void deleteDoctor() {
        List<Doctor> doctors = doctorService.findDoctorByFirstName("testFirstName407");
        boolean isDoctorDeleted = doctorService.deleteDoctor(doctors.get(0).getId());
        Assertions.assertTrue(isDoctorDeleted);
    }

}