import java.lang.System;

public class MultiLineCommentsTest {

    public static void main(String[] args) {
        /* This is a comment in multiline form */
        System.out.println("Single Multilined comment: Passed");

        // Normal comment
        System.out.println("Single singleline comment: Passed");

        /*
         * These
         * Are
         * Multiple
         * Lines
         * With
         * stars
         */

        System.out.println("Multiple * Multilined comments: Passed");

        /*
         * These
         * Are
         * Multiple
         * Lines
         * Without
         * stars
         */
        System.out.println("Multiple w/o * Multilined comments: Passed");

        /*
         * /
         * / Funky
         * / Multiline
         */
        System.out.println("Funky Multiple Multilined comments: Passed");

        /***/
        System.out.println("Tricky Multilined comment: Passed");

    }
}
