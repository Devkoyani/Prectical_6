import java.io.IOException;
import java.lang.Math;

public class Prec6_2 extends Thread {
    static int[] arr = new int[16];
    static int i, max = 100, min = 1, range = max - min + 1;

    public static void generate_randnum() {
        System.out.println("Randomly Generated Numbers :-");
        for (i = 0; i < 15; i++) {
            arr[i] = (int) (Math.random() * range) + min;
            System.out.println("arr[" + i + "]  :  " + arr[i]);
        }
    }


    public static void main(String[] args) throws IOException {
        Thread t1 = new Thread() {
            public void run() {
                System.out.println("\nFirst Thread.....");
                System.out.println("Numbers at Even Index :");
                for (i = 0; i < 15; i += 2) {
                    System.out.println(arr[i]);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                System.out.println("\nSecond Thread.....");
                System.out.println("Numbers at Odd Index :");
                for (i = 1; i < 15; i += 2) {
                    System.out.println(arr[i]);
                }
            }
        };
        generate_randnum();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("An Exception has been caught !!");
        }
        t2.start();
    }
}