package service;

import animal.AbstractAnimal;
import animal.Animal;
import animal.predator.Predator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateAnimalServiceImpl implements CreateAnimalService {


    public void createAnimals(int countAnimals) throws InvalidAnimalBirthDateException {
        for (int i = 0; i <= countAnimals-1; i++) {
            AbstractAnimal animal = createObject(i);
            LocalDate birthDate = Utils.getRandomDate();
            animal.setBirthDate(birthDate);
            animal.setName(String.valueOf(i+1));
            SearchServiceImpl searchService = new SearchServiceImpl();
            searchService.checkLeapYearAnimal(animal);
            System.out.println(animal.getName()+". Дата рождения: "+animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("-------------");
        }
    }

    @Override
    public void createAnimals() throws InvalidAnimalBirthDateException {
        int count = 0;
        do {
            AbstractAnimal animal = createObject(count); // Создание нового объекта, реализующего интерфейс
            LocalDate birthDate = Utils.getRandomDate();
            animal.setBirthDate(birthDate);
            animal.setName(String.valueOf(count+1));
            SearchServiceImpl searchService = new SearchServiceImpl();
            searchService.checkLeapYearAnimal(animal);
            System.out.println(animal.getName()+". Дата рождения: "+animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("-------------");
            count++;
        } while (count < 10);
    }
}
