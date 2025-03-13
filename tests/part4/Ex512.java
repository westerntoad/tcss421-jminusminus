import java.lang.System;

public class Ex512 {

    public static void main(String[] args) {
        // Test for conditional AND (&&) operation
        if (true && true) {
            System.out.println("true && true: Passed");
        } else {
            System.out.println("true && true: Failed");
        }

        if (true && false) {
            System.out.println("true && false: Failed");
        } else {
            System.out.println("true && false: Passed");
        }

        if (false && true) {
            System.out.println("false && true: Failed");
        } else {
            System.out.println("false && true: Passed");
        }

        if (false && false) {
            System.out.println("false && false: Failed");
        } else {
            System.out.println("false && false: Passed");
        }

        // Test for conditional OR (||) operation
        if (true || true) {
            System.out.println("true || true: Passed");
        } else {
            System.out.println("true || true: Failed");
        }

        if (true || false) {
            System.out.println("true || false: Passed");
        } else {
            System.out.println("true || false: Failed");
        }

        if (false || true) {
            System.out.println("false || true: Passed");
        } else {
            System.out.println("false || true: Failed");
        }

        if (false || false) {
            System.out.println("false || false: Passed");
        } else {
            System.out.println("false || false: Failed");
        }

        // Nested conditional operations
        if ((true && true) || (false && true)) {
            System.out.println("(true && true) || (false && true): Passed");
        } else {
            System.out.println("(true && true) || (false && true): Failed");
        }

        if ((true && false) || (false || true)) {
            System.out.println("(true && false) || (false || true): Passed");
        } else {
            System.out.println("(true && false) || (false || true): Failed");
        }

        if ((false || false) && (true || false)) {
            System.out.println("(false || false) && (true || false): Failed");
        } else {
            System.out.println("(false || false) && (true || false): Passed");
        }
    }
}