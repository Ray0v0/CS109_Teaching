public class ComprehensionOfString {
    public static void main(String[] args) {

        // 第一题
        String s1 = "123";
        String s2 = "123";
        String s3 = s1;
        String s4 = "1234";

        if (s1 == s2) {
            s1 += "4";
        }

        if (s1 == s4) {
            s2 += "45";
        }

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);

        // 第二题
        String b = "TEST";
        String c = b;
        change(b);
//        System.out.println(b == c);
    }

    private static void change(String b) {
        b = new String(b);
    }
}
