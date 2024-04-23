package oop.oop3;

public abstract class Car {
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

    public abstract void accelerate();

    public static void main(String[] args) {
//        下面的写法会报错，因为Car是抽象类，代表了一种“概念”，不能创建对象
//        Car car = new Car();

//        但是可以创建一个具象的子类对象
        Car su7 = new ElectricCar();
        Car bmw = new FuelCar();

//        子类可以通过Car类的抽象方法调用自己的方法
        su7.accelerate();
        bmw.accelerate();

//        但是没法调用Car类没有的方法，下面的写法会报错，因为在Java看来，su7作为Car没有xueLeiJunJiao()这个方法
//        su7.xueLeiJunJiao();

//        要调用xueLeiJunJiao()方法，必须先转换类型，只有ElectricCar类的对象才有xueLeiJunJiao()这个方法
        ((ElectricCar) su7).xueLeiJunJiao();

//        类型转换可能出错，下面的代码在编译时不会报错，但在运行时会报类型转换错误（ClassCastException）
//        ((ElectricCar) bmw).xueLeiJunJiao();
    }
}
