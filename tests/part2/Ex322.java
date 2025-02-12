public class ValidLiterals {
    public static void main(String[] args) {
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
    }
}
