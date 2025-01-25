public class IntLiterals {
    public static void main(String[] args) {

        // Valid decimal
        int decimal1 = 0;
        int decimal2 = 10;
        int decimal3 = 123456789;
        int decimal4 = 1__13__942__21__94;

        // Invalid decimal
        int invalidDecimal1 = _0;
        int invalidDecimal2 = 53_;
        int invalidDecimal3 = _00__3_1;
        int invalidDecimal4 = 23892__18_;

        // Valid binary values
        int binary1 = 0b0;
        int binary2 = 0b1;
        int binary3 = 0b1010100011101;
        int binary4 = 0b11_1001_1000111;

        // Invalid binary values
        int invalidBinary1 = 0b_1;
        int invalidBinary2 = 0b1_;
        int invalidBinary3 = 0b111211;
        int invalidBinary4 = 0b23456789;
        int invalidBinary5 = 0b_1__11;
        int invalidBinary6 = 0b101011_;

        // Octal values
        int octal1 = 010;
        int octal2 = 00010;
        int octal3 = 01101342;
        int octal4 = 0123;
        int octal5 = 0765;
        int octal6 = 00000123;

        // Invalid octal values
        int invalidOctal1 = _0023241;
        int invalidOctal2 = 012345_;
        int invalidOctal3 = 0110357181;
        int invalidOctal4 = 0123456789;
        int invalidOctal5 = 01234967;

        // Hexadecimal values
        int hex1 = 0x123456789abcdef;
        int hex2 = 0xa;
        int hex3 = 0xb;
        int hex4 = 0xc;
        int hex5 = 0xd;
        int hex6 = 0xe;
        int hex7 = 0xf;
        int hex8 = 0xfe79a8f79cdef8;
        int hex9 = 0x1_23_efa___f_bc90__2;

        // Invalid hexadecimal values
        int invalidHex1 = 0x_1343f;
        int invalidHex2 = 0x2351_;
        int invalidHex3 = 0_x1fd3;
        int invalidHex4 = _0x1fa23;
    }
}
