import java.lang.System;

public class Ex327 {
    public static void main(String[] args) {
        try {
            int result = 1 / 0;
        } catch (Exception e) {
            System.out.println("Error encountered as expected.");
        } finally {
            System.out.println("Finally print.");
        }
    }
}
