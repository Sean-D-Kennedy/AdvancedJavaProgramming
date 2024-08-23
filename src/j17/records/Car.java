package j17.records;

import java.util.Objects;

public class Car {
    private final String regNumber;
    private final String owner;

    public Car(String regNumber, String owner){
        this.regNumber = regNumber;
        this.owner     = owner;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(regNumber, car.regNumber) && Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, owner);
    }
}
