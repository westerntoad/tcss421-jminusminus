import java.lang.System;

public class NewOperatorsTest {
    public static void main(String[] args) {
        // Demonstrating the 26 new operators
        boolean result;
        int a = 0;
        int b = 0;
        // EQ
        result = a == b;

        // LE
        result = a <= b;

        // GT
        result = a > b;

        // AND
        result = (a < b) && (a > b);

        // OR
        result = (a < b) || (a > b);

        // ADD
        int sum = a + b;

        // SUB
        int diff = a - b;

        // MUL
        int product = a * b;

        // DIV
        int quotient = a / b;

        // MOD
        int remainder = a % b;

        // BSHIFTL
        int leftShift = a << 2;

        // BSHIFTR
        int rightShift = a >> 2;

        // BSSHIFTR
        int unsignedRightShift = a >>> 2;

        // MINUS_ASSIGN
        a -= b;

        // MUL_ASSIGN
        a *= b;

        // DIV_ASSIGN
        a /= b;

        // BAND_ASSIGN
        a &= b;

        // BOR_ASSIGN
        a |= b;

        // BXOR_ASSIGN
        a ^= b;

        // MOD_ASSIGN
        a %= b;

        // BSHIFTL_ASSIGN
        a <<= 2;

        // BSHIFTR_ASSIGN
        a >>= 2;

        // BSSHIFTR_ASSIGN
        a >>>= 2;

        // LT
        result = a < b;

        // BCOMP
        a = ~a;

        // TERN_TRUE and TERN_FALSE
        int max = (a > b) ? a : b;

        // LAMBDA
        Runnable lambda = () -> System.out.println("Lambda executed");

        // GE
        result = a >= b;

        // NOT_EQUAL
        result = a != b;

        // LOR
        result = (a < b) || (a > b);
    }
}