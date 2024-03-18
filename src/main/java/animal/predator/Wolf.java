package animal.predator;

import java.time.LocalDate;

public class Wolf extends Predator {


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

    public void setName(String animalName) {
        name = "Волк_"+animalName;
    }

    @Override
    //цена
    public Double getCost() {
        super.cost = 800.50;
        return super.cost;
    }

    @Override
    public String getCharacter() {
        super.character ="Волчий характер";
        return super.character;
    }


}
