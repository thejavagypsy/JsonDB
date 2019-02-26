package com.thegypsycoder.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Data
@AllArgsConstructor
@Embeddable
public class Address {

    private String street;
    private String suite;
    private String zipcode;
    private String city;

    @Embedded
    private Geo geo;

    public Address() {
    }
}
