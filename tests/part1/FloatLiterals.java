public class FloatLiterals {
    public static void main(String[] args) {

        // Decimal float values
        float decimal1 = 0.01f;
        float decimal2 = .0e+1f;
        float decimal3 = .1f;
        float decimal4 = 123.456f;
        float decimal5 = 789.0123f;
        float decimal6 = 1000.f;
        float decimal7 = 1.f;

        // Decimal floats with underscores
        float decimalWithUnderscores1 = 3_3__2.0f;
        float decimalWithUnderscores2 = 2_0.0_0f;
        float decimalWithUnderscores3 = 2___2.0__012_______2f;
        float decimalWithUnderscores4 = .0_1f;
        float decimalWithUnderscores5 = 1_234.567_89f;
        float decimalWithUnderscores6 = 0.000_001f;

        // Decimal floats with underscores and exponents
        float decimalWithUnderscoresAndExponents1 = 1_2.3_4e+5f;
        float decimalWithUnderscoresAndExponents2 = 1_2.3_4e-5f;
        float decimalWithUnderscoresAndExponents3 = 1_2.3_4e1_6f;
        float decimalWithUnderscoresAndExponents4 = 1_2.3_4e-1_6f;
        float decimalWithUnderscoresAndExponents5 = 1_2.3_4E+5f;
        float decimalWithUnderscoresAndExponents6 = 1_2.3_4E-5f;

        // Hexadecimal floats
        float hexFloat1 = 0x1.0p0f;
        float hexFloat2 = 0x1.8p1f;
        float hexFloat3 = 0x1.fp3f;
        float hexFloat4 = 0x1a.00p11f;
        float hexFloat5 = 0x1.0p-1f;
        float hexFloat6 = 0x1.0p-2f;

        // Print all values to verify correctness
        // System.out.println("Decimal floats:");
        // System.out.println(decimal1);
        // System.out.println(decimal2);
        // System.out.println(decimal3);
        // System.out.println(decimal4);
        // System.out.println(decimal5);
        // System.out.println(decimal6);
        // System.out.println(decimal7);

        // System.out.println("Decimal floats with underscores:");
        // System.out.println(decimalWithUnderscores1);
        // System.out.println(decimalWithUnderscores2);
        // System.out.println(decimalWithUnderscores3);
        // System.out.println(decimalWithUnderscores4);
        // System.out.println(decimalWithUnderscores5);
        // System.out.println(decimalWithUnderscores6);

        // System.out.println("Decimal floats with underscores and exponents:");
        // System.out.println(decimalWithUnderscoresAndExponents1);
        // System.out.println(decimalWithUnderscoresAndExponents2);
        // System.out.println(decimalWithUnderscoresAndExponents3);
        // System.out.println(decimalWithUnderscoresAndExponents4);
        // System.out.println(decimalWithUnderscoresAndExponents5);
        // System.out.println(decimalWithUnderscoresAndExponents6);

        // System.out.println("Hexadecimal floats:");
        // System.out.println(hexFloat1);
        // System.out.println(hexFloat2);
        // System.out.println(hexFloat3);
        // System.out.println(hexFloat4);
        // System.out.println(hexFloat5);
        // System.out.println(hexFloat6);
    }
}