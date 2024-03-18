package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// RuntimeException если экземпляр животного = null
public class InvalidAnimalException extends RuntimeException {

    public InvalidAnimalException(String message){
        super(message + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

}
