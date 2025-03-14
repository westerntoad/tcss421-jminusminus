import java.lang.System;

public class Ex511 {

    private static void abeAssert(boolean cond, int num) {
        if (!cond) {
            System.out.println("Test " + num + " failed");
        }
    }

    public static void main(String[] args) {
        int a = true ? 10 : 0;
        abeAssert(a == 10, 1);

        boolean cond = false;
        char b = cond ? 'n' : 'y';
        abeAssert(b == 'y', 2);

        cond = !cond;
        boolean c = cond ? false : true;
        abeAssert(!c, 2);
    }
}
