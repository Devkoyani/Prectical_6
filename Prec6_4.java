import java.lang.Thread;

public class Prec6_4 extends Thread {
    public void run() {
        System.out.println("This is run() method...");
    }

    public static void main(String[] args) {
        Thread FIRST = new Thread();
        Thread SECOND = new Thread();
        Thread THIRD = new Thread();

        FIRST.setPriority(3);
        // Priority of SECOND we want as Default, so no need to assign any priority to
        // it...
        THIRD.setPriority(7);

        System.out.println("\nPriority of FIRST :- " + FIRST.getPriority());
        System.out.println("Priority of SECOND :- " + SECOND.getPriority());
        System.out.println("Priority of THIRD :- " + THIRD.getPriority());
    }
}