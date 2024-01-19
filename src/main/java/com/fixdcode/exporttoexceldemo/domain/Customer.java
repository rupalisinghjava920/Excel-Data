package com.fixdcode.exporttoexceldemo.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    @Embedded
    private Address address;

    public Customer(String firstName,String lastName,String email,Address address){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.address=address;
    }


}
