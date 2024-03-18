package service;

import animal.Animal;

import java.time.format.DateTimeFormatter;

public class SearchServiceImpl implements SearchService {

    @Override
    public void checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException {
        if (animal ==null)
            throw new InvalidAnimalException("На вход пришел некорректный объект животного");
        if (animal.getBirthDate() == null)
            throw new InvalidAnimalBirthDateException("У животного "+ animal.getType() +" не указана дата рождения");
        if (animal.getBirthDate().isLeapYear())
            System.out.println(animal.getName()+" был рожден в високосный год");
        else System.out.println(animal.getName()+" не был рожден в високосный год");
    }
}
