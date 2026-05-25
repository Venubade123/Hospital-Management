package com.DIS.test.controller;


import com.DIS.test.model.Doctor;
import com.DIS.test.service.DoctorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorCont {

    @Autowired
    private DoctorImp doctorImp;

    @PostMapping("/store")
    public void store(@RequestBody Doctor doctor) {

        doctorImp.saveDoctorName(doctor);
    }
}
