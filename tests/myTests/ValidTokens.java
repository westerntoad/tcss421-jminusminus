/*
 * Test class. The purpose of this file is to verify that the compiler
 * recognizes valid numeric tokens and some other tokens. Because of this,
 * the file looks like gibberish since all it is is declaration and reassinment
 * of variables. NOTE: this only consists of valid tokens, does not test cases that
 * should fail.
 * To test this file, run the command:
 * bin/j-- -t tests/myTests/ValidTokens.java | grep LITERAL
 *
 * If permission errors occur run:
 * chmod +x bin/j--
 */
public class ValidTokens {
    public static void main(String[] theArgs) {
        intTesting();
        doublesTesting();
        doublesTestingSuffixLowerD();
        doublesTestingSuffixUpperD();
        doublesTestingUnderscores();
        doublesTestingUnderscoresSuffixes();
        floatTesting();
    }
    /* Decimal integer literals consist of:
     * 0
     * Non-zero digit followed by digits
     * Non-zero digit followed by undrescores and digits, ending with a digit
     * Optionally followed by 'l' or 'L' suffix denoting long type
     * Underscores can be mixed in but cannot lead or trail the number
     */
    private static void intTesting() {
        int num;
        num = 0;
        num = 1;
        num = 123;
        num = 1_2;
        num = 1___3____4;

        long numLong;
        numLong = 0l;
        numLong = 1l;
        numLong = 123l;
        numLong = 1_2l;
        numLong = 1___2___4l;

        numLong = 0L;
        numLong = 1L;
        numLong = 123L;
        numLong = 1_2L;
        numLong = 1___9__4L;

        //These will return INT_LITERALs because j-- does not yet recognize the context.
        numLong = 0;
        numLong = 1;
        numLong = 123;
        numLong = 1_2;
        numLong = 1___6___4;
    }

    /* Decimal floating point literals consist of:
     * Digit(s)
     * Digit(s) '.'
     * Digit(s) '.' digit(s)
     * Digit(s) 'e' or 'E' digit(s)
     * Digit(s) 'e' or 'E' '+' or '-' digit(s)
     * Digit(s) '.' 'e' or 'E' digit(s)
     * Digit(s) '.' 'e' or 'E' '+' or '-' digit(s)
     * Digit(s) '.' digit(s) 'e' or 'E' digit(s)
     * Digit(s) '.' digit(s) 'e' or 'E' '+' or '-' digit(s)
     * . digit(s)
     * . digit(s) 'e' or 'E' digit(s)
     * . digit(s) 'e' or 'E' '+' or '-' digit(s)
     * Optionally followed by 'd', 'D', 'f', or 'F' suffix denoting double or float type
     * Underscores can be mixed in anywhere but cannot lead or trail
     * ex: _34, 26_., 56_, 35_., 34_e3, 26e_7, 39E9_ are all not allowed
     */
    private static void doublesTesting() {
        double num;
        // Digit(s)
        num = 0;
        num = 1;
        num = 32;
        // Digit(s) '.'
        num = 0.;
        num = 1.;
        num = 32.;
        // Digit(s) '.' digit(s)
        num = 0.0;
        num = 1.2;
        num = 32.0;
        num = 0.00;
        num = 1.234;
        num = 32.05646;
        // Digit(s) 'e' or 'E' digit(s)
        num = 4e4;
        num = 42e49;
        num = 4E4;
        num = 42E49;
        // Digit(s) 'e' or 'E' '+' or '-' digit(s)
        num = 4e+4;
        num = 42e+49;
        num = 4E+4;
        num = 42E+49;
        num = 4e-4;
        num = 42e-49;
        num = 4E-4;
        num = 42E-49;
        // Digit(s) '.' 'e' or 'E' digit(s)
        num = 4.e4;
        num = 42.e49;
        num = 4.E4;
        num = 42.E49;
        // Digit(s) '.' 'e' or 'E' '+' or '-' digit(s)
        num = 4.e+4;
        num = 42.e+49;
        num = 4.E+4;
        num = 42.E+49;
        num = 4.e-4;
        num = 42.e-49;
        num = 4.E-4;
        num = 42.E-49;
        // Digit(s) '.' digit(s) 'e' or 'E' digit(s)
        num = 4.3e4;
        num = 42.7e49;
        num = 4.9E4;
        num = 42.7E49;
        num = 4.5e+4;
        num = 42.7e+49;
        num = 4.4E+4;
        num = 42.6E+49;
        num = 4.3e-4;
        num = 42.3e-49;
        num = 4.2E-4;
        num = 42.8E-49;
        // Digit(s) '.' digit(s) 'e' or 'E' '+' or '-' digit(s)
        num = 4.34e4;
        num = 42.67e49;
        num = 4.93E4;
        num = 42.67E49;
        num = 4.57e+4;
        num = 42.47e+49;
        num = 4.43E+4;
        num = 42.26E+49;
        num = 4.36e-4;
        num = 42.83e-49;
        num = 4.29E-4;
        num = 42.08E-49;
        // . digit(s)
        num = .0;
        num = .2;
        num = .407;
        // . digit(s) 'e' or 'E' digit(s)
        num = .0e6;
        num = .2e84;
        num = .407e76;
        num = .0E6;
        num = .2E84;
        num = .407E76;
        // . digit(s) 'e' or 'E' '+' or '-' digit(s)
        num = .0e+6;
        num = .2e+84;
        num = .407e+76;
        num = .0E+6;
        num = .2E+84;
        num = .407E+76;
        num = .0e-6;
        num = .2e-84;
        num = .407e-76;
        num = .0E-6;
        num = .2E-84;
        num = .407E-76;
    }
    private static void doublesTestingSuffixUpperD() {
        double num;
        // Digit(s)
        num = 0D;
        num = 1D;
        num = 32D;
        // Digit(s) '.'
        num = 0.D;
        num = 1.D;
        num = 32.D;
        // Digit(s) '.' digit(s)
        num = 0.0D;
        num = 1.2D;
        num = 32.0D;
        num = 0.00D;
        num = 1.234D;
        num = 32.05646D;
        // Digit(s) 'e' or 'E' digit(s)
        num = 4e4D;
        num = 42e49D;
        num = 4E4D;
        num = 42E49D;
        // Digit(s) 'e' or 'E' '+' or '-' digit(s)
        num = 4e+4D;
        num = 42e+49D;
        num = 4E+4D;
        num = 42E+49D;
        num = 4e-4D;
        num = 42e-49D;
        num = 4E-4D;
        num = 42E-49D;
        // Digit(s) '.' 'e' or 'E' digit(s)
        num = 4.e4D;
        num = 42.e49D;
        num = 4.E4D;
        num = 42.E49D;
        // Digit(s) '.' 'e' or 'E' '+' or '-' digit(s)
        num = 4.e+4D;
        num = 42.e+49D;
        num = 4.E+4D;
        num = 42.E+49D;
        num = 4.e-4D;
        num = 42.e-49D;
        num = 4.E-4D;
        num = 42.E-49D;
        // Digit(s) '.' digit(s) 'e' or 'E' digit(s)
        num = 4.3e4D;
        num = 42.7e49D;
        num = 4.9E4D;
        num = 42.7E49D;
        num = 4.5e+4D;
        num = 42.7e+49D;
        num = 4.4E+4D;
        num = 42.6E+49D;
        num = 4.3e-4D;
        num = 42.3e-49D;
        num = 4.2E-4D;
        num = 42.8E-49D;
        // Digit(s) '.' digit(s) 'e' or 'E' '+' or '-' digit(s)
        num = 4.34e4D;
        num = 42.67e49D;
        num = 4.93E4D;
        num = 42.67E49D;
        num = 4.57e+4D;
        num = 42.47e+49D;
        num = 4.43E+4D;
        num = 42.26E+49D;
        num = 4.36e-4D;
        num = 42.83e-49D;
        num = 4.29E-4D;
        num = 42.08E-49D;
        // . digit(s)
        num = .0D;
        num = .2D;
        num = .407D;
        // . digit(s) 'e' or 'E' digit(s)
        num = .0e6D;
        num = .2e84D;
        num = .407e76D;
        num = .0E6D;
        num = .2E84D;
        num = .407E76D;
        // . digit(s) 'e' or 'E' '+' or '-' digit(s)
        num = .0e+6D;
        num = .2e+84D;
        num = .407e+76D;
        num = .0E+6D;
        num = .2E+84D;
        num = .407E+76D;
        num = .0e-6D;
        num = .2e-84D;
        num = .407e-76D;
        num = .0E-6D;
        num = .2E-84D;
        num = .407E-76D;
    }
    private static void doublesTestingSuffixLowerD() {
        double num;
        // Digit(s)
        num = 0d;
        num = 1d;
        num = 32d;
        // Digit(s) '.'
        num = 0.d;
        num = 1.d;
        num = 32.d;
        // Digit(s) '.' digit(s)
        num = 0.0d;
        num = 1.2d;
        num = 32.0d;
        num = 0.00d;
        num = 1.234d;
        num = 32.05646d;
        // Digit(s) 'e' or 'E' digit(s)
        num = 4e4d;
        num = 42e49d;
        num = 4E4d;
        num = 42E49d;
        // Digit(s) 'e' or 'E' '+' or '-' digit(s)
        num = 4e+4d;
        num = 42e+49d;
        num = 4E+4d;
        num = 42E+49d;
        num = 4e-4d;
        num = 42e-49d;
        num = 4E-4d;
        num = 42E-49d;
        // Digit(s) '.' 'e' or 'E' digit(s)
        num = 4.e4d;
        num = 42.e49d;
        num = 4.E4d;
        num = 42.E49d;
        // Digit(s) '.' 'e' or 'E' '+' or '-' digit(s)
        num = 4.e+4d;
        num = 42.e+49d;
        num = 4.E+4d;
        num = 42.E+49d;
        num = 4.e-4d;
        num = 42.e-49d;
        num = 4.E-4d;
        num = 42.E-49d;
        // Digit(s) '.' digit(s) 'e' or 'E' digit(s)
        num = 4.3e4d;
        num = 42.7e49d;
        num = 4.9E4d;
        num = 42.7E49d;
        num = 4.5e+4d;
        num = 42.7e+49d;
        num = 4.4E+4d;
        num = 42.6E+49d;
        num = 4.3e-4d;
        num = 42.3e-49d;
        num = 4.2E-4d;
        num = 42.8E-49d;
        // Digit(s) '.' digit(s) 'e' or 'E' '+' or '-' digit(s)
        num = 4.34e4d;
        num = 42.67e49d;
        num = 4.93E4d;
        num = 42.67E49d;
        num = 4.57e+4d;
        num = 42.47e+49d;
        num = 4.43E+4d;
        num = 42.26E+49d;
        num = 4.36e-4d;
        num = 42.83e-49d;
        num = 4.29E-4d;
        num = 42.08E-49d;
        // . digit(s)
        num = .0d;
        num = .2d;
        num = .407d;
        // . digit(s) 'e' or 'E' digit(s)
        num = .0e6d;
        num = .2e84d;
        num = .407e76d;
        num = .0E6d;
        num = .2E84d;
        num = .407E76d;
        // . digit(s) 'e' or 'E' '+' or '-' digit(s)
        num = .0e+6d;
        num = .2e+84d;
        num = .407e+76d;
        num = .0E+6d;
        num = .2E+84d;
        num = .407E+76d;
        num = .0e-6d;
        num = .2e-84d;
        num = .407e-76d;
        num = .0E-6d;
        num = .2E-84d;
        num = .407E-76d;
    }
    /*
     * Shortend form of doublesTesting that adds underscores
     */
    private static void doublesTestingUnderscores() {
        double num;
        //This will return INT_LITERALs because j-- does not yet recognize the context.
        num = 3_2;
        num = 3_2.;
        num = 3_2.0;
        num = 0.0_0;
        num = 1.2__34;
        num = 3_2.05_6_46;
        num = 4_2e4_9;
        num = 4_2E4_9;
        num = 4_2e+4_9;
        num = 4_2E+4_9;
        num = 4_2e-4_9;
        num = 4_2E-4_9;
        num = 4__2.e4__9;
        num = 4____2.E4_9;
        num = 4_2.e+4_9;
        num = 4_2.E+4_9;
        num = 4_2.e-4_9;
        num = 4_2.E-4_9;
        num = 4_2.7e4_9;
        num = 4_2.7E4_9;
        num = 4_2.7e+4_9;
        num = 4_2.6E+4_9;
        num = 4_2.3e-4_9;
        num = 4_2.8E-4_9;
        num = 4.3_4e4;
        num = 4_2.6_7e4_9;
        num = 4.9_3E4;
        num = 4_2.6_7E4_9;
        num = 4.5_7e+4;
        num = 4_2.4_7e+4_9;
        num = 4.4_3E+4;
        num = 4_2.2_6E+4_9;
        num = .4_0__7;
        num = .2e8__4;
        num = .4_07e7_6;
        num = .2E8_4;
        num = .4_07E7_6;
        num = .2e+8_4;
        num = .40_7e+7_6;
        num = .2E+8_4;
        num = .40_7E+7_6;
        num = .2e-8_4;
        num = .4_07e-7_6;
        num = .2E-8_4;
        num = .4_0_7E-7_6;
    }
    /*
     * Shortened form of doubles underscore and suffix upper and lower d combined.
     */
    private static void doublesTestingUnderscoresSuffixes() {
        double num;
        num = 3_2d;
        num = 3_2.D;
        num = 3_2.0d;
        num = 0.0_0D;
        num = 1.2__34d;
        num = 3_2.05_6_46D;
        num = 4_2e4_9d;
        num = 4_2E4_9D;
        num = 4_2e+4_9d;
        num = 4_2E+4_9D;
        num = 4_2e-4_9d;
        num = 4_2E-4_9D;
        num = 4__2.e4__9d;
        num = 4____2.E4_9D;
        num = 4_2.e+4_9d;
        num = 4_2.E+4_9D;
        num = 4_2.e-4_9d;
        num = 4_2.E-4_9D;
        num = 4_2.7e4_9d;
        num = 4_2.7E4_9D;
        num = 4_2.7e+4_9d;
        num = 4_2.6E+4_9D;
        num = 4_2.3e-4_9d;
        num = 4_2.8E-4_9D;
        num = 4.3_4e4d;
        num = 4_2.6_7e4_9D;
        num = 4.9_3E4d;
        num = 4_2.6_7E4_9D;
        num = 4.5_7e+4d;
        num = 4_2.4_7e+4_9D;
        num = 4.4_3E+4d;
        num = 4_2.2_6E+4_9D;
        num = .4_0__7d;
        num = .2e8__4D;
        num = .4_07e7_6d;
        num = .2E8_4D;
        num = .4_07E7_6d;
        num = .2e+8_4D;
        num = .40_7e+7_6d;
        num = .2E+8_4D;
        num = .40_7E+7_6d;
        num = .2e-8_4D;
        num = .4_07e-7_6d;
        num = .2E-8_4D;
        num = .4_0_7E-7_6d;
    }
    /*
     * Shortened doubles test with floats
     */
    private static void floatTesting() {
        float num;
        num = 3_2f;
        num = 3_2.F;
        num = 3_2.0f;
        num = 0.0_0F;
        num = 1.2__34f;
        num = 3_2.05_6_46F;
        num = 4_2e1_1f;
        num = 4_2E1_1F;
        num = 4_2e+1_2f;
        num = 4_2E+2_9F;
        num = 4_2e-3_9f;
        num = 4_2E-3_9F;
        num = 4__2.e3__2f;
        num = 4____2.E3_1F;
        num = 4_2.e+3_0f;
        num = 4_2.E+2_9F;
        num = 4_2.e-2_9f;
        num = 4_2.E-2_9F;
        num = 4_2.7e2_9f;
        num = 4_2.7E2_9F;
        num = 4_2.7e+2_9f;
        num = 4_2.6E+2_9F;
        num = 4_2.3e-2_9f;
        num = 4_2.8E-2_9F;
        num = 4.3_4e4f;
        num = 4_2.6_7e2_9F;
        num = 4.9_3E4f;
        num = 4_2.6_7E2_9F;
        num = 4.5_7e+4f;
        num = 4_2.4_7e+2_9F;
        num = 4.4_3E+4f;
        num = 4_2.2_6E+1_9F;
        num = .4_0__7f;
        num = .2e1__4F;
        num = .4_07e1_6f;
        num = .2E2_4F;
        num = .4_07E2_6f;
        num = .2e+3_4F;
        num = .40_7e+3_6f;
        num = .2E+3_4F;
        num = .40_7E+3_6f;
        num = .2e-3_4F;
        num = .4_07e-3_6f;
        num = .2E-3_4F;
        num = .4_0_7E-1_6f;
    }

}