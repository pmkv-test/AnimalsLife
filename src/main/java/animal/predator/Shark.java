package animal.predator;

import java.time.LocalDate;

public class Shark extends Predator {

    public LocalDate birtDate = super.birthDate;

    @Override
    //порода
    public String gertBreed() {
        super.breed = "Акулья порода";
        return super.breed;
    }

    @Override
    //имя
    public String getName() {
        return super.name;
    }

    public void setName(String animalName) {
        name = "Акула_"+animalName;
    }

    @Override
    //цена
    public Double getCost() {
        super.cost = 500.45;
        return super.cost;
    }

    @Override
    public String getCharacter() {
        super.character ="Акулий характер";
        return super.character;
    }

}
