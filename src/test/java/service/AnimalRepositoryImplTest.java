package service;

import animal.AbstractAnimal;
import animal.Animal;
import animal.pet.Cat;
import animal.pet.Dog;
import animal.predator.Shark;
import animal.predator.Wolf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryImplTest {
    //возвращает список животных, двое родились в високосный год
    private List<Animal> getAnimals(){
        List<Animal> listTestAnimal = new ArrayList<>();
        LocalDate birthDate;
        Shark shark; Wolf wolf; Cat cat; Dog dog;

        shark = new Shark();
        birthDate = LocalDate.parse("11-03-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        shark.setBirthDate(birthDate);
        shark.setName("1");
        listTestAnimal.add(shark);

        shark = new Shark();
        birthDate = LocalDate.parse("21-10-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        shark.setBirthDate(birthDate);
        shark.setName("2");
        listTestAnimal.add(shark);

        wolf = new Wolf();
        //високосный год
        birthDate = LocalDate.parse("15-02-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        wolf.setBirthDate(birthDate);
        wolf.setName("4");
        listTestAnimal.add(wolf);
        //високосный год
        cat = new Cat();
        birthDate = LocalDate.parse("10-01-2016", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        cat.setBirthDate(birthDate);
        cat.setName("8");
        listTestAnimal.add(cat);

        dog = new Dog();
        birthDate = LocalDate.parse("27-09-2017", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        dog.setBirthDate(birthDate);
        dog.setName("9");
        listTestAnimal.add(dog);

        dog = new Dog();
        birthDate = LocalDate.parse("26-11-2018", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        dog.setBirthDate(birthDate);
        dog.setName("10");
        listTestAnimal.add(dog);

        dog = new Dog();
        birthDate = LocalDate.parse("16-12-2019", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        dog.setBirthDate(birthDate);
        dog.setName("7");
        listTestAnimal.add(dog);

        return listTestAnimal;
    }
    @DisplayName("Проверка животных в массиве на рождение в високосный год")
    @Test
    void findLeapYearNames() {
        AnimalRepositoryImpl animalRepository = new  AnimalRepositoryImpl();
        Map<String, LocalDate> leapYearAnimals = animalRepository.findLeapYearNames(Utils.listToArray(getAnimals()));
        //двое в високосный
        assertEquals(2,leapYearAnimals.size());

    }
    @DisplayName("Проверка на возраст")
    @Test
    void findOlderAnimal() {
        AnimalRepositoryImpl animalRepository = new  AnimalRepositoryImpl();
        //4 животных старше 3 лет
        Map<Animal, Integer> olderAnimal = animalRepository.findOlderAnimal(Utils.listToArray(getAnimals()),3);
        assertEquals(4,olderAnimal.size());
        //самое старшее из всех
        Map<Animal, Integer> oldestAnimal = animalRepository.findOlderAnimal(Utils.listToArray(getAnimals()),10);
        assertEquals(1,oldestAnimal.size());
        //проверяем, что самое старшее животное имеет возраст 8 лет
        Integer ageAnimal = oldestAnimal.get(oldestAnimal.keySet().iterator().next());
        assertEquals(8,ageAnimal);
    }
    @DisplayName("Проверка на дубли по типу животных")
    @Test
    void findDuplicate() {
        AnimalRepositoryImpl animalRepository = new  AnimalRepositoryImpl();
        Map<String, Integer> duplicatesMap = animalRepository.findDuplicate(Utils.listToArray(getAnimals()));
        //всего два типа животных с дублями
        assertEquals(2,duplicatesMap.size());
        //животных c дублями типа Shark = 2
        assertEquals(2,duplicatesMap.get("Shark"));
        //животных c дублями типа Dog = 3
        assertEquals(3,duplicatesMap.get("Dog"));
    }
}