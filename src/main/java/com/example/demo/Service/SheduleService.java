package com.example.demo.Service;

import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@EnableScheduling
@Service
@Slf4j
public class SheduleService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserRepository userRepository;

    @Scheduled(cron = "*/10 * * * * *")
    @Transactional
    public void saveEntities() {
        doctorRepository.saveDoctors();
        patientRepository.savePatients();
        userRepository.saveUsers();
        log.info("All entities saved successfully");
    }
}
