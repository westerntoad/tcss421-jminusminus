/**
 * Test class. The purpose of this file is to verify that the compiler
 * recognizes valid text tokens. Because of this, the file looks like gibberish
 * since all it is is declaration and reassignment of variables.
 * NOTE: this only consists of valid tokens, does not test cases that should fail.
 * To test this file, run the command:
 * bin/j-- -t tests/myTests/ValidTextTokens.java | grep LITERAL
 *
 * If permission errors occur run:
 * chmod +x bin/j--
 * @version 1.0
 * @author Corey Young
 */
public class ValidTextTokens {
    public static void main(String[] theArgs) {
        boolean literalTrue = true;
        boolean literalFalse = false;

        boolean nullBool = null;
        char nullChar = null;
        String nullString = null;

        char a = 'a';
        char underscore = '_';
        char escapeChar = '\n';
        char tilde = '~';
        char numChar = '5';

        String emptyString = "";
        String oneSpaceString = " ";
        String underscoreString = "___";
        String oneQuoteMark = "\"";
        String oneBackSlash = "\\";
        String escapeCharTab = "\t";
        String nums = "2343.454";
        String multiLine = "line1\nline2";
        String helloWorld = "hello world";
        helloWorld = "Hello, World!";
        //Current j-- will not pick up the context that this should be a single string
        //Two string literals will be recognized as tokens
        String concatenated = "string1 " + "string2";
        textBlocks();
        comments();
    }
    /*
     * This method contains textBlocks.
     * NOTE: textblocks are not supported until Java v15+, because of this,
     * an IDE configured to a pre-java15 runtime will likely show warnings/errors.
     * This is fine, the purpose of this is to verify that the j-- compiler can
     * recognize textblocks as tokens and nothing else.
     */
    private static void textBlocks() {
        String emptyTextBlock = """""";
        String oneSpaceTextBlock = """ """;
        String textBlock = """ hello """;
        /* The following text blocks can appear odd in some terminals, though they are
         * being read properly. The j-- compiler simply treats the textblock TokenInfo
         * as though the token is on one line (the line it starts on). Using "| grep TEXT_BLOCK"
         * to test will not show that the entire text block is in fact being read.
         */
        String multiLineTextBlock = """ line1
                                         line2
                                         line3""";
        String numTextBlock = """
                                234
                                343.567
                                34E-56
                                """;
    }
    private static void comments() {
        //These should be ignored by the compiler
        //
        /**/
        /***/
        /*
        multi-line (which apparently is actually called "traditional"
         */
        /*
         *
         *
         *
         */
    }
}