// INVALID
import java.lang.System;

public class IndexOutOfBounds {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(arr[0]);
        System.out.println(arr[9]);
        System.out.println(arr[10]);
    }
}
