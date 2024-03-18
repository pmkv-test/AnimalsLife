package animal.predator;

import animal.AbstractAnimal;

import java.time.LocalDate;

public abstract class Predator extends AbstractAnimal {

    @Override
    public String getType() {
        String type = "Хищник";
        return type;
    }


}
