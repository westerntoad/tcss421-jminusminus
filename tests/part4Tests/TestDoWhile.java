/**
 * A simple test file for the do while loop working as intended
 * @version 1.0
 * @author Corey Young
 */
class TestDoWhile {
    /*
     * Check for:
     * typical case
     * empty body
     * condition is false
     * empty body and condition is false
     */
    public static void main(String[] theArgs) {
        int counter = 0;
        do {
            counter++;
        } while (counter < 5);
        do {
            //no code
        } while (counter < 5);
        do {
            counter++;
        } while (false);
        do {
            //no code
        } while (false);
    }
}