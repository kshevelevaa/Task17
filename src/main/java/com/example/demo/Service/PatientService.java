package com.example.demo.Service;

import com.example.demo.Model.Doctor;
import com.example.demo.Model.Patient;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    EntityManager em;

    @Autowired
    PatientService(EntityManager em){
        this.em = em;
    }
    public boolean addPatient(Patient patient, int doctorId) {
        log.info("add patient {}", patient);
        Patient patientFromDB = patientRepository.findPatientByAddress(patient.getAddress());
        if (patientFromDB == null) {
            //patientRepository.save(patient);
            Doctor doctor = doctorRepository.findDoctorById(doctorId);
           doctor.getPatientSet().add(patient);
           patient.setDoctor(doctor);
            patientRepository.save(patient);
            return true;
        } else
            return false;
    }

    public boolean deletePatient(int id) {
        log.info("delete patient {}", patientRepository.findPatientById(id));
        Patient patientFromDB = patientRepository.findPatientById(id);
        if (patientFromDB == null) {
            return false;
        } else {
            patientRepository.delete(patientFromDB);
            return true;
        }
    }


    public Patient printPatient(int id) {
        log.info("print patient {}", patientRepository.findPatientById(id));
        return patientRepository.findPatientById(id);
    }

    public List<Patient> printPatients() {
        //log.info("print patients {}", patientRepository.findAllBy());
        return patientRepository.findAllBy();
    }

    public List<Patient> findPatientByAddress(String address){
        log.info("filter patients by {}", address);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Patient> criteriaQuery = cb.createQuery(Patient.class);

        Root<Patient> patientRoot = criteriaQuery.from(Patient.class);
        Predicate addressPredicate = cb.equal(patientRoot.get("address"), address);
        criteriaQuery.where(addressPredicate);
        TypedQuery<Patient> query = em.createQuery(criteriaQuery);
        return query.getResultList();

    }

    public List<Patient> findPatientByFirstName(String firstName){
        log.info("filter patients by {}", firstName);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Patient> criteriaQuery = cb.createQuery(Patient.class);

        Root<Patient> patientRoot = criteriaQuery.from(Patient.class);
        Predicate addressPredicate = cb.equal(patientRoot.get("firstName"), firstName);
        criteriaQuery.where(addressPredicate);
        TypedQuery<Patient> query = em.createQuery(criteriaQuery);
        return query.getResultList();

    }
    public List<Patient> findPatientByLastName(String lastName){
        log.info("filter patients by {}", lastName);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Patient> criteriaQuery = cb.createQuery(Patient.class);

        Root<Patient> patientRoot = criteriaQuery.from(Patient.class);
        Predicate addressPredicate = cb.equal(patientRoot.get("lastName"), lastName);
        criteriaQuery.where(addressPredicate);
        TypedQuery<Patient> query = em.createQuery(criteriaQuery);
        return query.getResultList();

    }
}
