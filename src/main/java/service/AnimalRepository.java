package service;

import animal.Animal;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearNames(Animal[] animals);
    Map<Animal, Integer> findOlderAnimal(Animal[] animals, int N);
    Map<String, Integer> findDuplicate(Animal[] animals);
}
