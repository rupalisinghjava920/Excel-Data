package com.fixdcode.exporttoexceldemo.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    private String country;
    private String states;
    private String city;
    private String address;



}
