import java.lang.System;

public class Ex57 {
    public static void main(String[] args) {
        boolean fail = true;
        for (int i = 0; i != 10; i++) {
            System.out.println(i);
            if (i == 9) {
                System.out.println("Not Equal for loop passed");
                fail = !fail;
            }
        }
        if (fail) {
            System.out.println("Not Equal for loop failed");
        }
        fail = true;

        for (int j = 10; j > 0; j--) {
            System.out.println(j);
            if (j == 1) {
                System.out.println("Greater than for loop passed");
                fail = !fail;
            }
        }
        if (fail) {
            System.out.println("Greater than for loop failed");
        }
        fail = true;
        for (int k = 10; k >= 0; k--) {
            System.out.println(k);
            if (k == -1) {
                System.out.println("Greater than or equal for loop passed");
                fail = !fail;

            }
        }
        if (fail) {
            System.out.println("Greater than or equal for loop failed");
        }
        fail = true;

        for (int l = 1; l < 100; l = l * 2) {
            System.out.println(l);
            if (l >= 100) {
                System.out.println("less than for loop passed");
                fail = !fail;

            }
        }
        if (fail) {
            System.out.println("less than for loop failed");
        }
        fail = true;

        for (int m = 0; m <= 20; m += 2) {
            System.out.println(m);
            if (m > 20) {
                System.out.println("less than or equal for loop passed");
                fail = !fail;

            }
        }
        if (fail) {
            System.out.println("less than or equal for loop failed");
        }

    }
}
