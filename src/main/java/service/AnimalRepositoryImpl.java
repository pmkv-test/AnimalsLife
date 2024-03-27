package service;

import animal.Animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class AnimalRepositoryImpl implements AnimalRepository {


    @Override
    public Map<String, LocalDate> findLeapYearNames(Animal[] animals) {
        Map<String, LocalDate> leapYearAnimals = new HashMap<>();
        for (Animal animal : animals) {
            if (animal.getBirthDate().isLeapYear()) {
                leapYearAnimals.put(animal.getType() + " " + animal.getName(), animal.getBirthDate());
                System.out.println(animal.getType() + " " + animal.getName()+". Дата рождения: "+animal.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
        }
        return leapYearAnimals;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(Animal[] animals, int N) {
        Map<Animal, Integer> olderAnimal = new HashMap<>();
        Animal oldestAnimal = null;
        for (Animal animal : animals) {
            int animalsAge = Utils.calculateAge(animal.getBirthDate());
            if (animalsAge > N) {
                olderAnimal.put(animal, animalsAge);
                System.out.println(animal.getName()+" "+animal.getBirthDate());
            }

            if (oldestAnimal == null || animalsAge > Utils.calculateAge(oldestAnimal.getBirthDate())) {
                oldestAnimal = animal;
            }
        }

        if (olderAnimal.isEmpty()) {
            olderAnimal.put(oldestAnimal, Utils.calculateAge(oldestAnimal.getBirthDate()));
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Самое старшее: "+oldestAnimal.getName()+" "+oldestAnimal.getBirthDate() +", Age="+Utils.calculateAge(oldestAnimal.getBirthDate()));
        }

        return olderAnimal;

    }

    @Override
    public Map<String, Integer> findDuplicate(Animal[] animals) {
        Map<String, Integer> duplicatesMap = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for (Animal animal : animals) {
            if (duplicatesMap.containsKey(animal.getType())) {
                duplicatesMap.put(animal.getType(), duplicatesMap.get(animal.getType()) + 1);
                if (duplicatesMap.get(duplicatesMap.keySet().iterator().next()) > 1) {
                    result.put(animal.getType(), duplicatesMap.get(animal.getType()));
                }
            } else {
                duplicatesMap.put(animal.getType(), 1);
            }
        }
        return result;
    }
}
