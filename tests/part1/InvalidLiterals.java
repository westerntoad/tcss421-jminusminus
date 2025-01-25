public class InvalidLiterals {
    public static void main(String[] args) {
        // Invalid integer
        int invalidDecimal1 = _0;
        int invalidDecimal2 = 53_;
        int invalidDecimal3 = _00__3_1;
        int invalidDecimal4 = 23892__18_;

        // Invalid binary
        int invalidBinary1 = 0b_1;
        int invalidBinary2 = 0b1_;
        int invalidBinary3 = 0b111211;
        int invalidBinary4 = 0b23456789;
        int invalidBinary5 = 0b_1__11;
        int invalidBinary6 = 0b101011_;

        // Invalid octal
        int invalidOctal1 = _0023241;
        int invalidOctal2 = 012345_;
        int invalidOctal3 = 0110357181;
        int invalidOctal4 = 0123456789;
        int invalidOctal5 = 01234967;
        int invalidOctal6 = 08;

        // Invalid hexadecimal integer
        int invalidHex1 = 0x_1343f;
        int invalidHex2 = 0x2351_;
        int invalidHex3 = 0_x1fd3;
        int invalidHex4 = _0x1fa23;

        // Invalid float
        float invalidFloat1 = 0013e+1f.5;

        // Invalid hexadecimal floats
        float hexFloat1 = 0x.1p1;

    }
}