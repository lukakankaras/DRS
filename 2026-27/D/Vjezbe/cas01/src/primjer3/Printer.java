package primjer3;

public class Printer implements Runnable {
    volatile boolean prekini = false;

    @Override
    public void run() {
        while(!prekini) {
            System.out.println("Ja stampam...");
            try {
                Thread.sleep(400);
            } catch(InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
