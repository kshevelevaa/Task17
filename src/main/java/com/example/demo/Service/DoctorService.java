package com.example.demo.Service;

import com.example.demo.Model.Doctor;
import com.example.demo.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Transient;
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
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    EntityManager em;

    @Autowired
    DoctorService(EntityManager em){
        this.em = em;
    }
    public boolean addDoctor(Doctor doctor) {
        log.info("Create doctor {}", doctor);
        Doctor doctorFromDB = doctorRepository.findDoctorByPosition(doctor.getPosition());
        if (doctorFromDB == null) {
            doctorRepository.save(doctor);
            return true;
        } else
            return false;
    }

    public boolean deleteDoctor(int id) {
        log.info("Delete doctor {}", doctorRepository.findDoctorById(id));
        Doctor doctorFromDB = doctorRepository.findDoctorById(id);
        if (doctorFromDB == null) {
            return false;
        } else {
            doctorRepository.delete(doctorFromDB);
            return true;
        }
    }

    public Doctor printDoctor(int id) {
        log.info("Print doctor {}", doctorRepository.findDoctorById(id));
        return doctorRepository.findDoctorById(id);
    }

    public List<Doctor> printDoctors() {
        log.info("print doctors {}", doctorRepository.findAllBy());
        return doctorRepository.findAllBy();
    }

    public List<Doctor> findDoctorByFirstName(String firstName){
        log.info("filter doctors by name {}", firstName);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Doctor> criteriaQuery = cb.createQuery(Doctor.class);

        Root<Doctor> doctorRoot = criteriaQuery.from(Doctor.class);
        Predicate addressPredicate = cb.equal(doctorRoot.get("firstName"), firstName);
        criteriaQuery.where(addressPredicate);
        TypedQuery<Doctor> query = em.createQuery(criteriaQuery);
        return query.getResultList();

    }
}
