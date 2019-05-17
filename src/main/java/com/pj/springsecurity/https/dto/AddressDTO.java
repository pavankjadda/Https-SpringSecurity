package com.pj.springsecurity.https.dto;

import com.pj.springsecurity.https.model.*;
import lombok.Data;

@Data
public class AddressDTO
{
    private long id;

    private String streetName;

    private String apartment;

    private City city;

    private State state;

    private Country country;

    private Region region;

    private String zipCode;

    private AddressType addressType;
}
