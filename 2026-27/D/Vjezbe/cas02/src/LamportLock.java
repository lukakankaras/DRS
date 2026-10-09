import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class LamportLock implements Lock {
    final int n;
    AtomicBoolean[] choosing;
    AtomicInteger[] numbers;

    public LamportLock(int n) {
        this.n = n;
        choosing = new AtomicBoolean[n];
        numbers = new AtomicInteger[n];

        for(int i = 0; i < n; i++) {
            choosing[i] = new AtomicBoolean(false);
            numbers[i] = new AtomicInteger(0);
        }
    }

    @Override
    public void enter(int id) {
        choosing[id].set(true);
        for(int i = 0; i < n; i++) {
            if(numbers[i].get() > numbers[id].get()) {
                numbers[id].set(numbers[i].get());
            }
        }
        numbers[id].set(numbers[id].get() + 1);
        choosing[id].set(false);

        for(int i = 0; i < n; i++) {
            while(choosing[i].get());
            while(
                numbers[i].get() != 0 &&
                (numbers[id].get() < numbers[i].get() ||
                (numbers[id].get() == numbers[i].get() && id < i))
            );
        }
    }

    @Override
    public void exit(int id) {
        numbers[id].set(0);
    }
}
