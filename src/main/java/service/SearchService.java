package service;

import animal.Animal;

public interface SearchService {
    void checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException;
}
