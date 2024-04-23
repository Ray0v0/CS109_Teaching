package oop.oop2;

public class ElectricCar extends Car{
    public void accelerate() {
        speed += 10;
        System.out.println("电车加速");
    }
    public static void main(String[] args) {
        ElectricCar su7 = new ElectricCar();
        su7.accelerate();
        System.out.printf("加速后SU7的速度是%dkm/h\n", su7.speed);
    }
}
