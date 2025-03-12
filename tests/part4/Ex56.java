import java.lang.System;

public class Ex56 {
    public static void main(String[] args) {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i != 10);
        if (i == 10) {
            System.out.println("Not Equal do-while passed");
        } else {
            System.out.println("Not Equal do-while failed");
        }

        int j = 10;
        do {
            System.out.println(j);
            j--;
        } while (j > 0);
        if (j == 0) {
            System.out.println("Greater than do-while passed");
        } else {
            System.out.println("Greater than do-while failed");
        }

        int k = 10;
        do {
            System.out.println(k);
            k--;
        } while (k >= 0);
        if (k == -1) {
            System.out.println("Greater than or equal do-while passed");
        } else {
            System.out.println("Greater than or equal do-while failed");
        }

        int l = 1;
        do {
            System.out.println(l);
            l *= 2;
        } while (l < 100);
        if (l >= 100) {
            System.out.println("less than do-while passed");
        } else {
            System.out.println("less than do-while failed");
        }

        int m = 0;
        do {
            System.out.println(m);
            m += 2;
        } while (m <= 20);
        if (m > 20) {
            System.out.println("less than or equal do-while passed");
        } else {
            System.out.println("less than or equal do-while failed");
        }

    }
}
