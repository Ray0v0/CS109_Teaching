package oop.oop3;

public class ElectricCar extends Car {
    public void xueLeiJunJiao() {
        System.out.println("Are U OK!");
    }
    public void accelerate() {
        speed += 10;
        System.out.println("电车加速");
    }
}
