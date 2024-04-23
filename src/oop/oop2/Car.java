package oop.oop2;


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

}

