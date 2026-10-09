public class MyThread implements Runnable {
    final int id;
    Counter counter;
    Lock lock;

    public MyThread(int id, Counter counter, Lock lock) {
        this.id = id;
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000; i++) {
            lock.enter(id);
            counter.value += 1;
            lock.exit(id);
        }
    }
}
