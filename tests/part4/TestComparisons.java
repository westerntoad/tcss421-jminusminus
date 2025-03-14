import java.lang.System;

public class TestComparisons {
    public static void main(String[] args) {
        // Test for equality
        int a = 5;
        int b = 5;
        System.out.println("a = " + a + ", b = " + b);
        if (a == b) {
            System.out.println("a is equal to b");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("a is not equal to b");
            System.out.println("TEST FAILED");
        }

        // Test for inequality
        a = 5;
        b = 10;
        System.out.println("a = " + a + ", b = " + b);
        if (a != b) {
            System.out.println("a is not equal to b");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("a is equal to b");
            System.out.println("TEST FAILED");
        }

        // Test for greater than
        a = 10;
        b = 5;
        System.out.println("a = " + a + ", b = " + b);
        if (a > b) {
            System.out.println("a is greater than b");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("a is not greater than b");
            System.out.println("TEST FAILED");
        }

        // Test for less than
        a = 5;
        b = 10;
        System.out.println("a = " + a + ", b = " + b);
        if (a < b) {
            System.out.println("a is less than b");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("a is not less than b");
            System.out.println("TEST FAILED");
        }

        // Test for greater than or equal to
        a = 10;
        b = 10;
        System.out.println("a = " + a + ", b = " + b);
        if (a >= b) {
            System.out.println("a is greater than or equal to b");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("a is not greater than or equal to b");
            System.out.println("TEST FAILED");
        }

        // Test for less than or equal to
        a = 10;
        b = 10;
        System.out.println("a = " + a + ", b = " + b);
        if (a <= b) {
            System.out.println("a is less than or equal to b");
            System.out.println("TEST PASSED");
        } else {
            System.out.println("a is not less than or equal to b");
            System.out.println("TEST FAILED");
        }
    }
}
