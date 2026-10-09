public class Main {
    public static void main(String[] args) {
        Counter c = new Counter();

        Lock l = new LamportLock(3);

        Thread t1 = new Thread(new MyThread(0, c, l));
        Thread t2 = new Thread(new MyThread(1, c, l));
        Thread t3 = new Thread(new MyThread(2, c, l));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
//            t3.join();

            System.out.println("Counter ima vrijednost: " + c.value);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
