package com.example.one2one.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long studentId;

    private String name;

    private Long mobile;

    public Student(String name, Long mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public Student() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    // foreign key
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address addressId;

    public Student(String name, Long mobile, Address addressId) {
        this.name = name;
        this.mobile = mobile;
        this.addressId = addressId;
    }

    public Address getAddress() {
        return addressId;
    }

    public void setAddress(Address address) {
        this.addressId = address;
    }
}

/* Right now the addressId in Student class is a join column; so this is a foreign key,
this joins both the table so we would say this is join column.

Every student will have only one address. so it is an one to one relationship.
from the foreign key addressId we can get all details of the details of Address table.
So we will create a reference of Address not the type Long.

before: private Long addressId;
after: private Address addressId;
 */

/* In @OneToOne there is a function called fetch which internally fetch eager, for that reason,
    we will get every details of the entity. which we don't need if we want only a specific column result.
    so we need to do, @OneToOne(fetch = FetchType.LAZY).
 */
