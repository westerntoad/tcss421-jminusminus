public class ValidLiterals {
    public static void main(String[] args) {
        // Decimal int
        int decimal2 = 0181;
        int decimal1 = 0;
        int decimal2 = 10;
        int decimal3 = 123456789;
        int decimal4 = 1__13__942__21__94;

        // Decimal long
        long long1 = 123456789L;
        long long2 = 987654321l;
        long long3 = 1_000_000_000L;
        long long4 = 42l;
        long long5 = 9_876_543_210L;
        long long6 = 0L;
        long long7 = 123456789l;
        long long8 = 9223372036854775807L;
        long long10 = 314159265L;

        // Binary
        int binary1 = 0b0;
        int binary2 = 0b1;
        int binary3 = 0b1010100011101;
        int binary4 = 0b11_1001_1000111;

        // Binary long
        long binaryLong1 = 0b1010_1010_1010_1010l;
        long binaryLong2 = 0B1111_0000_1111_0000L;
        long binaryLong3 = 0b1_0_1_0_1_1_0_0L;
        long binaryLong4 = 0b0111111111111111111111111111111111111111111111111111111111111111L;
        long binaryLong5 = 0b0000_0000_0000_0000L;
        long binaryLong6 = 0b1_0000000_1_0000_1l;
        long binaryLong7 = 0b10000000_00000000L;
        long binaryLong8 = 0b1010__10101010101l;
        long binaryLong9 = 0b1_0L;
        long binaryLong10 = 0b110101L;

        // Octal
        int octal1 = 010;
        int octal2 = 00010;
        int octal3 = 01_101342;
        int octal4 = 0123;
        int octal5 = 0765;
        int octal6 = 000__00123;

        // Octal long
        long octalLong1 = 01234567L;
        long octalLong2 = 07654321l;
        long octalLong3 = 01L;
        long octalLong4 = 077_7_7_7_7777_77L;
        long octalLong5 = 07000000L;
        long octalLong6 = 00L;
        long octalLong7 = 01234567l;
        long octalLong8 = 0777L;
        long octalLong9 = 012345l;
        long octalLong10 = 05___55___55_5L;
        long octalLong11 = 000_000_000L;

        // Hexadecimal int
        int hexDecimal1 = 0x123456789abcdef;
        int hexDecimal2 = 0xa;
        int hexDecimal3 = 0xb;
        int hexDecimal4 = 0xc;
        int hexDecimal5 = 0xd;
        int hexDecimal6 = 0xe;
        int hexDecimal7 = 0xf;
        int hexDecimal8 = 0xfe79a8f79cdef8;
        int hexDecimal9 = 0x1_23_efa___f_bc90__2;

        // Hexadecimal long
        long hexLong1 = 0x1A2B_3CL;
        long hexLong2 = 0x7F8E_9Dl;
        long hexLong3 = 0x0l;
        long hexLong4 = 0xFFFF_FFFF_FFFFL;
        long hexLong5 = 0xABC_DEF1_2345L;
        long hexLong6 = 0x1234_5678_9l;
        long hexLong7 = 0xCAFEBABEl;
        long hexLong8 = 0xDEAD_BEEFl;
        long hexLong9 = 0x0BAD_F00Dl;
        long hexLong10 = 0x1234_ABCDl;
        long hexLong11 = 0xAA3L;
        long hexLong12 = 0x1F2E3DL;
        long hexLong13 = 0xABC_D__EF123L;

        // Decimal float
        float float1 = 0.01f;
        float float2 = .0e+1f;
        float float3 = .1f;
        float float4 = 123.456f;
        float float5 = 789.0123f;
        float float6 = 1000.f;
        float float7 = 001120001f;
        float float8 = 3_3__2.0f;
        float float9 = 2_0.0_0f;
        float float10 = 2___2.0__012_______2f;
        float float11 = .0_1f;
        float float12 = 1_234.567_89f;
        float float13 = 0.000_001f;
        float float14 = 1_2.3_4e+5f;
        float float15 = 1_2.3_4e-5f;
        float float16 = 1_2.3_4e1_6f;
        float float17 = 1_2.3_4e-1_6f;
        float float18 = 1_2.3_4E+5f;
        float float19 = 1_2.3_4E-5f;
        float float20 = 0008f;
        float float21 = 01f;
        float float22 = 01234591f;

        // Hexadecimal float
        float hexFloat1 = 0x1.0p0f;
        float hexFloat2 = 0x1.8p1f;
        float hexFloat3 = 0x1.fp3f;
        float hexFloat4 = 0x1a.00p11f;
        float hexFloat5 = 0x1.0p-1f;
        float hexFloat6 = 0x1.0p-2f;
        float hexFloat7 = 0xff.ffp+1f;
        float hexFloat8 = 0x.1p1f;
        float hexFloat16 = 0xff.1p1f;

        // Decimal double
        double double1 = 0.01d;
        double double2 = .0e+1;
        double double3 = .1;
        double double4 = 123.456;
        double double5 = 789.0123d;
        double double6 = 1000.;
        double double7 = 11e2f;
        double double8 = 3_3__2.0;
        double double9 = 2_0.0_0;
        double double10 = 2___2.0__012_______2d;
        double double11 = .0_1;
        double double12 = 1_234.567_89;
        double double13 = 10.000_001;
        double double14 = 101.e1;
        double double15 = 1_2.3_4e+5;
        double double16 = 1_2.3_4e-5;
        double double17 = 1_2.3_4e5_6;
        double double18 = 1_2.3_4e-5_6;
        double double19 = 1_2.3_4E+5;
        double double20 = 1_2.3_4E-5;
        double double21 = 001d;
        double double21 = 082391d;

        // Hexadecimal double
        double hexDouble1 = 0xAp-5;
        double hexDouble2 = 0x165498F.9AAp3;
        double hexDouble3 = 0x1.fp3;
        double hexDouble4 = 0x1a.00p11;
        double hexDouble5 = 0x1.0p0;
        double hexDouble6 = 0x1.8p1;
    }
}
