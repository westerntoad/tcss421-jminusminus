import java.lang.System;

public class Ex515 {
    public static void main(String[] args) {
        testThrowInFunction1();
        testThrowInFunction2();
        testThrowInFunction3();
    }

    public static void testThrowInFunction1() {
        try {
            function1();
            System.out.println("Function1: Failed");
        } catch (Exception e) {
            System.out.println("Function1: Passed");
        }
    }

    public static void testThrowInFunction2() {
        try {
            function2();
            System.out.println("Function2: Failed");
        } catch (Exception e) {
            System.out.println("Function2: Passed");
        }
    }

    public static void testThrowInFunction3() {
        try {
            function3();
            System.out.println("Function3: Failed");
        } catch (Exception e) {
            System.out.println("Function3: Passed");
        }
    }

    public static void function1() throws Exception {
        throw new Exception("Exception in function1");
    }

    public static void function2() throws Exception {
        throw new Exception("Exception in function2");
    }

    public static void function3() throws Exception {
        throw new Exception("Exception in function3");
    }
}