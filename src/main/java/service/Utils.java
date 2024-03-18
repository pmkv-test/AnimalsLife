package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static LocalDate getRandomDate() {
        String startDate = "20-12-2023", endDate = "10-03-2024",  format = "dd-MM-yyyy";

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
}
