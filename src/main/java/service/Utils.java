package service;

import animal.Animal;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static LocalDate getRandomDate() {
        String startDate = "20-12-2015";
        String endDate = "10-03-2024";
        String format = "dd-MM-yyyy";

        try {
            LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern(format));
            LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern(format));

            long randomDays = ThreadLocalRandom.current().nextLong(0, start.until(end).getDays());
            LocalDate randomDate = start.plusDays(randomDays);
            return randomDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Animal[] listToArray(List<Animal> animals) {
        Animal[] animalArray = new Animal[animals.size()];
        animalArray = animals.toArray(animalArray);
        return animalArray;
    }

    public static int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears();
    }
}
