package service;

import animal.AbstractAnimal;
import animal.Animal;
import animal.predator.Predator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements CreateAnimalService {


    public Map<String, List<Animal>> createAnimals(int countAnimals) throws InvalidAnimalBirthDateException {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        List<Animal> listAllAnimal = new ArrayList<>();
        for (int i = 0; i <= countAnimals-1; i++) {
            AbstractAnimal animal = createObject(i,listAllAnimal);
            LocalDate birthDate = Utils.getRandomDate();
            animal.setBirthDate(birthDate);
            animal.setName(String.valueOf(i+1));
            SearchServiceImpl searchService = new SearchServiceImpl();
            searchService.checkLeapYearAnimal(animal);
            System.out.println(animal.getName()+". Дата рождения: "+animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("-------------");
        }
        animalMap = filterByType(listAllAnimal);
        return animalMap;
    }

    @Override
    public Map<String, List<Animal>> createAnimals() throws InvalidAnimalBirthDateException {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        List<Animal> listAllAnimal = new ArrayList<>();
        int count = 0;
        do {
            AbstractAnimal animal = createObject(count,listAllAnimal); // Создание нового объекта, реализующего интерфейс
            LocalDate birthDate = Utils.getRandomDate();
            animal.setBirthDate(birthDate);
            animal.setName(String.valueOf(count+1));
            SearchServiceImpl searchService = new SearchServiceImpl();
            searchService.checkLeapYearAnimal(animal);
            System.out.println(animal.getName()+". Дата рождения: "+animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("-------------");
            count++;
        } while (count < 10);
        animalMap = filterByType(listAllAnimal);
        return animalMap;
    }
}
