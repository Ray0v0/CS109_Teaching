package oop.oop4;

public class ElectricCar extends Car {
    @Override
    public void accelerate() {
        speed += 10;
        System.out.println("电车加速");
    }
}
