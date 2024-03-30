package service;

import animal.Animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class AnimalRepositoryImpl implements AnimalRepository {


    @Override
    public Map<String, LocalDate> findLeapYearNames(Animal[] animals) {
        Map<String, LocalDate> leapYearAnimals = Arrays.stream(animals)
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(
                        animal -> animal.getType() + " " + animal.getName(),
                        Animal::getBirthDate
                ));
        return leapYearAnimals;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(Animal[] animals, int N) {
        Animal oldestAnimal = null;
        Map<Animal, Integer> olderAnimal = Arrays.stream(animals)
                .filter(animal -> animal.getAge() > N)
                .peek(animal -> System.out.println(animal.getName() + " " + animal.getBirthDate()))
                .collect(Collectors.toMap(Function.identity(), Animal::getAge));

        //если при заданном N не было найдено ни одного животного, возвращаем самого старшего
        if (olderAnimal.isEmpty()) {
            oldestAnimal = Arrays.stream(animals)
                    .max(Comparator.comparing(animal -> Utils.calculateAge(animal.getBirthDate())))
                    .orElse(null);
        }

        if (oldestAnimal != null) {
            olderAnimal.put(oldestAnimal, oldestAnimal.getAge());
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Самое старшее: " + oldestAnimal.getName() + " " + oldestAnimal.getBirthDate() + ", Age=" + Utils.calculateAge(oldestAnimal.getBirthDate()));
        }
        return olderAnimal;
    }

    @Override
    public Map<String, Integer> findDuplicate(Animal[] animals) {
        Map<String, Integer> duplicatesMap = Arrays.stream(animals)
                .collect(Collectors.groupingBy(Animal::getType, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().intValue()));
        return duplicatesMap;
    }

    //Средний возраст всех животных
    @Override
    public double findAverageAge(Animal[] animals) {
        double averageAge = Arrays.stream(animals)
                .mapToInt(Animal::getAge)
                .average()
                .orElse(0);
        System.out.println("Средний возраст животных: " + averageAge);
        return averageAge;
    }

    //возраст больше 5 лет и стоимость которых больше средней стоимости всех животных
    @Override
    public List<Animal> findOldAndExpensive(List<Animal> animals) {
        //вычисляем среднюю стоимость
        double averagePrice = animals.stream()
                .mapToDouble(Animal::getCost)
                .average()
                .orElse(0);
        System.out.println("Средняя стоимость: " + averagePrice);
        //фильтруем по возрасту >5 и стоимости и сортируем по дате рождения (по возрастанию)
        List<Animal> orderAnimals = animals.stream()
                .filter(animal -> animal.getAge() > 5 && animal.getCost() > averagePrice)
                .sorted((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()))
                .collect(Collectors.toList());
        return orderAnimals;
    }

    //3 животных с самой низкой ценой, возвращает список имен
    @Override
    public List<String> findMinConstAnimals(List<Animal> animals) {
        List<String> orderAnimals = animals.stream()
                .sorted(Comparator.comparingDouble(Animal::getCost)) //сортируем животных по цене от дешевого к дорогому
                .limit(3) //ограничиваем тремя дешевыми
                .map(Animal::getName)//получаем список имен
                .sorted(Comparator.reverseOrder()) //сортируем имена в обратном алфавитном порядке
                .collect(Collectors.toList());
        return orderAnimals;
    }

}
