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
    //Находит средний возраст всех животных
    double findAverageAge(Animal[] animals);
    //возраст которых больше 5 лет и стоимость которых больше средней стоимости всех животных
    List<Animal> findOldAndExpensive(List<Animal> animals);
    //3 животных с самой низкой ценой, возвращает список имен
    List<String> findMinConstAnimals(List<Animal> animals);
}
