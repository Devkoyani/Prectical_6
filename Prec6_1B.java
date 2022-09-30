public class Prec6_1B implements Runnable {

    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String args[]) {
        (new Thread(new Prec6_1B())).start();
    }
}