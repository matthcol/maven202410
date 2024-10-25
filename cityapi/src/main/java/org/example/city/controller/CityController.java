package org.example.city.controller;

import org.example.city.entity.City;
import org.example.city.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<City> getCities(){
        return cityRepository.findAll();
    }

    @PostMapping
    public City add(@RequestBody City city){
        return cityRepository.save(city);
    }

}
