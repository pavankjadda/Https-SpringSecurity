package com.springtesting.consoleapplications;

import com.springtesting.model.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CountriesClass
{
    public static void main(String[] args)
    {
        String[] isoCountries=Locale.getISOCountries();
        List<Country> countryList=new ArrayList<>();
        for(String isoCountryCode : isoCountries)
        {
            Locale locale=new Locale("",isoCountryCode);
            String countryCode=locale.getCountry();
            String countryIsoCode=locale.getISO3Country();
            String countryName=locale.getDisplayName();
            //System.out.println("Country Name: "+countryName+", Country Code: "+countryCode+", Country ISO Code: "+countryIsoCode);
            countryList.add(new Country(countryName,countryCode,countryIsoCode));
        }

    }
}
