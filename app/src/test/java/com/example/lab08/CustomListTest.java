package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CustomListTest {
    private CustomList mockCityList() {
        CustomList cityList = new CustomList();
        cityList.addCity(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testHasCity() {
        CustomList cityList = mockCityList();
        City city = mockCity();
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testNotHasCity() {
        CustomList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CustomList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        cityList.deleteCity(mockCity());
        assertFalse(cityList.hasCity(mockCity()));
    }

    @Test
    void testDeleteException() {
        CustomList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city));

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test
    void testCount() {
        CustomList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City city = new City("Calgary", "Alberta");
        cityList.addCity(city);
        assertEquals(2, cityList.countCities());

        cityList.deleteCity(city);
        assertEquals(1, cityList.countCities());
    }
}
