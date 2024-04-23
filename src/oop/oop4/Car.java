package oop.oop4;

public class Car {
    static int wheelNum = 4; // 轮子数量
    int speed = 32; // 当前车速
    int ac = 25; // 空调温度

    public void decelerate() {
        // 减速
        speed -= 5;
        if (speed < 0) {
            speed = 0;
        }
    }

    public void accelerate() {
        speed += 5;
        System.out.println("轿车加速");
    }

    public static void main(String[] args) {
        Car su7 = new ElectricCar();

//        即使su7的类型是Car而非ElectricCar，下面的accelerate()方法仍然会优先调用ElectricCar的accelerate方法
        su7.accelerate();
    }
}
