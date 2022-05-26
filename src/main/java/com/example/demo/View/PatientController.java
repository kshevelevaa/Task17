package com.example.demo.View;

import com.example.demo.Model.Patient;
import com.example.demo.Service.EmailSenderService;
import com.example.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private EmailSenderService emailSenderService;

//    //    http://localhost:8080/add/patient?firstName=Ivan&lastName=Ivanov&address=moscow&doctorId=0
//    @GetMapping("add/patient")
//    public String addPatient(@RequestParam(name = "firstName") String firstName,
//                             @RequestParam(name = "lastName") String lastName,
//                             @RequestParam(name = "address") String address,
//                             @RequestParam(name = "doctorId") Integer doctorId) {
//        System.out.println(firstName + lastName);
//        boolean isCreated = patientService.addPatient(new Patient(firstName, lastName, address), doctorId);
//        if (isCreated == true) {
//            return "success";
//        } else
//            return "patient already exists";
//    }
//
//    // http://localhost:8080/delete/patient/0
//    @GetMapping("delete/patient/{id}")
//    public List<Patient> deletePatient(@PathVariable int id) {
//        patientService.deletePatient(id);
//        return patientService.printPatients();
//    }
//
//    // http://localhost:8080/print/patient/0
//    @GetMapping("print/patient/{id}")
//    public Patient printPatient(@PathVariable(name = "id") int id) {
//        return patientService.printPatient(id);
//    }
//
//    // http://localhost:8080/print/patients
//    @GetMapping("print/patients")
//    public List<Patient> printPatients() {
//        emailSenderService.sendNotification();
//        return patientService.printPatients();
//    }
//
//    // http://localhost:8080/filterByAddress/patients?address=moscow
//    @GetMapping("filterByAddress/patients")
//    public ResponseEntity<List<Patient>> filterByAddress(@RequestParam(name = "address") String address){
//        final List<Patient> patients = patientService.findPatientByAddress(address);
//        return patients != null && !patients.isEmpty()
//                ? new ResponseEntity<>(patients, HttpStatus.OK)
//                : new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
//
//    // http://localhost:8080/findPatientByFirstName/patients?firstName=Ivan
//    @GetMapping("findPatientByFirstName/patients")
//    public ResponseEntity<List<Patient>> findPatientByFirstName(@RequestParam(name = "firstName") String firstName){
//        final List<Patient> patients = patientService.findPatientByFirstName(firstName);
//        return patients != null || !patients.isEmpty()
//                ? new ResponseEntity<>(patients, HttpStatus.OK)
//                : new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
//
//    // http://localhost:8080/findPatientByLastName/patients?firstName=Ivanov
//    @GetMapping("findPatientByLastName/patients")
//    public ResponseEntity<List<Patient>> findPatientByLastName(@RequestParam(name = "lastName") String lastName){
//        final List<Patient> patients = patientService.findPatientByLastName(lastName);
//        return patients != null || !patients.isEmpty()
//                ? new ResponseEntity<>(patients, HttpStatus.OK)
//                : new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
}
