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
        addressRepository.save(address);

        Student student = new Student("Abhilash", 12345678L, address);
        studentRepository.save(student);

        System.out.println("Data Saved successfully");
    }
}

