package animal;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;
    protected LocalDate birthDate;
    protected String getType;

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String getType() {
        return getType;
    }

    public void setBirthDate(LocalDate extBirthDate) {
        birthDate = extBirthDate;
    }
    public void setName(String animalName) {
    }
}
