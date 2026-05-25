package com.DIS.test.service;

import com.DIS.test.model.Doctor;
import com.DIS.test.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorImp {

    @Autowired
    private DoctorRepository doctorRepository;

    public void saveDoctorName(Doctor doctorName){

        doctorRepository.save(doctorName);
    }
}