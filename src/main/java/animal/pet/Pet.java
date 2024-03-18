package animal.pet;

import animal.AbstractAnimal;

public abstract class Pet extends AbstractAnimal {

    @Override
    public String getType() {
        String type = "Домашний";
        return type;
    }

}
