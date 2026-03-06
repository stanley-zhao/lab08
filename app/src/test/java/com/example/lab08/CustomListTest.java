package com.example.lab08;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    void testDelete(){
        CustomList cityList = new CustomList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException(){
        CustomList cityList = new CustomList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        assertThrows(NoSuchElementException.class, () -> {
            cityList.delete(new City("Calgary", "Alberta"));
        });
    }

    @Test
    void testCountCities(){
        CustomList cityList = new CustomList();
        City city1 = new City("Charlottetown", "Prince Edward Island");
        City city2 = new City("Halifax", "Nova Scotia");
        cityList.addCity(city1);
        cityList.addCity(city2);
        assertEquals(2, cityList.countCities());
    }
}