public class FloatLiterals {
    public static void main(String[] args) {

        // valid float
        float float1 = 0f;
        float float2 = 001f;
        float float3 = 00031.4e+1f;
        float float4 = 00031e+1f;

        // invalid float
//        float invalidFloat1 = 0013e+1f.5;

        // valid hexadecimal float
        float hexFloat1 = 0x1.0p0f;
        float hexFloat2 = 0x1.8p1f;
        float hexFloat3 = 0x1.fp3f;
        float hexFloat4 = 0x1a.00p11f;
        float hexFloat5 = 0x1.0p-1f;
        float hexFloat6 = 0x1.0p-2f;
        float hexFloat7 = 0xff.ffp+1f;

        // Decimal float values
        float decimal1 = 0.01f;
        float decimal2 = .0e+1f;
        float decimal3 = .1f;
        float decimal4 = 123.456f;
        float decimal5 = 789.0123f;
        float decimal6 = 1000.f;
        float decimal7 = 001120001f;
        float decimal8 = 0xff.1p1f;

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

    }
}