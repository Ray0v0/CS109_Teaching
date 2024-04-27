package oop.encapsulation;

public class TestClass {
    private static int m = 10;
    public static void main(String[] args) {
        InnerClass t = new InnerClass();
        System.out.println(t.n);
        t.n = 15;
        System.out.println(t.n);
    }
    static private class InnerClass extends TestClass {
        int n;
        private InnerClass() {
        }

        InnerClass(int m) {
        }

    }
}
