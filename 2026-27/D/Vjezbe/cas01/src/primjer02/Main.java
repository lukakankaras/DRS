package primjer02;

import primjer01.MyThread1;

public class Main {
    public static void main(String[] args) {
        MyThread2 logika = new MyThread2();
        Thread thread = new Thread(logika);
        thread.setPriority(10);
        thread.start();

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
