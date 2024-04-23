package oop.oop1;

public class Car {
    static int wheelNum = 4; // 轮子数量
    int speed = 32; // 当前车速
    int ac = 26; // 空调温度

    public void accelerate() {
        // 加速
        // 由于加速是某个车辆对象自己的行为，因此不用static修饰
        speed += 5;
        System.out.println("宝马车加速");
    }

    public void decelerate() {
        // 减速
        speed -= 5;
        if (speed < 0) {
            speed = 0;
        }
    }

    public static void addWheel() {
        wheelNum += 1;
        System.out.println("所有车都要多装一个轮子");
    }
    public static void main(String[] args) {
        Car benz = new Car(); // 创建奔驰车
        Car bmw = new Car(); // 创建宝马车

//        可以通过类名直接调用有static关键字（轿车这类物体共有）的属性，轿车都有4个轮子
        System.out.printf("车都有%d个轮子\n", Car.wheelNum);

//        自然地，我们也可以通过该类下的对象调用类共有的属性，宝马和奔驰没道理不是四个轮子
        System.out.printf("宝马车有%d个轮子\n", bmw.wheelNum);

//        执行下面这句指令会报错，因为speed是每个轿车对象特有的属性
//        System.out.println(Car.speed);

//        因此只能通过某个轿车对象来调用speed属性
        System.out.printf("奔驰车的速度是%dkm/h\n", benz.speed);
        System.out.printf("宝马车的速度是%dkm/h\n", bmw.speed);

//       由于speed是对象自己的属性，宝马车加速不会改变奔驰车的速度
        bmw.accelerate();
        System.out.printf("奔驰车的速度是%dkm/h\n", benz.speed);
        System.out.printf("宝马车的速度是%dkm/h\n", bmw.speed);

//        但是，由于wheelNum是整个类共有的属性，牵一发而动全身
        bmw.addWheel();
        System.out.printf("宝马车有%d个轮子\n", bmw.wheelNum);
        System.out.printf("奔驰车有%d个轮子\n", benz.wheelNum);
    }
}
