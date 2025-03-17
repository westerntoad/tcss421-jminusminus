/**
 * A simple test file for the do while loop working in error cases
 * @version 1.0
 * @author Corey Young
 */
class TestDoWhileFail {
    /*
     * Check for:
     * Empty while
     * always true condition
     */
    public static void main(String[] theArgs) {
        int counter = 0;
        do {
            counter++;
        } while ();
        do {
            counter++;
        } while (true);
    }
}