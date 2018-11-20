package com.springtesting.mockito;

import com.springtesting.model.*;
import com.springtesting.repo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(value = "integrationtest")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressRepositoryTest
{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressTypeRepository addressTypeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Test
    public void createAddress()
    {
        String type="Home";
        String city="ALEXANDRIA";
        String state="Virginia";
        String country="United States";
        String region="NA";

        Address address=new Address();

        AddressType addressType = findOrCreateAddressType(type);
        address.setStreetName("3130 Fairview park");
        address.setApartment("STE 350");
        address.setAddressType(addressType);
        address.setCity(findCity(city,state));
        address.setState(findState(state));
        address.setCountry(findCountry(country));
        address.setRegion(findRegion(region));
        address.setZipCode("39072");
        address=addressRepository.saveAndFlush(address);

        System.out.println("Inserted Address -> "+address.toString());
    }

    @Test
    public void insertData()
    {
        String city="BAKERSVILLE";
        String state="Virginia";
        String stateCode="VA";
        String country="United States";
        String region="NA";

        createRegion(region);
        createCountry(country,region);
        createState(state,stateCode,country,region);
        createCity(city,state);

    }



    private AddressType findOrCreateAddressType(String type)
    {
        Optional<AddressType> addressTypeOptional=addressTypeRepository.findAddressTypeByType(type);
        return addressTypeOptional.orElseGet(() -> addressTypeRepository.saveAndFlush(new AddressType(type)));
    }

    private City findCity(String name)
    {
        if(name == null)
            return null;
        return cityRepository.findByName(name).orElse(null);
    }

    private City findCity(String name, String stateName)
    {
        if(name == null)
            return null;
        Optional<City> cityOptional;
        State state=findState(stateName,"","");
        if(state == null)
            cityOptional=cityRepository.findByName(name);
        else
            cityOptional=cityRepository.findByNameAndState(name,state);
        return cityOptional.orElse(null);
    }

    private City createCity(String name, String stateName)
    {
        if(name == null)
            return null;
        Optional<City> cityOptional;
        City city=findCity(name,stateName);
        if(city != null)
            return city;
        else if(stateName == null)
            return cityRepository.saveAndFlush(new City(name,null));
        else
            return cityRepository.saveAndFlush(new City(name,findState(stateName,"","")));
    }

    private State findState(String name)
    {
        if(name == null)
            return null;
        return stateRepository.findByName(name).orElse(null);
    }

    private State findState(String name,String countryName, String regionName)
    {
        if(name == null)
            return null;
        Optional<State> stateOptional;
        Country country=findCountry(countryName,regionName);
        if(country == null)
            stateOptional=stateRepository.findByName(name);
        else
            stateOptional=stateRepository.findByNameAndCountry(name,country);
        return stateOptional.orElse(null);
    }

    private State createState(String name,String code,String countryName, String regionName)
    {
        if(name == null)
            return null;
        Optional<State> stateOptional;
        State state=findState(name,countryName,regionName);
        if(state!=null)
            return state;
        else if(countryName == null)
            return stateRepository.saveAndFlush(new State(name,code,null));
        else
            return stateRepository.saveAndFlush(new State(name,code,findCountry(countryName,regionName)));
    }

    private Country findCountry(String name,String regionName)
    {
        if(name == null)
            return null;
        Region region=findRegion(regionName);
        Optional<Country> countryOptional;
        if(region == null)
            countryOptional=countryRepository.findByName(name);
        else
            countryOptional=countryRepository.findByNameAndRegion(name,region);
        return countryOptional.orElse(null);
    }

    private Country findCountry(String name)
    {
        if(name == null)
            return null;
        return countryRepository.findByName(name).orElse(null);
    }
    private Country createCountry(String name,String regionName)
    {
        if(name == null)
            return null;
        Country country=findCountry(name,regionName);
        Region region=findRegion(regionName);
        if(country!=null)
            return country;
        else if(regionName == null)
            return countryRepository.saveAndFlush(new Country(name));
        else
            return countryRepository.saveAndFlush(new Country(name, region));
    }

    private Region findRegion(String name)
    {
        if(name == null)
            return null;
        return regionRepository.findByName(name).orElse(null);
    }

    private Region createRegion(String name)
    {
        if(name == null)
            return null;
        return regionRepository.findByName(name).orElseGet(() -> regionRepository.saveAndFlush(new Region(name)));
    }
}
