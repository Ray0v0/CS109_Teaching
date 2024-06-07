package oop.implementation;

import java.util.Arrays;

public class SortObjects {
    public static void main(String[] args) {
        // 使用Arrays.sort()方法可以很轻易对int[]进行排序
        int[] a = new int[]{3, 1, 2};
        Arrays.sort(a);
        System.out.print("a数组排序后: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();

        // 但如果需要排序的对象是一个自定义的对象，我们应该如何告诉Java怎么排序呢？

        // 对于一个不知道如何比较大小的类，直接调用Arrays.sort()方法会报错
        ExampleClass1[] b = new ExampleClass1[] {
                new ExampleClass1(3),
                new ExampleClass1(1),
                new ExampleClass1(2)
        };
//        Arrays.sort(b);
        System.out.print("b数组排序后（b数组无法排序）: ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            System.out.print(" ");
        }
        System.out.println();

        // 我们可以通过实现接口的方式告诉Java这个类应该怎么排序
        ExampleClass2[] c = new ExampleClass2[] {
                new ExampleClass2(3),
                new ExampleClass2(1),
                new ExampleClass2(2)
        };
        Arrays.sort(c);
        System.out.print("c数组排序后: ");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static class ExampleClass1 {
        int value;
        private ExampleClass1(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private static class ExampleClass2 implements Comparable<ExampleClass2> {
        int value;
        private ExampleClass2(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Override
        public int compareTo(ExampleClass2 o) {
            // Comparable接口定义：
            // 若o1 > o2，则o1.compareTo(o2)的返回值应当 > 0
            // 若o1 == o2，则o1.compareTo(o2)的返回值应当 = 0
            // 若o1 < o2，则o1.compareTo(o2)的返回值应当 < 0
            // 我们只要把这个逻辑实现就好了
            return this.value - o.value;
            // 当然也可以采取其他方式，例如下面这样
//            int ret = 0;
//            if (this.value > o.value) ret = 1;
//            else if (this.value == o.value) ret = 0;
//            else ret = -1;
//            return ret;
        }
    }
}
