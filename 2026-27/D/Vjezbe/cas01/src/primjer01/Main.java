package primjer01;

public class Main {
    // 1. nacin - extendovati klasu Thread

    public static void main(String[] args) {
        MyThread1 mojThread = new MyThread1();
        mojThread.start();

        for(int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("Desila se greska");
            }
            System.out.println(i);
        }
    }
}
