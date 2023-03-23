package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class CountryTest {

    @Test
    void printCountriesTestNull() {

        Country.printCountries(null);

    }

    @Test
    void printCountriesTestEmpty()
    {

        ArrayList<Country> countries = new ArrayList<>();
        Country.printCountries(countries);

    }

    @Test
    void printCountriesTest()
    {

        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.code = "POG";
        country.capital = "Pogging";
        country.continent = "Meme";
        country.name = "Pog Fish";
        country.population = 69;
        country.region = "Face";
        countries.add(country);
        Country.printCountries(countries);

    }

}

class CityTest {

    @Test
    void printCitiesTestNull() {

        City.printCities(null);

    }

    @Test
    void printCountriesTestEmpty()
    {

        ArrayList<City> cities = new ArrayList<>();
        City.printCities(cities);

    }

    @Test
    void printCountriesTest()
    {

        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.country = "Pog Fish";
        city.district = "Fish";
        city.name = "Pogging";
        city.population = 69;
        City.printCities(cities);

    }

}