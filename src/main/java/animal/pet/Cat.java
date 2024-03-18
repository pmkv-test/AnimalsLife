package animal.pet;

import java.time.LocalDate;

public class Cat extends Pet {

    @Override
    //порода
    public String gertBreed() {
        super.breed = "Кошачья порода";
        return super.breed;
    }

    @Override
    //имя
    public String getName() {
        return super.name;
    }

    public void setName(String animalName) {
        name = "Кошка_"+animalName;
    }

    @Override
    //цена
    public Double getCost() {
        super.cost = 10.50;
        return super.cost;
    }

    @Override
    public String getCharacter() {
        super.character ="Кошачий характер";
        return super.character;
    }

}
