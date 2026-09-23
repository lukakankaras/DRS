package primjer01;

public class MyThread1 extends Thread {

    @Override
    public void run() {
        int i = 0;

        while(true) {
            try {
                Thread.sleep(1500);
            } catch(InterruptedException e) {
                System.out.println("Desila se greska");
            }
            System.out.println("Ja sam ziv " + i);
            i += 1;
        }
    }
}
