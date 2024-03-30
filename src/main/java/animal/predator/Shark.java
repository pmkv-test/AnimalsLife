package animal.predator;

import java.time.LocalDate;

public class Shark extends Predator {

    @Override
    public String getType() {
        String type = "Shark";
        return type;
    }
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
    @Override
    public void setName(String animalName) {
        name = "Акула_"+animalName;
    }

    public void setCost(double cost) {super.cost = cost;}
    @Override
    //цена
    public Double getCost() {
        return super.cost;
    }

    @Override
    public String getCharacter() {
        super.character ="Акулий характер";
        return super.character;
    }

}
