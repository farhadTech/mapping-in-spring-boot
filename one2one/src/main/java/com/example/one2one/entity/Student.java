package com.example.one2one.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    // foreign key
    @OneToOne
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