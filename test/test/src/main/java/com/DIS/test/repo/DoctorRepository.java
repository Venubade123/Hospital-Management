package com.DIS.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DIS.test.model.Doctor;



@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
