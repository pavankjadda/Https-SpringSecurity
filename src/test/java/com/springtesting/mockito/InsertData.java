package com.springtesting.mockito;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springtesting.model.City;
import com.springtesting.model.Country;
import com.springtesting.model.Region;
import com.springtesting.model.State;
import com.springtesting.repo.CityRepository;
import com.springtesting.repo.CountryRepository;
import com.springtesting.repo.RegionRepository;
import com.springtesting.repo.StateRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(value = "integrationtest")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InsertData
{
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Before
    public void setUp()
    {

    }

    @Test
    public void insertCountryData()
    {
        try
        {
            String[] isoCountries= Locale.getISOCountries();
            List<Country> countryList=new ArrayList<>();
            for(String isoCountryCode : isoCountries)
            {
                Locale locale=new Locale("",isoCountryCode);
                String countryCode=locale.getCountry();
                String countryIsoCode=locale.getISO3Country();
                String countryName=locale.getDisplayName();
                Country country=new Country(countryName,countryCode,countryIsoCode,findRegion("NA"));
                countryList.add(country);
            }
            countryRepository.saveAll(countryList);
            countryRepository.flush();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    @Test
    public void insertStateData() throws IOException
    {
        Map<String,String> statesMap=new HashMap<>();
        readStatesDataFromJsonFile(statesMap);
        for (Map.Entry<String,String> e: statesMap.entrySet())
        {
            stateRepository.saveAndFlush(new State(e.getValue(),e.getKey(),findCountry("United States")));
        }
    }


    @Test
    public void insertCitisData() throws IOException
    {
        HashMap<String,List<String>> citisMap= new HashMap<>();
        citisMap=readCitisDataFromJsonFile(citisMap); //Ignore this message

        for (HashMap.Entry<String,List<String>> mapEntry: citisMap.entrySet())
        {
            State state=findState(mapEntry.getKey());
            List<String> citiesInState=mapEntry.getValue();
            List<City> cityList=new ArrayList<>();
            for (String cityName : citiesInState)
            {
                try
                {
                    //Check if City name exists in Database
                    if(!cityRepository.findByNameAndState(cityName,state).isPresent())
                        cityList.add(new City(cityName,state));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            cityRepository.saveAll(cityList);
            cityRepository.flush(); //Flush changes to DB
        }
    }

    private State findState(String stateName)
    {
        return stateRepository.findByName(stateName).orElse(null);
    }

    public HashMap readCitisDataFromJsonFile(HashMap citisMap) throws IOException
    {
        File file = new ClassPathResource("data/citis-data.json").getFile();
        byte[] mapByteData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));

        ObjectMapper objectMapper = new ObjectMapper();
        citisMap = objectMapper.readValue(mapByteData, HashMap.class);
        return citisMap;
    }



    public void readStatesDataFromJsonFile(Map<String, String> statesMap) throws IOException
    {
        File file = new ClassPathResource("data/us-states-data.json").getFile();
        byte[] mapByteData = Files.readAllBytes(Paths.get(file.getAbsolutePath()));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode =objectMapper.readTree(mapByteData);
        for (int i=0;i<rootNode.size();i++)
        {
            statesMap.put(rootNode.get(i).get("abbreviation").textValue(),rootNode.get(i).get("name").textValue());
        }
    }

    private Region findRegion(String region)
    {
        return regionRepository.findByName(region).orElse(null);
    }


    private Country findCountry(String countryName)
    {
        return countryRepository.findByName(countryName).orElse(null);
    }


    private void setValues(Map<String, String> statesMap)
    {
        statesMap.put("AL","Alabama");
        statesMap.put("AK", "Alaska");
        statesMap.put("AZ", "Arizona");
        statesMap.put("AR", "Arkansas");
        statesMap.put("CA", "California");
        statesMap.put("CO", "Colorado");
        statesMap.put("CT", "Connecticut");
        statesMap.put("DE", "Delaware");
        statesMap.put("DC", "District Of Columbia");
        statesMap.put("FL", "Florida");
        statesMap.put("GA", "Georgia");
        statesMap.put("HI", "Hawaii");
        statesMap.put("ID", "Idaho");
        statesMap.put("IL", "Illinois");
        statesMap.put("IN", "Indiana");
        statesMap.put("IA", "Iowa");
        statesMap.put("KS", "Kansas");
        statesMap.put("KY", "Kentucky");
        statesMap.put("LA", "Louisiana");
        statesMap.put("ME", "Maine");
        statesMap.put("MD", "Maryland");
        statesMap.put("MA", "Massachusetts");
        statesMap.put("MI", "Michigan");
        statesMap.put("MN", "Minnesota");
        statesMap.put("MS", "Mississippi");
        statesMap.put("MO", "Missouri");
        statesMap.put("MT", "Montana");
        statesMap.put("NE", "Nebraska");
        statesMap.put("NV", "Nevada");
        statesMap.put("NH", "New Hampshire");
        statesMap.put("NJ", "New Jersey");
        statesMap.put("NM", "New Mexico");
        statesMap.put("NY", "New York");
        statesMap.put("NC", "North Carolina");
        statesMap.put("ND", "North Dakota");
        statesMap.put("OH", "Ohio");
        statesMap.put("OK", "Oklahoma");
        statesMap.put("OR", "Oregon");
        statesMap.put("PA", "Pennsylvania");
        statesMap.put("RI", "Rhode Island");
        statesMap.put("SC", "South Carolina");
        statesMap.put("SD", "South Dakota");
        statesMap.put("TN", "Tennessee");
        statesMap.put("TX", "Texas");
        statesMap.put("UT", "Utah");
        statesMap.put("VT", "Vermont");
        statesMap.put("VA", "Virginia");
        statesMap.put("WA", "Washington");
        statesMap.put("WV", "West Virginia");
        statesMap.put("WI", "Wisconsin");
        statesMap.put("WY", "Wyoming");

    }
}
