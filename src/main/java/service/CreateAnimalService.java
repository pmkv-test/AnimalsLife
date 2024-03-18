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

public class CreateAnimalService {

    protected AbstractAnimal createObject(int i) {
        switch (i % 4) {
            case 0:
                return new Shark();
            case 1:
                return new Cat();
            case 2:
                return new Wolf();
            case 3:
                return new Dog();
            default:
                return null;
        }
    }

    public void createAnimals() throws InvalidAnimalBirthDateException {
        int count = 0;
        Utils utils = new Utils();

        while (count < 10)
        {
            AbstractAnimal animal = createObject(count);
            LocalDate birthDate = utils.getRandomDate();
            animal.setBirthDate(birthDate);
            animal.setName(String.valueOf(count+1));
            SearchServiceImpl searchService = new SearchServiceImpl();
            searchService.checkLeapYearAnimal(animal);
            System.out.println(animal.getName()+". Дата рождения: "+animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("-------------");
            count++;
        }
    }


}
