package service;

import animal.AbstractAnimal;
import animal.Animal;
import animal.pet.Cat;
import animal.pet.Dog;
import animal.pet.Pet;
import animal.predator.Predator;
import animal.predator.Shark;
import animal.predator.Wolf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static service.Utils.listToArray;

public interface CreateAnimalService {

    default AbstractAnimal createObject(int i, List<Animal> listAllAnimal) {
        switch (i % 4) {
            case 0:
                Shark shark = new Shark();
                listAllAnimal.add(shark);
                return shark;
            case 1:
                Cat cat = new Cat();
                listAllAnimal.add(cat);
                return cat;
            case 2:
                Wolf wolf = new Wolf();
                listAllAnimal.add(wolf);
                return wolf;
            case 3:
                Dog dog = new Dog();
                listAllAnimal.add(dog);
                return dog;
            default:
                return null;
        }
    }

    default Map<String, List<Animal>>  filterByType(List<Animal> animals) {
        Map<String, List<Animal>> animalMapByType = new HashMap<>();
        List<Animal> filteredCatType = new ArrayList<>();
        List<Animal> filteredDogType = new ArrayList<>();
        List<Animal> filteredSharkType = new ArrayList<>();
        List<Animal> filteredWolfType = new ArrayList<>();
        for (Animal animal : animals) {
            switch (animal.getType()) {
                case "Cat": filteredCatType.add(animal);
                    break;
                case "Dog": filteredDogType.add(animal);
                    break;
                case "Shark": filteredSharkType.add(animal);
                    break;
                case "Wolf": filteredWolfType.add(animal);
                    break;
            }
        }
        animalMapByType.put("Cat", filteredCatType);
        animalMapByType.put("Dog", filteredDogType);
        animalMapByType.put("Shark", filteredSharkType);
        animalMapByType.put("Wolf", filteredWolfType);
        return animalMapByType;
    }

    default Map<String, List<Animal>> createAnimals() throws InvalidAnimalBirthDateException {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        List<Animal> listAllAnimal = new ArrayList<>();
        int count = 0;
        while (count < 10)
        {
            AbstractAnimal animal = createObject(count,listAllAnimal);
            LocalDate birthDate = Utils.getRandomDate();
            animal.setBirthDate(birthDate);
            animal.setName(String.valueOf(count+1));
            SearchServiceImpl searchService = new SearchServiceImpl();
            searchService.checkLeapYearAnimal(animal);
            System.out.println(animal.getName()+". Дата рождения: "+animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("-------------");
            count++;
        }
        animalMap = filterByType(listAllAnimal);
        return animalMap;
    }


}
