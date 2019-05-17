package com.springtesting.dto;

import com.springtesting.model.*;
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
