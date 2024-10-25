package org.example;

import org.example.dto.CityDto;
import org.example.entity.City;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * class Main
 */
public class Main {

    private static void fillListCities(List<String> cities){
        Collections.addAll(cities, "Pau", "Toulouse", "Lyon");
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello world in: 東京 !");

        // Java 5
        List<String> cities = new ArrayList<String>();
        fillListCities(cities);
        for (String city: cities){
            System.out.println(city);
        }

        // Java 7
        List<String> cities2 = new ArrayList<>();
        fillListCities(cities2);

        // Java 10
        var cities3 = new ArrayList<String>();
        fillListCities(cities3);
        for (var city: cities3){
            System.out.println(city);
        }

        // using mapper (external lib)
        var mapper = new ModelMapper();
        var cityEntity = new City("Toulouse");
        var cityDto = mapper.map(cityEntity, CityDto.class);
        System.out.println(cityEntity + " -> " + cityDto);
    }
}