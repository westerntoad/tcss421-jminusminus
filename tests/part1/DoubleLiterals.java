public class DoubleLiterals {
    public static void main(String[] args) {

        // Decimal double values
        double decimal1 = 0.01d;
        double decimal2 = .0e+1;
        double decimal3 = .1;
        double decimal4 = 123.456;
        double decimal5 = 789.0123d;
        double decimal6 = 1000.;
        double decimal7 = 11e2f;

        // Decimal doubles with underscores
        double decimalWithUnderscores1 = 3_3__2.0;
        double decimalWithUnderscores2 = 2_0.0_0;
        double decimalWithUnderscores3 = 2___2.0__012_______2d;
        double decimalWithUnderscores4 = .0_1;
        double decimalWithUnderscores5 = 1_234.567_89;
        double decimalWithUnderscores6 = 10.000_001;
        double decimalWithUnderscores7 = 101.e1;

        // Decimal doubles with underscores and exponents
        double decimalWithUnderscoresAndExponents1 = 1_2.3_4e+5;
        double decimalWithUnderscoresAndExponents2 = 1_2.3_4e-5;
        double decimalWithUnderscoresAndExponents3 = 1_2.3_4e5_6;
        double decimalWithUnderscoresAndExponents4 = 1_2.3_4e-5_6;
        double decimalWithUnderscoresAndExponents5 = 1_2.3_4E+5;
        double decimalWithUnderscoresAndExponents6 = 1_2.3_4E-5;

        // Hexadecimal doubles
        double hexDouble1 = 0xAp-5;
        double hexDouble2 = 0x165498F.9AAp3;
        double hexDouble3 = 0x1.fp3;
        double hexDouble4 = 0x1a.00p11;
        double hexDouble5 = 0x1.0p0;
        double hexDouble6 = 0x1.8p1;

    }
}
