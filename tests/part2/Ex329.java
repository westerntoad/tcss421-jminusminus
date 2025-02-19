import java.lang.System;

public class Ex328 {

    public static int five() throws Exception {
        return 5;
    }
    
    public static void main(String[] args) {
        System.out.println("Throws in method headers.");
        System.out.println(five());
    }
}
