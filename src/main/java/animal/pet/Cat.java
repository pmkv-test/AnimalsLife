package animal.pet;

import java.time.LocalDate;

public class Cat extends Pet {

    @Override
    public String getType() {
        String type = "Cat";
        return type;
    }


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
    @Override
    public void setName(String animalName) {
        name = "Кошка_"+animalName;
    }

    @Override
    //цена
    public Double getCost() {
        super.cost = 400.50;
        return super.cost;
    }

    @Override
    public String getCharacter() {
        super.character ="Кошачий характер";
        return super.character;
    }

}
