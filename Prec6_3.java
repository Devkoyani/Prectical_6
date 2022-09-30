import java.lang.Thread;

public class Prec6_3 extends Thread {
    static int x = 14;

    public void run() {
        x++;
        System.out.println("\nDisplaying the incremented value of x(=14) after 1 second of sleep....");
        try {
            Thread.sleep(1000);
            System.out.println("\nIncremented Value of x :- " + x);
        } catch (InterruptedException ie) {
            System.out.println("The current Thread has been interrupted..!");
        }
    }

    public static void main(String[] args) {
        Prec6_3 sl1 = new Prec6_3();
        sl1.start();
    }
}

