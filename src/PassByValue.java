import java.util.ArrayList;
import java.util.Arrays;

public class PassByValue {
    public static void main(String[] args) {
        int n = 5;
        System.out.printf("执行adjustInt()方法前，n的值为%d\n", n);
        adjustInt(n);
        System.out.printf("执行adjustInt()方法后，n的值为%d\n", n);
        System.out.println();

        int[] a = new int[]{1, 2, 3};
        System.out.printf("执行adjustArray()方法前，a中的值为%s\n", Arrays.toString(a));
        adjustArray(a);
        System.out.printf("执行adjustArray()方法后，a中的值为%s\n", Arrays.toString(a));
        System.out.println();

        ObjectInt objectN = new ObjectInt();
        objectN.n = 5;
        System.out.printf("执行adjustObjectInt()方法前，objectN中的值为%d\n", objectN.n);
        adjustObjectInt(objectN);
        System.out.printf("执行adjustObjectInt()方法后，objectN中的值为%s\n", objectN.n);
        System.out.println();

        String s = "123";
        System.out.printf("执行adjustString()方法前，s的值为%s\n", s);
        adjustString(s);
        System.out.printf("执行adjustString()方法后，s的值为%s\n", s);
    }

    static void adjustInt(int n) {
        n += 1;
        System.out.printf("adjustInt()方法中，n的值被修改为%d\n", n);
    }

    static void adjustArray(int[] a) {
        a[0] += 1;
        System.out.printf("adjustArray()方法中，a中的值被修改为%s\n", Arrays.toString(a));
    }

    static void adjustObjectInt(ObjectInt objectInt) {
        objectInt.n += 1;
        System.out.printf("adjustObjectInt()方法中，objectN的值被修改为%d\n", objectInt.n);
    }

    static void adjustString(String s) {
        s += "4";
        System.out.printf("adjustString()方法中，s的值被修改为%s\n", s);
    }

    static class ObjectInt {
        int n;
    }
}
