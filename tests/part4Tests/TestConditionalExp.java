/**
 * A simple test file for the conditional expression working as intended
 * @version 1.0
 * @author Corey Young
 */
class TestFor {
    public static void main(String[] theArgs) {
        int counter = 0;
        String hello = true ? "world" : "error";
        String hello2 = false ? "error" : "world";
        hello = counter < 5 ? "world2" : "error";
        testLOrExp();
    }
    private void testLOrExp() {
        int counter = 0;
        if(true || throw new Exception()) {
            counter++;
        }
        if(false || counter == 1) {
            counter++;
        }
        if(false || counter < 0) {
            throw new Exception();
        }
    }
}