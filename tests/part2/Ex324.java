import java.lang.System;

public class Ex324 {
    public static void main(String[] args) {
        boolean a = true;

        String out = a ? "Working properly." : "Not working properly.";

        System.out.println(out);

        if (a ? true : false) {
            System.out.println("yes");
        }
    }
}
