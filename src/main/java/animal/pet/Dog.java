package animal.pet;

import java.time.LocalDate;

public class Dog extends Pet {

    @Override
    public String getType() {
        String type = "Dog";
        return type;
    }

    @Override
    //порода
    public String gertBreed() {
        super.breed = "Собачья порода";
        return super.breed;
    }

    @Override
    //имя
    public String getName() {
        return super.name;
    }
    @Override
    public void setName(String animalName) {
        name = "Собака_"+animalName;
    }

    @Override
    //цена
    public Double getCost() {
        super.cost = 50.50;
        return super.cost;
    }

    @Override
    public String getCharacter() {
        super.character ="Собачий характер";
        return super.character;
    }

}
