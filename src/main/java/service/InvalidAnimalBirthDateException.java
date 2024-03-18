package service;

//Exception если нет даты рождения
public class InvalidAnimalBirthDateException extends Exception{
    public InvalidAnimalBirthDateException(String message) {super(message);}
}
