package com.example.one2one.service;

import com.example.one2one.entity.Address;
import com.example.one2one.entity.Student;
import com.example.one2one.repository.AddressRepository;
import com.example.one2one.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void saveData() {
        Address address = new Address("G2 SR Lane", "Bangalore", "Karnataka");
        Student student = new Student("Abhilash", 12345678L, address);

        addressRepository.save(address);
        studentRepository.save(student);

        System.out.println("Data Saved successfully");
    }

    @Transactional
    public void fetchStudentRecord() {
        Student studentData = studentRepository.findById(1L).get();
        System.out.println(studentData);
        Address address = studentData.getAddress();
        System.out.println(address.getAddressId());
    }
}

