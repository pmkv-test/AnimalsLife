package animal.predator;

import java.time.LocalDate;

public class Wolf extends Predator {

    private static final Double COST = 800.50;

    @Override
    public String getType() {
        String type = "Wolf";
        return type;
    }

    @Override
    //порода
    public String gertBreed() {
        super.breed = "Волчья порода";
        return super.breed ;
    }

    @Override
    //имя
    public String getName() {
        return super.name;
    }
    @Override
    public void setName(String animalName) {
        name = "Волк_"+animalName;
    }

    public void setCost(double cost) {super.cost = cost;}
    @Override
    //цена
    public Double getCost() {
        return super.cost;
    }

    @Override
    public String getCharacter() {
        super.character ="Волчий характер";
        return super.character;
    }


}
