import animal.pet.Dog;
import animal.predator.Shark;
import animal.predator.Wolf;
import service.CreateAnimalService;
import service.CreateAnimalServiceImpl;
import service.InvalidAnimalBirthDateException;
import service.InvalidAnimalException;

public class Main {
    public static void main(String[] args)  {
        CreateAnimalService createAnimalService = new CreateAnimalService();
        try {
            createAnimalService.createAnimals();
        } catch (InvalidAnimalBirthDateException e) {
            throw new InvalidAnimalException("Работа метода завершилась ошибкой\n"+e);
        }
        System.out.println("========================== FOR =====");
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        try {
            createAnimalServiceImpl.createAnimals(5);
        } catch (InvalidAnimalBirthDateException e) {
            throw new InvalidAnimalException("Работа перегруженного метода завершилась ошибкой\n"+e);
        }
        System.out.println("========================== DO-WHILE =====");
        try {
        createAnimalServiceImpl.createAnimals();
        } catch (InvalidAnimalBirthDateException e) {
            throw new InvalidAnimalException("Работа переопределенного метода завершилась ошибкой\n"+e);
        }

    }
}