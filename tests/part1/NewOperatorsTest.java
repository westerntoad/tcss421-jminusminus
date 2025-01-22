// INVALID

import java.lang.System;

public class NewOperatorsTest {
    public static void main(String[] args) {
        // Demonstrating the 26 new operators

        int a = 10, b = 20;
        boolean result;

        // LT
        result = a < b;
        System.out.println("a < b: " + result);

        // BCOMP
        System.out.println("~a: " + ~a);

        // TERN_TRUE and TERN_FALSE
        int max = (a > b) ? a : b;
        System.out.println("Max of a and b: " + max);

        // TODO: LAMBDA
        Runnable lambda = () -> System.out.println("Lambda executed");
        // GE
        result = a >= b;
        System.out.println("a >= b: " + result);

        // NOT_EQUAL
        result = a != b;
        System.out.println("a != b: " + result);

        // LOR
        result = (a < b) || (a > b);
        System.out.println("(a < b) || (a > b): " + result);

        // DIV
        System.out.println("a / b: " + (a / b));

        // BAND
        System.out.println("a & b: " + (a & b));

        // BOR
        System.out.println("a | b: " + (a | b));

        // BXOR
        System.out.println("a ^ b: " + (a ^ b));

        // MOD
        System.out.println("a % b: " + (a % b));

        // BSHIFTL
        System.out.println("a << 2: " + (a << 2));

        // BSHIFTR
        System.out.println("a >> 2: " + (a >> 2));

        // BSSHIFTR
        System.out.println("a >>> 2: " + (a >>> 2));

        // MINUS_ASSIGN
        a -= b;
        System.out.println("a -= b: " + a);

        // MUL_ASSIGN
        a *= b;
        System.out.println("a *= b: " + a);

        // DIV_ASSIGN
        a /= b;
        System.out.println("a /= b: " + a);

        // BAND_ASSIGN
        a &= b;
        System.out.println("a &= b: " + a);

        // BOR_ASSIGN
        a |= b;
        System.out.println("a |= b: " + a);

        // BXOR_ASSIGN
        a ^= b;
        System.out.println("a ^= b: " + a);

        // MOD_ASSIGN
        a %= b;
        System.out.println("a %= b: " + a);

        // BSHIFTL_ASSIGN
        a <<= 2;
        System.out.println("a <<= 2: " + a);

        // BSHIFTR_ASSIGN
        a >>= 2;
        System.out.println("a >>= 2: " + a);

        // BSSHIFTR_ASSIGN
        a >>>= 2;
        System.out.println("a >>>= 2: " + a);
    }
}
