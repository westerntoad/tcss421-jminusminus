/**
 * A simple test file for the do while loop working as intended
 * @version 1.0
 * @author Corey Young
 */
class TestFor {
    /*
     * Check for:
     * typical case
     * no body
     * false condition
     * multiple inits
     * multiple updates
     * multiple inits and updates
     */
    public static void main(String[] theArgs) {
        int counter = 0;
        for(int i = 0; i < 5; i++) {
            counter++;
        }
        for(int i = 0; i < 5; i++) {
            //no code body
        }
        for(int i = 0; false; i++) {
            counter++;
        }
        for(int i = 0, j = 0, k = 6; i < 5; i++) {
            counter++;
        }
        for(int i = 0; i < 5; i++, counter++) {
            counter += 2;
        }
        for(int i = 0, j = 0, k = 6; i < 5; i++, j++, k--) {
            counter -= 2;
        }
    }
}