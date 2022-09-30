import java.util.LinkedList;

public class Prec6_5 {
    static int size = 3;
    LinkedList<Integer> list = new LinkedList<>();

    synchronized void produce() throws InterruptedException {
        int val = 0;
        for (int i = 0; i < 3; i++) {
            while (list.size() == size) {
                wait();
            }

            System.out.println("Prducer produced : " + val);
            list.add(val++);
            notify();
            Thread.sleep(1000);
        }

    }

    synchronized void consume() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            while (list.size() == 0) {
                wait();
            }
            int val = list.removeFirst();
            System.out.println("Consumer consumed : " + val);
            notify();
            Thread.sleep(1000);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Producer_Consumer pc = new Producer_Consumer();
        Thread t1 = new Thread() {
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException ie) {
                    System.out.println("Thread Inturrupted !!");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException ie) {
                    System.out.println("Thread Inturrupted !!");
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}