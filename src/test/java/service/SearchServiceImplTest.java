package service;

import animal.AbstractAnimal;
import animal.predator.Shark;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceImplTest {

    @DisplayName("Проверка BirthDateException на BirthDate is null")
    @Test
    void testExceptionBirthDateNull()
    {
        SearchServiceImpl searchService = new SearchServiceImpl();
        AbstractAnimal animal = new Shark();
        animal.setBirthDate(null);
    assertThrows(InvalidAnimalBirthDateException.class, () -> {
        searchService.checkLeapYearAnimal(animal);
    });
}

    @DisplayName("Проверка AnimalException на Animal object is null")
    @Test
    void testExceptionAnimalObjectNull()
    {
        SearchServiceImpl searchService = new SearchServiceImpl();
        AbstractAnimal animal = null;
        assertThrows(InvalidAnimalException.class, () -> {
            searchService.checkLeapYearAnimal(animal);
        });
    }
    @DisplayName("Проверка birthDate если високосный год true")
    @Test
    public void testCheckLeapYearAnimalPositive() {
        AbstractAnimal animal = new Shark();
        LocalDate birthDate = LocalDate.parse("10-03-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        animal.setBirthDate(birthDate);
        assertTrue(animal.getBirthDate().isLeapYear());
    }

    @DisplayName("Проверка birthDate если високосный год false")
    @Test
    public void testCheckLeapYearAnimalNegative() {
        AbstractAnimal animal = new Shark();
        LocalDate birthDate = LocalDate.parse("10-03-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        animal.setBirthDate(birthDate);
        assertFalse(animal.getBirthDate().isLeapYear());
    }

}