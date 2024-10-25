package org.example.dto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityDtoTest {

    static List<CityDto> cities;

    @BeforeAll
    static void initCommonData(){
        cities = List.of(
                new CityDto("Pau"),
                new CityDto("Toulouse"),
                new CityDto("Lyon")
        );
    }

    List<CityDto> modifiableCities;

    @BeforeEach
    void initEachData(){
        modifiableCities = new ArrayList<>();
        modifiableCities.addAll(cities);
    }

    @Test
    void test_constructor_default() {
        var city = new CityDto();
        assertNull(city.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Y", "Pau", "Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch"})
    void test_constructor_name(String name){
        var city = new CityDto(name);
        assertEquals(name, city.getName());
    }

    // cleanup
    // @AfterAll
    // @AfterEach
}