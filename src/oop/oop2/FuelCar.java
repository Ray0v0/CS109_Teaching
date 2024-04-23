package oop.oop2;

public class FuelCar extends Car {
    public void accelerate() {
        speed += 5;
        System.out.println("油车加速");
    }
    public static void main(String[] args) {
        FuelCar bmw = new FuelCar();
        bmw.accelerate();
        System.out.printf("加速后宝马的速度是%dkm/h\n", bmw.speed);
    }
}
